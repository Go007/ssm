package com.hong.ssm.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by wanghong
 * Date 2019-04-24 14:59
 * Description: 基于Java8的时间日期工具类
 */
public class DateUtil {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, FORMATTER);
    }

    public static String formatLocalDate(LocalDate date) {
        return date.format(FORMATTER);
    }

    /**
     * 获取当前日期
     * @return yyyy-MM-dd
     */
    public static String getNowDate() {
        return String.valueOf(LocalDate.now());
    }

    /**
     * 获取昨天日期
     * @return yyyy-MM-dd
     */
    public static String getYesterday(){
        return getMinusDays(1);
    }

    /**
     * 获取距离当前日期多少天的日期
     * @return yyyy-MM-dd
     */
    public static String getMinusDays(long days){
        return String.valueOf(LocalDate.now().minusDays(days));
    }

    public static void main(String[] args) {
        String str = "2019年04月24日";
        LocalDate localDate = parseDate(str);
        System.out.println(localDate);
        String str1 = "2019年04月24日";
        LocalDate localDate1 = parseDate(str1);
        System.out.println(localDate1.compareTo(localDate));

        System.out.println(formatLocalDate(localDate1));

        System.out.println(getNowDate());
        System.out.println(getYesterday());

        long a = 102;
        System.out.println(a/1000);
    }

}
