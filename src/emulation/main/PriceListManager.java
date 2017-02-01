package emulation.main;

import emulation.main.product.BaseProduct;
import emulation.main.product.ProductType;
import emulation.main.product.SmartPhone;
import emulation.main.product.SmartWatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListManager {
    public static final Map<Integer, BaseProduct> priceList = new HashMap<>();

    public static void addProduct() throws IOException {
        BaseProduct product = getProductByType();
        product.init();
        priceList.put(product.getId(), product);
    }

    public static void changeProduct() throws IOException {
        ProductType productType = getProductType();
        switch (productType) {
            case SmartPhone:
                printCategoryOfPrice(SmartPhone.class);
                break;
            case SmartWatch:
                printCategoryOfPrice(SmartWatch.class);
                break;
        }
        ConsoleHelper.writeMessage("Input ID which you want change");
        int id = ConsoleHelper.readInt();
        priceList.get(id).changeProductAttribute();

    }

    public static void delete() throws IOException {
        while (true) {
            try {
                ConsoleHelper.writeMessage("");
                ConsoleHelper.writeMessage("Select category to delete:");
                ConsoleHelper.writeMessage(String.format("\t %s :ALL:", "all"));
                ConsoleHelper.writeMessage(String.format("\t %d :Smartphone:", ProductType.SmartPhone.ordinal()));
                ConsoleHelper.writeMessage(String.format("\t %d :Smartwatch:", ProductType.SmartWatch.ordinal()));
                switch (ConsoleHelper.readString()) {
                    case "all":
                        priceList.clear();
                        return;
                    case "0":
                        for (Map.Entry<Integer, BaseProduct> pair : priceList.entrySet()) {
                            if (pair.getValue().getClass().equals(SmartPhone.class)) {
                                priceList.remove(pair.getKey());
                            }
                        }
                        return;
                    case "1":
                        for (Map.Entry<Integer, BaseProduct> pair : priceList.entrySet()) {
                            if (pair.getValue().getClass().equals(SmartWatch.class)) {
                                priceList.remove(pair.getKey());
                            }
                        }
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("This category inaccessible. Try again");
            }
        }
    }

    public static void findProduct() throws IOException {
        ProductType productType = getProductType();
        switch (productType) {
            case SmartPhone:
                findByAttribute(SmartPhone.class);
                break;
            case SmartWatch:
                findByAttribute(SmartWatch.class);
                break;
        }
    }

    private static void findByAttribute(Class clazz) throws IOException {
        ConsoleHelper.writeMessage("Example string for find:\n" +
                "id>3 and id<7 or name=asus or cost>150 and cost<500");
        List<BaseProduct> finded;
        String inputData = ConsoleHelper.readString().trim();
        if (inputData.startsWith("id")) {
            finded = findById(clazz, inputData);
        } else if (inputData.startsWith("name")) {
            finded = findByName(clazz, inputData);
        } else if (inputData.startsWith("cost")) {
            finded = findByCost(clazz, inputData);
        } else {
            ConsoleHelper.writeMessage("*ERROR* Incorrect find parameter");
            throw new IllegalArgumentException();
        }
        ConsoleHelper.writeMessage("Find result");
        for (BaseProduct baseProduct : finded) {
            ConsoleHelper.writeMessage(baseProduct.toString());
        }
    }

    private static List<BaseProduct> findByName(Class clazz, String inputData) {
        List<BaseProduct> finded = new ArrayList<>();
        String symbol = inputData.substring(4, 5);
        String findName = inputData.substring(5);
        if (symbol.equals("=")){
            for (BaseProduct baseProduct : priceList.values()) {
                if (baseProduct.getClass().equals(clazz)) {
                    if (baseProduct.getName().contains(findName)) {
                        finded.add(baseProduct);
                    }
                }
            }
        } else {
            ConsoleHelper.writeMessage("*ERROR* Incorrect find parameter");
            throw new IllegalArgumentException();
        }
        return finded;
    }

    private static List<BaseProduct> findByCost(Class clazz, String inputData) {
        List<BaseProduct> finded = new ArrayList<>();
        String symbol = inputData.substring(4, 5);
        int findCost = Integer.parseInt(inputData.substring(5));
        switch (symbol) {
            case ">":
                for (BaseProduct baseProduct : priceList.values()) {
                    if (baseProduct.getClass().equals(clazz)) {
                        if (baseProduct.getCost() > findCost) {
                            finded.add(baseProduct);
                        }
                    }
                }
                break;
            case "<":
                for (BaseProduct baseProduct : priceList.values()) {
                    if (baseProduct.getClass().equals(clazz)) {
                        if (baseProduct.getCost() < findCost) {
                            finded.add(baseProduct);
                        }
                    }
                }
                break;
            default:
                ConsoleHelper.writeMessage("*ERROR* Incorrect find parameter");
                throw new IllegalArgumentException();
        }
        return finded;
    }

    private static List<BaseProduct> findById(Class clazz, String inputData) {
        List<BaseProduct> finded = new ArrayList<>();
        String symbol = inputData.substring(2, 3);
        int findId = Integer.parseInt(inputData.substring(3));
        switch (symbol) {
            case ">":
                for (BaseProduct baseProduct : priceList.values()) {
                    if (baseProduct.getClass().equals(clazz)) {
                        if (baseProduct.getId() > findId) {
                            finded.add(baseProduct);
                        }
                    }
                }
                break;
            case "<":
                for (BaseProduct baseProduct : priceList.values()) {
                    if (baseProduct.getClass().equals(clazz)) {
                        if (baseProduct.getId() < findId) {
                            finded.add(baseProduct);
                        }
                    }
                }
                break;
            default:
                ConsoleHelper.writeMessage("*ERROR* Incorrect find parameter");
                throw new IllegalArgumentException();
        }
        return finded;
    }

    private static ProductType getProductType() throws IOException {
        while (true) {
            try {
                ConsoleHelper.writeMessage("");
                ConsoleHelper.writeMessage("Select category:");
                ConsoleHelper.writeMessage(String.format("\t %d :Smartphone:", ProductType.SmartPhone.ordinal()));
                ConsoleHelper.writeMessage(String.format("\t %d :Smartwatch:", ProductType.SmartWatch.ordinal()));

                switch (ConsoleHelper.readInt()) {
                    case 0:
                        return ProductType.SmartPhone;
                    case 1:
                        return ProductType.SmartWatch;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("This category inaccessible. Try again");
            }
        }
    }

    private static BaseProduct getProductByType() throws IOException {
        while (true) {
            try {
                ConsoleHelper.writeMessage("");
                ConsoleHelper.writeMessage("Select category:");
                ConsoleHelper.writeMessage(String.format("\t %d :Smartphone:", ProductType.SmartPhone.ordinal()));
                ConsoleHelper.writeMessage(String.format("\t %d :Smartwatch:", ProductType.SmartWatch.ordinal()));

                switch (ConsoleHelper.readInt()) {
                    case 0:
                        return new SmartPhone();
                    case 1:
                        return new SmartWatch();
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("This category inaccessible. Try again");
            }
        }
    }

    public static void printPrice() {
        for (BaseProduct product : priceList.values()) {
            ConsoleHelper.writeMessage(product.toString());
        }
        ConsoleHelper.writeMessage("=============================================================");
    }
    private static void printCategoryOfPrice(Class clazz) {
        for (BaseProduct baseProduct : priceList.values()) {
            if (baseProduct.getClass().equals(clazz)){
                ConsoleHelper.writeMessage(baseProduct.toString());
            }
        }
    }
}
