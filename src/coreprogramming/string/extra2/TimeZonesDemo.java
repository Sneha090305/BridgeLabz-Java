package coreprogramming.string.extra2;

import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZonesDemo {
    public static void main(String[] args) {

        System.out.println("GMT: " + ZonedDateTime.now(ZoneId.of("GMT")));
        System.out.println("IST: " + ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
        System.out.println("PST: " + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
    }
}

