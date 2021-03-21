package Optional.Commands;

import Optional.Items.Catalog;
import Optional.Items.Item;

public abstract class Command {
    String Command;
    Catalog catalog;
    Item item;

    public Command(String command, Catalog catalog, Item item) {
        Command = command;
        this.catalog = catalog;
        this.item = item;
    }

    public Command(String command, Catalog catalog) {
        Command = command;
        this.catalog = catalog;
    }
}
