package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式化工具
 */
public class TimeUtil {
    //获取时间戳下 00：00：00 的时间戳
    public static long getStart(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timestamp * 1000));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public static long getYesterdayStart() {
        return getStart(getNow() - (3600 * 24));
    }

    //获取今天23：59：59 的时间戳
    public static long getEnd(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timestamp * 1000));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTimeInMillis() / 1000;
    }

    public static Date getDateMonthsAgo(int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 0 - months);
        return calendar.getTime();
    }

    public static Date getDateYearsAgo(int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 0 - years);
        return calendar.getTime();
    }

    public static int getYearsAgo(int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 0 - years);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getMonthsAgo(int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 0 - months);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static long getYesterdayEnd() {
        return getEnd(getNow() - (3600 * 24));
    }

    //获取 day 天后的时间戳
    public static long addTime(long timestamp, int day) {
        return timestamp + (day * 3600 * 24);
    }

    public static Date getDate(long timestamp) {
        return new Date(timestamp * 1000);
    }

    public static long getNow() {
        return System.currentTimeMillis() / 1000;
    }

    public static int getIntNow() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    //一个月以前
    public static long getMouthAgo() {
        return TimeUtil.addTime(TimeUtil.getStart(getNow()), -30);
    }

    public static long getDaysAgo(int days) {
        return TimeUtil.addTime(getNow(), -days);
    }

    public static String getDistanceTimeStr(long startDate, long endDate) {
        try {
            long dTime = endDate - startDate;
            long dDay;
            if (dTime > 0) {
                dDay = dTime / (3600 * 24);
            } else {
                return "";
            }
            String result = "";
            if (dTime < 60) {
                result = dTime + "秒";
            } else if (dTime < 3600) {
                result = (dTime / 60) + "分钟";
            } else if (dDay == 0) {
                result = (dTime / 3600) + "小时";
            } else if (dDay > 0 && dDay <= 7) {
                result = dDay + "天";
            } else if (dDay > 7 && dDay <= 30) {
                result = (dDay / 7) + "周";
            } else if (dDay > 30) {
                result = (dDay / 30) + "个月";
            }
            return result;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getDateYYYYMMDD() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    /**
     * 时间戳转字符串，返回格式：YYYYMMDD
     */
    public static String getDateYYYYMMDDByTime(long time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date(time * 1000));
    }

    /**
     * 时间戳转字符串，返回格式：YYYY-MM-DD HH:mm:SS
     */
    public static String getDateYYYYMMDDHHMMSSByTime(long time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date(time * 1000));
    }

    /**
     * 时间戳转字符串，返回格式：YYYY-MM-DD E A
     */
    public static String getDateYYYYMMDDEAByTime(long time) {
        DateFormat df = new SimpleDateFormat(" yyyy-MM-dd E a");
        return df.format(new Date(time * 1000));
    }



    public static String getDateYYYYMMDDDaysAgo(int days) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date(getDaysAgo(days) * 1000));
    }

    public static String getYYYYMMByMonthAgo(int months) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        return df.format(getDateMonthsAgo(months));
    }

    /**
     * 获取当天是本月第几周
     * Create by zhangzhengguo
     *
     * @param today
     * @return
     */
    public static String getWitchWeekOfCurrentMonth(String today) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(today);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return "第" + calendar.get(Calendar.WEEK_OF_MONTH) + "周";
    }


    /**
     * 获得当前日期所在周一0点的时间
     *
     * @param timestamp
     * @return
     */
    public static Long getTimesWeekStart(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timestamp * 1000));
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return (cal.getTimeInMillis() / 1000);
    }

    /**
     * 获得当前日期所在年的第一天0点时间
     *
     * @param timestamp
     * @return
     */
    public static Long getTimesYearStart(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timestamp * 1000));
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * 获得当前日期所在月的第一天0点时间
     *
     * @param timestamp
     * @return
     */
    public static Long getTimesMonthStart(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timestamp * 1000));
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * 获得当前日期所在季度的第一天0点时间
     * @param timestamp
     * @return
     */
    public static Long getTimesQuarterStart(Long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timestamp * 1000));
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3)
            cal.set(Calendar.MONTH, 0);
        else if (currentMonth >= 4 && currentMonth <= 6)
            cal.set(Calendar.MONTH, 3);
        else if (currentMonth >= 7 && currentMonth <= 9)
            cal.set(Calendar.MONTH, 4);
        else if (currentMonth >= 10 && currentMonth <= 12)
            cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.DATE, 1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return cal.getTimeInMillis() / 1000;
    }



}
