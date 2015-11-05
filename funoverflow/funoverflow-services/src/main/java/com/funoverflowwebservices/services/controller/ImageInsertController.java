package com.funoverflowwebservices.services.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.funoverflowwebservices.common.core.exception.ErrorCodes;
import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.exception.InvalidRequestException;
import com.funoverflowwebservices.common.domain.Response;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;
import com.funoverflowwebservices.services.ImageInsertService;

@Controller
@RequestMapping("/Image")
public class ImageInsertController extends AbstractController{
	
	@Resource(name = "ImageInsertServiceImpl")
	protected ImageInsertService imageInsertService;
	
	@RequestMapping(value = "/insertImageToSql", method = RequestMethod.POST, headers = "Accept=*/*")
	public void insertImageToSql(HttpServletRequest HTTPRequest,
				               HttpServletResponse HTTPResponse,
				                @Valid @RequestBody List<NewImageInsertRequestObject> newImageListInsertRequestObject,BindingResult result) throws SolrServerException, IOException
	{
		Response response = new Response();
		
		if (result.hasErrors()) {
            log.debug("Request bean validation error.");
            throw new InvalidRequestException(ErrorCodes.MSG_INVALID_INPUT, HTTPRequest, HTTPResponse, result);
        }
		
		try 
		{	
			response=imageInsertService.insertNewImageIntoSql(newImageListInsertRequestObject);			
			renderView(HTTPRequest, HTTPResponse, response);					
		} 
		catch (FunOverflowBaseException buddyMeBaseException) 
		{
			log.error("insertNewImageIntoSql Exception", buddyMeBaseException);
			response.setResponseCode(buddyMeBaseException.getErrorCode());
			response.setResponseMessage("insertNewImageIntoSql Exception");
			response.setResponseDetails("ERROR", buddyMeBaseException.getMessage());
			renderView(HTTPRequest, HTTPResponse, response);
		}
		
	}
}
