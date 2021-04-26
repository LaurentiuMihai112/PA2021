package Compulsory;

import Compulsory.Items.Catalog;
import Compulsory.Items.Image;
import Compulsory.Items.Item;
import Compulsory.Items.Song;

import static Compulsory.Items.CatalogUtil.*;

public class Main {
    public static void main(String[] args) {

        Item myItem1 = new Song("Dua Lipa - New Rules.mp3", "G:\\Muzica\\Dua Lipa - New Rules.mp3", 2000);
        Item myItem2 = new Song("Echo_-_Dezvaluiri_2013_Videoclip_official_.mp3", "G:\\Muzica\\Echo_-_Dezvaluiri_2013_Videoclip_official_.mp3", 2000);
        Item myItem3 = new Song("Ellie Goulding - Love Me Like You Do.mp3", "G:\\Muzica\\Ellie Goulding - Love Me Like You Do.mp3", 2000);
        Item myItem4 = new Song("Gioni - Trigger.mp3", "G:\\Muzica\\Gioni - Trigger.mp3", -1);
        Item myItem5 = new Image("sharingan.png", "G:\\Poze\\sharingan.png");

        Catalog catalog = new Catalog("Some_Things", "G:\\Test\\");
        catalog.add(myItem1);
        catalog.add(myItem2);
        catalog.add(myItem3);
        catalog.add(myItem4);
        catalog.add(myItem5);
        catalog.list();
        catalog.play(myItem5);
        catalog.play(myItem4);
        save(catalog);
        Catalog otherCatalog;
        otherCatalog = load("G:\\Test\\Some_Things");
        otherCatalog.list();

    }
}
