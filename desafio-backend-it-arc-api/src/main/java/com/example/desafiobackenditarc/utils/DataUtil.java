package com.example.desafiobackenditarc.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class DataUtil {
    private static final List<String> DATE_FORMATS = Arrays.asList(
            "yyyy-MM-dd HH:mm:ss.SSS",
            "yyyy-MM-dd"
    );

    public static Date stringToDate(String date) {
        for (String format : DATE_FORMATS) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            try {
                return formatter.parse(date);
            } catch (ParseException e) {
                // Ignore and try the next format
            }
        }
        log.error("Unable to parse date: " + date);
        return null;
    }
}