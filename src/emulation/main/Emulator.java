package emulation.main;

import emulation.main.command.CommandExecutor;

import java.io.IOException;

public class Emulator {
    public static void main(String[] args){
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Wrong data. Input it correctly.");
            }
        } while (operation != Operation.EXIT);

    }

    private static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Commands:");
        ConsoleHelper.writeMessage(String.format("\t %d :add: - add product in Price List", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d :change: - change product in Price List", Operation.CHANGE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d :delete: - delete product from Price List", Operation.DELETE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d :find: - find product in Price List", Operation.FIND.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d :print: - print products which are in Price List", Operation.PRINT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d :exit: - close program", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}
