package com.funoverflowwebservices.common.core.view;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.View;

import com.funoverflowwebservices.common.domain.Response;

/**
 * Delegating Abstract response handler for managing XML or JSON rendering of data
 * 
 *
 */
public abstract class AbstractResponseHandler 
{
	//Logger
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "xmlView")
	private View xmlView;
	
	@Resource(name = "jsonView")
	private View jsonView;
	
	/**
	 * Delegating Response view handler.  
	 * @param HTTPRequest
	 * @param HTTPResponse
	 * @param response
	 */
	protected void renderView(HttpServletRequest HTTPRequest, HttpServletResponse HTTPResponse , Response response)
	{
		Map<String,Response> model = new HashMap<String,Response>();
		String responseType = "application/json";
		
		/*
		 * Async Response Logging 
		 */
		try
		{
			HTTPRequest.setAttribute("BuddyMeRspCode", response.getResponseCode());
			HTTPRequest.setAttribute("BuddyMeRspMsg", response.getResponseMessage());
			HTTPRequest.setAttribute("BuddyMeSerializedResponse", response.getResponseDetails());
		}
		catch(Exception e)
		{
			log.error("Failed Serializing the Response from DB logging", e);
		}
		
		
		/*
		 * Render the View
		 */
		try
		{
			model.put("Response", response);
			responseType = HTTPRequest.getHeader("Accept").trim();
			
			if (("application/xml").equalsIgnoreCase(responseType))
				xmlView.render(model, HTTPRequest, HTTPResponse);
			else
				jsonView.render(model, HTTPRequest, HTTPResponse);
		}
		catch(Exception e)
		{
			log.error("Failed rendering response", e);
			HTTPResponse.setContentType(responseType);
			try
			{
				HTTPResponse.sendError(500, "Failed while rendering response as " + responseType + ". [" + e.getMessage() + "]");
			}
			catch(Exception ex)
			{
				log.error("Failed rendering response", ex);
			}
		}
	}
}
