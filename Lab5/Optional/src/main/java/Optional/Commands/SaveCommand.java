package Optional.Commands;

import Optional.Items.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command {
    public SaveCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    public static void save(Catalog catalog, String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path + catalog.getName());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(catalog);
            out.close();
            fileOut.close();
            System.out.printf("Optional.Items.Catalog data is saved in %s%s\n", path, catalog.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
