package emulation.main.product;

import emulation.main.ConsoleHelper;
import emulation.main.PriceListManager;

import java.io.IOException;
import java.util.IllegalFormatException;

public class SmartPhone extends BaseProduct {

    private String os; // may be use enum
    private int coreNumber;
    private int ram; //Gb
//    private int hdd; //Gb


    @Override
    public void init() throws IOException {
        ConsoleHelper.writeMessage("Input smartphone Id:  <Example - 7>");
        while (true) {
            setId(ConsoleHelper.readInt());
            if (PriceListManager.priceList.containsKey(getId())){
                ConsoleHelper.writeMessage("This ID already exists. Input other ID");
            } else break;
        }

        ConsoleHelper.writeMessage("Input smartphone name:  <Example - Apple Iphone 7S>");
        this.setName(ConsoleHelper.readString());

        ConsoleHelper.writeMessage("Input smartphone OS:  <Example - Android>");
        this.setOs(ConsoleHelper.readString());

        ConsoleHelper.writeMessage("Input smartphone number of cores:  <Example - 2>");
        this.setCoreNumber(ConsoleHelper.readInt());

        ConsoleHelper.writeMessage("Input smartphone RAM, Gb:  <Example - 2>");
        this.setRam(ConsoleHelper.readInt());

        ConsoleHelper.writeMessage("Input smartphone price, $:  <Example - 99.99>");
        this.setCost(Double.parseDouble(ConsoleHelper.readString()));  // may be make readDouble in ConsoleHelper

    }

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
                    case 3:
                        ConsoleHelper.writeMessage("Input data for id=" + getId() + " column 3");
                        setOs(ConsoleHelper.readString());
                        return;
                    case 4:
                        ConsoleHelper.writeMessage("Input data for id=" + getId() + " column 4");
                        setCoreNumber(ConsoleHelper.readInt());
                        return;
                    case 5:
                        ConsoleHelper.writeMessage("Input data for id=" + getId() + " column 5");
                        setRam(ConsoleHelper.readInt());
                        return;
                    case 6:
                        ConsoleHelper.writeMessage("Input data for id=" + getId() + " column 6");
                        setCost(Double.parseDouble(ConsoleHelper.readString()));
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalFormatException e) {
                ConsoleHelper.writeMessage("Wrong column number. Try again.");
            }
        }
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "" + this.getId() + "\t\t" + this.getName() + "\t\t\t" + this.getOs() + "\t\t\t"
                + this.getCoreNumber() + " cores\t\t\t" + this.getRam() + "Gb RAM\t\t\t" + this.getCost() + "$";
    }
}
