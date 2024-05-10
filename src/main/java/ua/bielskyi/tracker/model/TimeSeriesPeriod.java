package ua.bielskyi.tracker.model;

public enum TimeSeriesPeriod {
    SECOND_1("1SEC"),
    SECOND_2("2SEC"),
    SECOND_3("3SEC"),
    SECOND_4("4SEC"),
    SECOND_5("5SEC"),
    SECOND_6("6SEC"),
    SECOND_10("10SEC"),
    SECOND_15("15SEC"),
    SECOND_20("20SEC"),
    SECOND_30("30SEC"),
    MINUTE_1("1MIN"),
    MINUTE_2("2MIN"),
    MINUTE_3("3MIN"),
    MINUTE_4("4MIN"),
    MINUTE_5("5MIN"),
    MINUTE_6("6MIN"),
    MINUTE_10("10MIN"),
    MINUTE_15("15MIN"),
    MINUTE_20("20MIN"),
    MINUTE_30("30MIN"),
    HOUR_1("1HRS"),
    HOUR_2("2HRS"),
    HOUR_3("3HRS"),
    HOUR_4("4HRS"),
    HOUR_6("6HRS"),
    HOUR_8("8HRS"),
    HOUR_12("12HRS"),
    DAY_1("1DAY"),
    DAY_2("2DAY"),
    DAY_3("3DAY"),
    DAY_5("5DAY"),
    DAY_7("7DAY"),
    DAY_10("10DAY");

    private final String periodIdentifier;

    TimeSeriesPeriod(String periodIdentifier) {
        this.periodIdentifier = periodIdentifier;
    }

    public String getPeriodIdentifier() {
        return periodIdentifier;
    }
}
