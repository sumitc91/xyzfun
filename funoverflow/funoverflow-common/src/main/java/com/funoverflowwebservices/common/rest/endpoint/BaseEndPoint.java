package com.funoverflowwebservices.common.rest.endpoint;

import java.net.URI;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.utils.ApiUrlSource;

@Component("BaseEndPoint")
public class BaseEndPoint {

	private final Logger logger = Logger.getLogger(getClass());
    @Autowired
	private RestTemplate restTemplate;
	@Resource(name="ApiUrlSource")
	private ApiUrlSource apiUrlSource;

	protected final static HttpHeaders HEADERS = new HttpHeaders();

	public BaseEndPoint() {
		super();
		//this.restTemplate = restTemplate;
	}

	static {
		HEADERS.setContentType(MediaType.APPLICATION_JSON);
	}

	protected String getServiceUrl(final String apiUrl) {
		StringBuilder builder = new StringBuilder();
		builder.append(getApiLocalHostUrl());
		builder.append(apiUrl);
		return builder.toString();
	}

	protected String logRequestUrl(Map<String, String> params, String url) {
		UriTemplate uriTemplate = new UriTemplate(url);
		URI expanded = uriTemplate.expand(params);
		return expanded.getScheme() + ":" + expanded.getRawSchemeSpecificPart();
	}

	protected void logURLRequests(Map<String, String> params, String url) {
		logger.debug("Buddy Me Service Request URL: [" + url + "]");
		logger.debug("Buddy Me Service Request URL: [" + logRequestUrl(params, url) + "]");
	}

	public JSONObject exchange(String url, Map<String, String> urlParams, HttpMethod httpMethod, HttpHeaders httpHeaders)
			throws FunOverflowBaseException {
		ResponseEntity<JSONObject> response = restTemplate.exchange(url, httpMethod, new HttpEntity<JSONObject>(
				httpHeaders), JSONObject.class, urlParams);
		return response.getBody();
	}

	public JSONObject exchangeWithBody(String url, Map<String, String> urlParams, HttpMethod httpMethod,
			HttpHeaders httpHeaders, JSONObject reqBody) throws FunOverflowBaseException {
		ResponseEntity<JSONObject> response = restTemplate.exchange(url, httpMethod, new HttpEntity<JSONObject>(
				reqBody, httpHeaders), JSONObject.class, urlParams);
		return response.getBody();
	}

	public JSONObject exchangeWithStringBody(String url, Map<String, String> urlParams, HttpMethod httpMethod,
			HttpHeaders httpHeaders, JSONObject reqBody) throws FunOverflowBaseException {
		ResponseEntity<JSONObject> response = restTemplate.exchange(url, httpMethod, new HttpEntity<JSONObject>(
				reqBody, httpHeaders), JSONObject.class, urlParams);
		return response.getBody();
	}

	public JSONObject exchangeWithBodyArray(String url, Map<String, String> urlParams, HttpMethod httpMethod,
			HttpHeaders httpHeaders, JSONArray reqBody) throws FunOverflowBaseException {
		ResponseEntity<JSONObject> response = restTemplate.exchange(url, httpMethod, new HttpEntity<JSONArray>(reqBody,
				httpHeaders), JSONObject.class, urlParams);
		return response.getBody();
	}

	public String verifyResponse(JSONObject object, Map<String, String> params, String url) throws FunOverflowBaseException {
			if (object.containsKey("Response")) {
				JSONObject response =  object.getJSONObject("Response");
				if (response.getString("responseCode").equalsIgnoreCase("200")) {
					logger.debug("Verified Response Code: " + response.getString("responseCode"));
					return "200";
				} else  {
					logger.debug("Invalid Response Code: " + response.getString("responseCode"));
					return "500";
				}
				
			} else {
				logger.debug("Improper response format: \n" + object + " \n Parameters uses are: " + params
						+ " \n Request URL: " + url);
				throw new FunOverflowBaseException("Improper response format. : " + object + " \n Parameters uses are: "
						+ params + " \n Request URL: " + url, null, new Throwable(), false);
			}
		}

	/**
	 * Performs the HTTP GET request and returns the JSON object.
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public JSONObject get(String url, Map<String, String> params) {
		JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class, params);

		return jsonObject;
	}

	/**
	 * @return the apiHostUrl
	 */
	public String getApiHostUrl() {
		return getApiUrlSource().getApiHostUrl();
	}

	/**
	 * @return the apiHostUrl
	 */
	public String getApiLocalHostUrl() {
		return getApiUrlSource().getApiHostLocalUrl();
	}

	public ApiUrlSource getApiUrlSource() {
		return apiUrlSource;
	}

	public void setApiUrlSource(ApiUrlSource apiUrlSource) {
		this.apiUrlSource = apiUrlSource;
	}

}
