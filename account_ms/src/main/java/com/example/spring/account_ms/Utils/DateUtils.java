package com.example.spring.account_ms.Utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    public static Date parseSqlDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date utilDate = sdf.parse(dateStr);
        return new Date(utilDate.getTime());
    }
}
