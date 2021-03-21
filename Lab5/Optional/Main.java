package Optional;

import Optional.Commands.*;
import Optional.Exceptions.IncorrectNameException;
import Optional.Exceptions.IncorrectPathException;
import Optional.Items.*;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("", "");
        String type, name, path;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a name for the catalog:");
        catalog.setName(myObj.nextLine());
        System.out.println("Press help for more");
        while (true) {
            System.out.print("Enter command >>> ");
            String command = myObj.nextLine();
            String[] arguments = command.split(" ");
            try {
                if (arguments.length > 1)
                    throw new IncorrectNameException("Not a valid command");
                switch (arguments[0].toLowerCase()) {
                    case "add" -> {
                        System.out.println("Enter a type: (song,movie,image,other)");
                        type = myObj.nextLine();
                        System.out.println("Enter a name:");
                        name = myObj.nextLine();
                        System.out.println("Enter a path:");
                        path = myObj.nextLine();
                        try {
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                        } catch (IncorrectPathException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        switch (type.toLowerCase()) {
                            case "song" -> {
                                Item song = new Song(name, path);
                                AddCommand.add(catalog, song);
                            }
                            case "movie" -> {
                                Item movie = new Movie(name, path);
                                AddCommand.add(catalog, movie);
                            }
                            case "other" -> {
                                Item other = new Other(name, path);
                                AddCommand.add(catalog, other);
                            }
                            case "image" -> {
                                Item image = new Image(name, path);
                                AddCommand.add(catalog, image);
                            }
                            default -> throw new IncorrectNameException("Not a valid type");
                        }
                        System.out.println("Successfully added!");
                    }
                    case "save" -> {
                        System.out.println("Enter a path:");
                        path = myObj.nextLine();
                        try {
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                            SaveCommand.save(catalog, path);
                        } catch (IncorrectPathException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case "list" -> {
                        System.out.println("Listing...");
                        ListCommand.list(catalog);
                    }
                    case "load" -> {
                        System.out.println("Enter a path:");
                        path = myObj.nextLine();
                        try {
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                            catalog = LoadCommand.load(path);
                        } catch (IncorrectPathException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case "play" -> {
                        System.out.println("Enter an id:");
                        Integer key = myObj.nextInt();
                        PlayCommand.play(catalog, key);
                        System.out.println("Playing");
                    }
                    case "report" -> {
                        ReportCommand.report(catalog);
                    }
                    case "quit" -> System.exit(0);
                    case "help" -> {
                        System.out.println("Available commands:");
                        System.out.println("add");
                        System.out.println("list");
                        System.out.println("save");
                        System.out.println("load");
                        System.out.println("play");
                        System.out.println("report");
                        System.out.println("quit");
                    }
                    default -> throw new IncorrectNameException("Not a valid command");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
