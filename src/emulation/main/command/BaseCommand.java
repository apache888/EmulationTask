package emulation.main.command;

import emulation.main.PriceListManager;

public abstract class BaseCommand implements Command {

    public PriceListManager getPriceListManager(){
        return new PriceListManager();
    }
}
