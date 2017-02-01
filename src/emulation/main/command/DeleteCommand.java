package emulation.main.command;

import emulation.main.PriceListManager;

import java.io.IOException;

public class DeleteCommand extends BaseCommand {
    @Override
    public void execute() throws IOException {
        PriceListManager.delete();
    }
}
