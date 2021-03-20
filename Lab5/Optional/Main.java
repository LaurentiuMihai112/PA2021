package Optional;

import Optional.Commands.*;
import Optional.Exceptions.IncorrectNameException;
import Optional.Exceptions.IncorrectPathException;
import Optional.Items.*;
import Optional.Items.Image;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("", "");
        String type, name, path;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a name for the catalog:");
        catalog.setName(myObj.nextLine());
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
                        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
                        cfg.setDirectoryForTemplateLoading(new File("G:/Test/"));
                        cfg.setDefaultEncoding("UTF-8");
                        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                        cfg.setLogTemplateExceptions(false);
                        cfg.setWrapUncheckedExceptions(true);
                        cfg.setFallbackOnNullLoopVariable(false);

                        Map<String, Object> report = new HashMap<>();

                        report.put("name", catalog.getName());
                        report.put("items", catalog.getItems());

                        Template temp = cfg.getTemplate("t.html");

                        Writer fileWriter = new FileWriter(new File("G:/" + catalog.getName() + " report.html"));
                        try {
                            temp.process(report, fileWriter);

                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            fileWriter.close();
                        }
                        Item other = new Other(catalog.getName() + " report", "G:/" + catalog.getName() + " report.html");
                        File file = new File(other.getLocation());
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.open(file);
                        } catch (Exception e1) {
                            System.out.println(e1.getMessage());
                        }
                    }
                    case "quit" -> System.exit(0);
                    default -> throw new IncorrectNameException("Not a valid command");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
