package com.funoverflowwebservices.common.core.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.funoverflowwebservices.common.constants.ResponseConstants;
import com.funoverflowwebservices.common.core.view.AbstractResponseHandler;
import com.funoverflowwebservices.common.domain.Response;

@ControllerAdvice
public class ApiExceptionHandler extends AbstractResponseHandler {

	@ExceptionHandler({ InvalidRequestException.class })
    protected void handleInvalidRequest(RuntimeException e, WebRequest request) {
        InvalidRequestException ire = (InvalidRequestException) e;
        List<FieldErrorResource> fieldErrorResources = new ArrayList<FieldErrorResource>();

        Response response = new Response();
        
        List<FieldError> fieldErrors = ire.getErrors().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            FieldErrorResource fieldErrorResource = new FieldErrorResource();
            fieldErrorResource.setResource(fieldError.getObjectName());
            fieldErrorResource.setField(fieldError.getField());
            fieldErrorResource.setCode(fieldError.getCode());
            fieldErrorResource.setMessage(fieldError.getDefaultMessage());
            fieldErrorResources.add(fieldErrorResource);
            response.setResponseDetails(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorResource error = new ErrorResource(ErrorCodes.CODE_INVALID_INPUT, ire.getMessage());
        error.setFieldErrors(fieldErrorResources);

        response.setResponseCode(ResponseConstants.HTTP_RESPONSE_CODE_OK);
        response.setResponseMessage("Input parameters cannot be null.");
        renderView(ire.getHttpServletRequest(), ire.getHttpServletResponse(), response);
        return;
    }

}
