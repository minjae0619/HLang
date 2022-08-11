package com.mj.h.log;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    public static void log(LogType logType, String str){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String time = format.format(now.getTime());
        System.out.println("[" + time + " " + logType + "] " + str);
    }
}
