package com.funoverflowwebservices.common.core.vo;

import java.io.Serializable;

public class SendSms implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7600346943827491695L;
	
	private String to;   
    private StringBuilder subject;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public StringBuilder getSubject() {
		return subject;
	}
	public void setSubject(StringBuilder subject) {
		this.subject = subject;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SendSms [to=" + to + ", subject=" + subject + "]";
	}  
    
    
}
