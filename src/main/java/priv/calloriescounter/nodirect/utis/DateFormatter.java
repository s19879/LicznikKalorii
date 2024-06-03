package priv.calloriescounter.nodirect.utis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateFormatter {
    public static String toDateString(Date date){
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static Date stringToDate(String dateString){
        String[] dateParts = dateString.split("-");
        return Date.from(LocalDate.parse(dateString).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
