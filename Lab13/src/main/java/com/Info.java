package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    public static void info(Locale locale) {
        System.out.println("Country : " + locale.getCountry());
        System.out.println("Language : " + locale.getLanguage());
        System.out.println("Currency : " + Currency.getInstance(locale));
        var dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        System.out.print("Week Days : ");
        for (int i = 1; i < 7; i++) {
            System.out.print(dateFormatSymbols.getWeekdays()[i] + ',');
        }
        System.out.println(dateFormatSymbols.getWeekdays()[7]);
        System.out.print("Months : ");
        for (int i = 0; i < 12; i++) {
            System.out.print(dateFormatSymbols.getMonths()[i] + ',');
        }
        System.out.println(dateFormatSymbols.getMonths()[11]);
        System.out.println("Date Today : " + DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(new Date()));

    }
}
