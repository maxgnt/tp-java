package com.isitech.bibliotheque.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static String format(LocalDate date) {
        if (date == null) return "N/A";
        return date.format(FORMATTER);
    }


    public static boolean isFuture(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }


    public static LocalDate ajouterJours(LocalDate date, int jours) {
        if (date == null) return null;
        return date.plusDays(jours);
    }
}
