package com.funoverflowwebservices.services.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.funoverflowwebservices.common.core.exception.ErrorCodes;
import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.exception.InvalidRequestException;
import com.funoverflowwebservices.common.core.utils.ApiUrlSource;
import com.funoverflowwebservices.common.core.vo.SolrInsertImageEntity;
import com.funoverflowwebservices.common.domain.Response;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;
import com.funoverflowwebservices.services.ImageInsertService;




@Controller
public class ViewController extends AbstractController{
	
	/*@Autowired
	CassandraOperations cassandraTemplate;*/
	
	@Resource(name = "ImageInsertServiceImpl")
	protected ImageInsertService imageInsertService;
	
	@Resource(name = "ApiUrlSource")
	private ApiUrlSource apiUrlSource;
	
	@RequestMapping(value = "/test")
	public ModelAndView displayActivationMessage(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws FunOverflowBaseException{
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("activation");
		String message;
		
		message = "success";
		
		modelAndView.addObject("message",message );
		return modelAndView;
	}
	
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
			//List<NewImageInsertRequestObject> newImageListInsertRequestObject = new ArrayList<NewImageInsertRequestObject>();
			//newImageListInsertRequestObject.add(newImageInsertRequestObject);
			response=imageInsertService.insertNewImageIntoSql(newImageListInsertRequestObject);			
			renderView(HTTPRequest, HTTPResponse, response);					
		} 
		catch (FunOverflowBaseException funOverflowBaseException) 
		{
			log.error("insertNewImageIntoSql Exception", funOverflowBaseException);
			response.setResponseCode(funOverflowBaseException.getErrorCode());
			response.setResponseMessage("insertNewImageIntoSql Exception");
			response.setResponseDetails("ERROR", funOverflowBaseException.getMessage());
			renderView(HTTPRequest, HTTPResponse, response);
		}
		
	}
	
	@RequestMapping(value = "/moveSqlImagesToSolr", method = RequestMethod.GET, headers = "Accept=*/*")
	public void moveSqlImagesToSolr(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws FunOverflowBaseException, SolrServerException, IOException{
		
		Response response = new Response();
		
		try 
		{
			response = imageInsertService.fetchAndInsertNewImageFromMySqlToSolr();
		}
		catch (FunOverflowBaseException funOverflowBaseException) 
		{
			log.error("insertNewImageIntoSql Exception", funOverflowBaseException);
			/*response.setResponseCode(funOverflowBaseException.getErrorCode());
			response.setResponseMessage("insertNewImageIntoSql Exception");
			response.setResponseDetails("ERROR", funOverflowBaseException.getMessage());
			renderView(httpServletRequest, httpServletResponse, response);*/
		}
		
		
		renderView(httpServletRequest, httpServletResponse, response);
	}
	
	@RequestMapping(value = "/getFunOverflowImages", method = RequestMethod.GET, headers = "Accept=*/*")
	public void getVerifiedDetails(HttpServletRequest HTTPRequest,
			HttpServletResponse HTTPResponse,
			@RequestParam("fetchFrom") String fetchFrom,@RequestParam("fetchUpto") String fetchUpto) {
		Response response = new Response();
		try {

			if(fetchFrom == null)
				fetchFrom = "0";
			if(fetchUpto == null)
				fetchUpto = "10";
			
			
			Map<String,String> searchCriteria = new HashMap<String,String>();
			searchCriteria.put("fetchFrom", fetchFrom);
			searchCriteria.put("fetchUpto", fetchUpto);
			
			List<SolrInsertImageEntity> solrInsertImageEntitiesList = imageInsertService.getFunOverflowImagesFromSolr(searchCriteria);
			
			response.setResponseCode("200");
			response.setResponseMessage("success");
			response.setResponseDetails("data", solrInsertImageEntitiesList);
			
			renderView(HTTPRequest, HTTPResponse, response);
		} catch (Exception e) {
			log.error("IsBuddyMeUserAccountExists Exception", e);
			response.setResponseCode("500");
			response.setResponseMessage("IsBuddyMeUserAccountExists Exception");
			response.setResponseDetails("ERROR", e.getLocalizedMessage());
			renderView(HTTPRequest, HTTPResponse, response);
		}
	}
}
