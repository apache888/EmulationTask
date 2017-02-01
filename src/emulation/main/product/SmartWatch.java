package emulation.main.product;

import emulation.main.ConsoleHelper;
import emulation.main.PriceListManager;

import java.io.IOException;

public class SmartWatch extends BaseProduct {
    @Override
    public void init() throws IOException {
        ConsoleHelper.writeMessage("Input smartwatch Id:  <Example - 7>");
        while (true) {
            setId(ConsoleHelper.readInt());
            if (PriceListManager.priceList.containsKey(getId())){
                ConsoleHelper.writeMessage("This ID already exists. Input other ID");
            } else break;
        }

        ConsoleHelper.writeMessage("Input smartwatch name:  <Example - Apple watch 7S>");
        this.setName(ConsoleHelper.readString());

        ConsoleHelper.writeMessage("Input smartwatch price, $:  <Example - 99.99>");
        this.setCost(Double.parseDouble(ConsoleHelper.readString()));
    }

    @Override
    public void changeProductAttribute() throws IOException {
        ConsoleHelper.writeMessage("Input column number which you want change");
        while (true) {
            try {
                switch (ConsoleHelper.readInt()) {
                    case 1:
                        ConsoleHelper.writeMessage("Input data for id=" + getId() + " column 1");
                        setId(ConsoleHelper.readInt());
                        return;
                    case 2:
                        ConsoleHelper.writeMessage("Input data for id=" + getId() + " column 2");
                        setName(ConsoleHelper.readString());
                        return;
                    case 6:
                        ConsoleHelper.writeMessage("Input data for id=" + getId() + " column 6");
                        setCost(Double.parseDouble(ConsoleHelper.readString()));
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Wrong column number. Try again.");
            }
        }
    }

    @Override
    public String toString() {
        return this.getId() + "\t\t" + this.getName()
                + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + this.getCost() + "$";
    }
}
