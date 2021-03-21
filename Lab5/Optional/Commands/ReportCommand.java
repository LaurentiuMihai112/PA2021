package Optional.Commands;

import Optional.Items.Catalog;
import Optional.Items.Item;
import Optional.Items.Other;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command {
    public ReportCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    public static void report(Catalog catalog) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("G:/Test/"));
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);


        Map<String, Object> report = new HashMap<>();

        report.put("name", catalog.getName());
        report.put("items", catalog.getItems());

        Template temp = cfg.getTemplate("template.html");

        Writer fileWriter = new FileWriter("G:/" + catalog.getName() + " report.html");
        try {
            temp.process(report, fileWriter);

        } catch (IOException | TemplateException e) {
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
}
