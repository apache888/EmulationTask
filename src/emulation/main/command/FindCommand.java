package emulation.main.command;

import emulation.main.PriceListManager;

import java.io.IOException;

public class FindCommand extends BaseCommand {
    @Override
    public void execute() throws IOException {
        PriceListManager.findProduct();
    }
}
