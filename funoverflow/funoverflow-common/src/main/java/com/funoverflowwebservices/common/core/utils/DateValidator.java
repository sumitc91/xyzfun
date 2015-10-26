package com.funoverflowwebservices.common.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;

public class DateValidator {

		
	public String validateAndReturnValidDate(String dateToValidate) throws FunOverflowBaseException 
	{
		String convertDateToFormat = "yyyy-MM-dd";
		String[] possibleDateFormatList = { "yyyy/MM/dd", "yyyy-MM-dd" };
		for (String possibleDateFormat : possibleDateFormatList) {
			if (new DateValidator().isThisFormatDateValid(dateToValidate,
					possibleDateFormat))
			{
				return new DateValidator().convertDateToFormat(dateToValidate,
						possibleDateFormat, convertDateToFormat);
			}
		}
		return null;
	}

	public boolean isThisFormatDateValid(String dateToValidate,
			String dateFormat) throws FunOverflowBaseException{
		if (dateToValidate == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try {
		   sdf.parse(dateToValidate);			
		} catch (ParseException e) {
			throw new FunOverflowBaseException("Date conversion has encountered error","",e,false);	
		}
		return true;
	}

	public String convertDateToFormat(String dateToConvert,
			String fromDateFormat, String toDateFormat) throws FunOverflowBaseException
	{
		if (dateToConvert == null || fromDateFormat == null
				|| toDateFormat == null) {
			return null;
		}
		try
		{
			// create SimpleDateFormat object with source string date format
			SimpleDateFormat sdfSource = new SimpleDateFormat(fromDateFormat);
			// parse the string into Date object
			Date date = sdfSource.parse(dateToConvert);
			// create SimpleDateFormat object with desired date format
			SimpleDateFormat sdfDestination = new SimpleDateFormat(toDateFormat);
			// parse the date into another format
			return sdfDestination.format(date);
		}
		catch (Exception e)
		{
			throw new FunOverflowBaseException("Date conversion has encountered error","",e,false);
		}
	}

	 public static boolean isThisDateValid(String dateToValidate) throws FunOverflowBaseException {
	        if (dateToValidate == null) {
	            return false;
	        }
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(false);
	        try {
	            sdf.parse(dateToValidate);
	        } catch (ParseException e) {
	            throw new FunOverflowBaseException("Date conversion has encountered error", "", e, false);
	        }
	        return true;
	    }

}