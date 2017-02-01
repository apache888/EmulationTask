package emulation.main.command;

import emulation.main.PriceListManager;

public class PrintCommand extends BaseCommand {
    @Override
    public void execute() {
        PriceListManager.printPrice();
    }
}
