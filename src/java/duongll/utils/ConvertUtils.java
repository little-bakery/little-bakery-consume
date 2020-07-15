/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.utils;

import java.util.Calendar;

/**
 *
 * @author duong
 */
public class ConvertUtils {

    public static int convertTimeToMinute(String times) {
        int indexOfHour, hour, indexOfMinute, min = 0, indexOfDay, day;
        if (times.contains("D")) {
            indexOfDay = times.indexOf("D");
            day = Integer.parseInt(times.substring(0, indexOfDay));
            min += day * 1440;
            indexOfHour = times.indexOf("H");
            hour = Integer.parseInt(times.substring((indexOfDay + 1), indexOfHour));
            indexOfMinute = times.indexOf("M");
            min += Integer.parseInt(times.substring((indexOfHour + 1), indexOfMinute));
            min += (hour * 60);
        } else {
            if (times.contains("H")) {
                indexOfHour = times.indexOf("H");
                hour = Integer.parseInt(times.substring(0, indexOfHour));
                indexOfMinute = times.indexOf("M");
                min = Integer.parseInt(times.substring((indexOfHour + 1), indexOfMinute));
                min += (hour * 60);
            } else {
                indexOfMinute = times.indexOf("M");
                min = Integer.parseInt(times.substring(0, indexOfMinute));
            }
        }
        return min;
    }
}
