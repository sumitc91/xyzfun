package com.funoverflowwebservices.common.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;

public class UrlEncoderAndDecoder {
	public static String EncodeUrl(String url) throws FunOverflowBaseException
	{
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new FunOverflowBaseException(" UrlEncoderAndDecoder Exception", "", e, false);
		}
	}
	
	public static String DecodeUrl(String url)throws FunOverflowBaseException
	{
		try {
			return URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new FunOverflowBaseException(" UrlEncoderAndDecoder Exception", "", e, false);
		}
	}
}
