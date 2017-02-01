package emulation.main.command;

import emulation.main.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Program closed.");
    }
}
