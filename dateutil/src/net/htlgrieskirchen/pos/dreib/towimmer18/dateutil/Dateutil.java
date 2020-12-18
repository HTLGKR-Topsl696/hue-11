/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos.dreib.towimmer18.dateutil;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author towimmer18
 */
public class Dateutil {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = LocalDateTime.of(2020, Month.MARCH, 1, 13, 59);
        
        LocalDateTime t = getTimeBetween(then, now);
        System.out.println("Years: " + t.getYear());
        System.out.println("Months: " + t.getMonth().getValue());
        System.out.println("Days: " + t.getDayOfMonth());
        System.out.println("Hours: " + t.getHour());
        System.out.println("Minutes: " + t.getMinute());
        System.out.println("Seconds: " + t.getSecond());
        
        Scanner sc = new Scanner(System.in);
        String dateLine = sc.nextLine();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime l = LocalDateTime.parse(dateLine, df);
    }

    public static LocalDateTime getTimeBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);
        
        int years = (int) tempDateTime.until(toDateTime, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears(years);

        int months = (int) tempDateTime.until(toDateTime, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(months);

        int days = (int) tempDateTime.until(toDateTime, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(days);

        int hours = (int) tempDateTime.until(toDateTime, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(hours);

        int minutes = (int) tempDateTime.until(toDateTime, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes(minutes);

        int seconds = (int) tempDateTime.until(toDateTime, ChronoUnit.SECONDS);

        return LocalDateTime.of(years, Month.of(months), days, hours, minutes);
    }
}
