package Compulsory.Items;

import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) {
        String path = catalog.getPath();
        String name = catalog.getName();
        try {
            FileOutputStream fileOut = new FileOutputStream(path + name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(catalog);
            out.close();
            fileOut.close();
            System.out.printf("Catalog data is saved in %s%s\n", path, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Catalog load(String path) {
        Catalog catalog = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            catalog = (Catalog) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
