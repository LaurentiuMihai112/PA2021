package app;

import java.util.Locale;
import java.util.Scanner;

import static com.DisplayLocales.displayLocales;
import static com.Info.info;
import static com.SetLocale.setLocale;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!"exit".equals(input)) {
            System.out.print("Your command >>> ");
            input = scanner.nextLine();
            if (input.startsWith("info")) {
                if (input.length() > 4) {
                    String locale = input.split(" ")[1];
                    try {
                        info(new Locale(locale.substring(0, 2), locale.substring(3)));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        info(Locale.getDefault());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input.startsWith("set locale")) {
                String locale = input.split(" ")[2];
                setLocale(locale);
            } else if ("display locales".equals(input)) {
                displayLocales();
            } else {
                System.out.println("Not a valid command");
            }
        }
    }

}
