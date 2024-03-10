package com.schoolproject.movie_rentaldashboard.dao.mysql.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatToStringHelper {
    public static String convertDateToString(Date actionDateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(actionDateTime);
        return formattedDateTime;
    }
    /**
     * We'll use this to get the log date and time:
     * import java.sql.Timestamp;
     *
     * public class TimestampExample {
     *     public static void main(String[] args) {
     *         // Create a Timestamp object with the current date and time
     *         Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
     *
     *         System.out.println("Current Timestamp: " + currentTimestamp);
     *
     *         // You can also create a Timestamp from a specific date and time
     *         Timestamp specificTimestamp = Timestamp.valueOf("2022-01-01 12:30:45");
     *
     *         System.out.println("Specific Timestamp: " + specificTimestamp);
     *     }
     * }
     */
}
