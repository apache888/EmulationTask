package emulation.main.command;

import emulation.main.PriceListManager;

import java.io.IOException;

public class ChangeCommand extends BaseCommand {
    @Override
    public void execute() throws IOException {
        PriceListManager.changeProduct();
    }
}
