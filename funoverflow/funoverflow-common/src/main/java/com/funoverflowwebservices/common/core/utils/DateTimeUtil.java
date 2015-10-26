package com.funoverflowwebservices.common.core.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;

public class DateTimeUtil {

    private static Logger logger = Logger.getLogger(DateTimeUtil.class.getName());

    public static String getCurrentGMT() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));

        return f.format(new Date());
    }

    public static String appendTimeStampBeforeEmail(String email,String timeStamp)
	{		
		if(email.contains("_del_"))
		{
			return timeStamp+"_del_"+email.split("_del_")[1];
		}
		
		return timeStamp+"_del_"+email;
	}
    
    public static Date getCurrentDateTimeGMT() throws FunOverflowBaseException {
        // TODO: Need to check GMT time conversion
        Date localTime = Calendar.getInstance().getTime();
        TimeZone tz = TimeZone.getDefault();
        Date gmtDate = new Date(localTime.getTime() - tz.getRawOffset());

        // if we are now in DST, back off by the delta. Note that we are checking the GMT date, this is the KEY.
        if (tz.inDaylightTime(gmtDate)) {
            Date dstDate = new Date(gmtDate.getTime() - tz.getDSTSavings());

            // check to make sure we have not crossed back into standard time
            // this happens when we are on the cusp of DST (7pm the day before the change for PDT)
            if (tz.inDaylightTime(dstDate)) {
                gmtDate = dstDate;
            }
        }
        logger.debug("Current GMT time - " + gmtDate);
        return gmtDate;
    }

    public static String getCurrentGMTSolrFormat(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = f.format(date);
        formattedDate = formattedDate.split(" ")[0]+"T"+formattedDate.split(" ")[1]+"Z";
        return formattedDate;
    }
    
    public static String getCurrentTimeStampGMT() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    public static String getCurrentGMT(String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        f.setTimeZone(TimeZone.getTimeZone("UTC"));

        return f.format(new Date());
    }

    public static Date convertStringToDate(String dateToBeParsed, String format) {
        String dateString = "Tue Jul 21 16:17:15 IST 2015";
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd hh:mm:ss zzz yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateString);

        } catch (ParseException e) {
            logger.error("convertStringToDate Exception: " + e);
        }
        return date;
    }

    public static String getMyDate(String myDate, String myFormat, String returnFormat) throws FunOverflowBaseException {
        if (myDate == null || myFormat == null || returnFormat == null)
            return null;

        DateFormat dateFormat = new SimpleDateFormat(returnFormat);
        //dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date date = null;
        String returnValue = "";
        try {
            date = new SimpleDateFormat(myFormat, Locale.ENGLISH).parse(myDate);
            returnValue = dateFormat.format(date);
        } catch (ParseException e) {
            returnValue = myDate;
            logger.error("getMyDate Exception : " + e);
        }

        return returnValue;
    }

    public static long getTimeStampDifferenceFromCurrentGMT(String DateFrom) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date firstParsedDate = null;
            firstParsedDate = dateFormat.parse(DateFrom);

            Date secondParsedDate = null;
            secondParsedDate = dateFormat.parse(DateTimeUtil.getCurrentTimeStampGMT());

            return secondParsedDate.getTime() - firstParsedDate.getTime();
        } catch (ParseException e) {
            logger.error("getTimeStampDifference Exception: " + e);
            return 0;
        }
    }

    public static long resetPasswordLinkExpirationTime() {
        return getTotalSecondsInDayCount(3);

    }

    public static long getTotalSecondsInDayCount(int noOfDays) {
        return 86400 * 1000 * noOfDays;
    }

    public static Timestamp convertStringToTimestamp(String str_date) throws FunOverflowBaseException {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date) formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
            return timeStampDate;
        } catch (ParseException e) {
            throw new FunOverflowBaseException("Date conversion has encountered error", "", e, false);
        }
    }

    public static Date convertStringToDate(String Str_date) throws FunOverflowBaseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(Str_date);
        } catch (ParseException e) {
            throw new FunOverflowBaseException("Date conversion has encountered error", "", e, false);
        }
        return date;
    }

    public static Date convertStringToDateWithParticularDateFormat(String Str_date) throws FunOverflowBaseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(Str_date);
        } catch (ParseException e) {
            throw new FunOverflowBaseException("Date conversion has encountered error", "", e, false);
        }
        return date;
    }

    public static String convertDateToString(Date date) throws FunOverflowBaseException {
        String dateString = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dateString = formatter.format(date);
        } catch (Exception e) {
            throw new FunOverflowBaseException("Date conversion has encountered error", "", e, false);
        }
        return dateString;
    }
    
    public static long convertStringToMilliesOrGetLatestTime(String strDate) throws FunOverflowBaseException {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse(strDate);
            return date.getTime();
        } catch (ParseException e) {
            throw new FunOverflowBaseException("Date conversion has encountered error", "", e, false);
        }
    }

}
