package com.example.kluxury.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class HandleDateTime {

    public static long convertDateTimeToLong(LocalDate localDate){
        ZoneId zoneId = ZoneId.systemDefault();
        return localDate.atStartOfDay(zoneId).toEpochSecond();
    }

    public static LocalDate convertLongToLocalDate(Long localDateLong){
        return Instant.ofEpochMilli(localDateLong).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static void main(String[] args) {
        Long date = convertDateTimeToLong(LocalDate.now());
        System.out.println(date);
    }
}
