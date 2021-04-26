package Optional.Commands;

import Optional.Items.Catalog;
import Optional.Items.Item;

import java.awt.*;
import java.io.File;

public class PlayCommand extends Command {
    public PlayCommand(String command, Catalog catalog, Item item) {
        super(command, catalog, item);
    }

    public static void play(Catalog catalog, Integer id) {
        Item item = catalog.findById(id);
        File file = new File(item.getLocation());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }

    public static void play(Catalog catalog) {
        for (var item : catalog.getItems()) {

            File file = new File(item.getLocation());
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
    }
}
