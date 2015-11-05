package com.funoverflowwebservices.common.core.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Errors errors;

    
    public InvalidRequestException(String message, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Errors errors) {
    	super(message);
		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
		this.errors = errors;
	}

    public Errors getErrors() {
        return errors;
    }

    public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public InvalidRequestException() {
		super();
	}
}
