package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Sample01 {

    public static void main(String[] args) {
        /* now() */
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime dateTimeInKr = ZonedDateTime.now();

        System.out.println("date = " + date);
        System.out.println("time = " + time);
        System.out.println("dateTime = " + dateTime);
        System.out.println("dateTimeInKr = " + dateTimeInKr);

        LocalDate date1 = LocalDate.of(2022, 3, 22);
        LocalTime time1 = LocalTime.of(1, 20, 1);

        System.out.println("date1 = " + date1);
        System.out.println("time1 = " + time1);

        ZonedDateTime zDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        System.out.println("zDateTime = " + zDateTime);

        LocalTime now = LocalTime.now();
        int minute = now.getMinute();
        System.out.println("minute = " + minute);

        LocalDate sunnyDate = LocalDate.of(2019, 9, 14);
        LocalTime sunnyTime = LocalTime.of(22, 20, 24);
        System.out.println("sunnyDate = " + sunnyDate);
        System.out.println("sunnyTime = " + sunnyTime);

        LocalDate sunnyDate1 = LocalDate.ofYearDay(2019, 365);
        System.out.println("sunnyDate1 = " + sunnyDate1);

        LocalDate sunnyDate2 = LocalDate.parse("2019-09-14");
        LocalTime sunnyTime2 = LocalTime.parse("22:26:23");
        System.out.println("sunnyDate2 = " + sunnyDate2);
        System.out.println("sunnyTime2 = " + sunnyTime2);

    }

}
