package Optional.Commands;

import Optional.Items.Catalog;

public class ListCommand extends Command {


    public ListCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    public static void list(Catalog catalog) {
        var myList = catalog.getItems();
        if (myList.size() == 0) {
            System.out.println("Catalog is empty");
            return;
        }
        System.out.println(catalog.getName());
        myList.forEach(System.out::println);
    }
}
