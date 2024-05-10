package ua.bielskyi.tracker.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static final String DEFAULT_DATE_PATTER = "dd.MM.yyyy";
    public static final DateTimeFormatter FORMATTER_DATE_PATTERN = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTER);
    public static final Map<String, Integer> currencyCodes = Currency.getAvailableCurrencies()
            .stream()
            .collect(Collectors.toMap(Currency::getCurrencyCode, Currency::getNumericCode));

    public static LocalDateTime getLocalDateTimeFromString(String date, DateTimeFormatter dateTimeFormatter) {
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        return localDate.atStartOfDay();
    }

    public static String getStringDateByPattern(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime.format(dateTimeFormatter);
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static long getTimestamp(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public static float getRate(float buyRate, float sellRate) {
        return (buyRate + sellRate) / 2;
    }
}
