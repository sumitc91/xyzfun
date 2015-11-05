package com.funoverflowwebservices.common.core.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ApiUrlSource")
public class ApiUrlSource {

	@Value("${apiHostUrl}")
	private String apiHostUrl;
	
	@Value("${apiHostLocalUrl}")
	private String apiHostLocalUrl;
	
	@Value("${apiDiscoverUrl}")
	private String apiDiscoverUrl;
	
	@Value("${apiOauthUrl}")
	private String apiOauthUrl;
	
	@Value("${activateUrl}")
	private String activateUrl;

	@Value("${apiSiteUrl}")
	private String apiSiteUrl;
		
    @Value("${activateGroupUrl}")
    private String activateGroupUrl;

	public String getApiDiscoverUrl() {
		return apiDiscoverUrl;
	}

	public void setApiDiscoverUrl(String apiDiscoverUrl) {
		this.apiDiscoverUrl = apiDiscoverUrl;
	}

	public String getApiOauthUrl() {
		return apiOauthUrl;
	}

	public void setApiOauthUrl(String apiOauthUrl) {
		this.apiOauthUrl = apiOauthUrl;
	}

	public String getActivateUrl() {
		return activateUrl;
	}

	public void setActivateUrl(String activateUrl) {
		this.activateUrl = activateUrl;
	}

	public String getApiSiteUrl() {
		return apiSiteUrl;
	}

	public void setApiSiteUrl(
			String apiSiteUrl) {
		this.apiSiteUrl = apiSiteUrl;
	}

	public String getApiHostLocalUrl() {
		return apiHostLocalUrl;
	}

	public void setApiHostLocalUrl(String apiHostLocalUrl) {
		this.apiHostLocalUrl = apiHostLocalUrl;
	}
	
	public String getApiHostUrl() {
		return apiHostUrl;
	}

	public void setApiHostUrl(String apiHostUrl) {
		this.apiHostUrl = apiHostUrl;
	}

    public String getActivateGroupUrl() {
        return activateGroupUrl;
    }

    public void setActivateGroupUrl(String activateGroupUrl) {
        this.activateGroupUrl = activateGroupUrl;
    }
}
