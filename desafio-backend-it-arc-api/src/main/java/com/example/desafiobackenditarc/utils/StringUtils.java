package com.example.desafiobackenditarc.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern NON_ASCII_PATTERN = Pattern.compile("[^\\p{ASCII}]");

    public static String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return NON_ASCII_PATTERN.matcher(normalized).replaceAll("");
    }

    public static boolean compareStrings(String str1, String str2) {
        String normalizedStr1 = normalizeString(str1);
        String normalizedStr2 = normalizeString(str2);
        return normalizedStr1.equalsIgnoreCase(normalizedStr2);
    }
}
