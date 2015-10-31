package com.funoverflowwebservices.services.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.utils.ApiUrlSource;




@Controller
public class ViewController extends AbstractController{
	
	/*@Autowired
	CassandraOperations cassandraTemplate;*/
	
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
	
	
}
