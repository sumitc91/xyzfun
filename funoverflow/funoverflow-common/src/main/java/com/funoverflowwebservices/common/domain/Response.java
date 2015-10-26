package com.funoverflowwebservices.common.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Response implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String responseCode;
	private String responseMessage;
	private Map<String,Object> responseDetails =new HashMap<String,Object>();
	
	public String getResponseCode() 
	{
		return responseCode;
	}
	
	public void setResponseCode(String responseCode) 
	{
		this.responseCode = responseCode;
	}
	
	public String getResponseMessage() 
	{
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) 
	{
		this.responseMessage = responseMessage;
	}
	
	public void setResponseDetails(String key , Object value) 
	{
		this.responseDetails.put(key, value);
	}
	
	public Map<String,Object> getResponseDetails() 
	{
		return responseDetails;
	}
}
