package Optional.Commands;

import Optional.Items.Catalog;
import Optional.Items.Item;

public class AddCommand extends Command {

    public AddCommand(String command, Catalog catalog, Item item) {
        super(command, catalog, item);
    }

    public static void add(Catalog catalog, Item item) {
        var myList=catalog.getItems();
        myList.add(item);
        catalog.setItems(myList);
    }


}
