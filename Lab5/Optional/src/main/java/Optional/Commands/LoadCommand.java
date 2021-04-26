package Optional.Commands;

import Optional.Items.Catalog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command {
    public LoadCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    public static Catalog load(String path) {
        Catalog catalog = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            catalog = (Catalog) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }
        return catalog;

    }
}
