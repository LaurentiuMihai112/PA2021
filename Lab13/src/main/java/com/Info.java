package com;

import util.Message;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    private static final Message messageRO = new Message("res/Messages_ro.properties");
    private static final Message messageEN = new Message("res/Messages.properties");

    public static void info(Locale locale, Message message) {
        System.out.println(message.getCountry() + " " + locale.getCountry());
        System.out.println(message.getLanguage() + " " + locale.getLanguage());
        System.out.println(message.getCurrency() + " " + Currency.getInstance(locale));
        var dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        System.out.print(message.getWeek() + " ");
        for (int i = 1; i < 7; i++) {
            System.out.print(dateFormatSymbols.getWeekdays()[i] + ", ");
        }
        System.out.println(dateFormatSymbols.getWeekdays()[7]);
        System.out.print(message.getMonths() + " ");
        for (int i = 0; i < 12; i++) {
            System.out.print(dateFormatSymbols.getMonths()[i] + ", ");
        }
        System.out.println(dateFormatSymbols.getMonths()[11]);
        System.out.println(message.getToday() + " " + DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(new Date()));
    }
}
