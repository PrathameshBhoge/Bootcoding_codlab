package com.bootcoding.user.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

    public static String toString(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(date);
        Calendar.getInstance();

        return format;
    }



    public static Date toDate(String dateStr){

        Date d = new Date(dateStr);
        return d;
    }

    public static void main(String[] args) {
        System.out.println("Main() pehle call hote hai");
        toDate("sljdgla");

        Application application1 = new Application();
        Application application2 = new Application();
        Application application3 = new Application();

       Application app = Application.getInstance();
       Application app2 = Application.getInstance();
       Application app3 = Application.getInstance();
        System.out.println();

    }
}
