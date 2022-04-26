package com.example.kluxury.utils;

import com.example.kluxury.service.order.OrderServiceImpl;

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

}
