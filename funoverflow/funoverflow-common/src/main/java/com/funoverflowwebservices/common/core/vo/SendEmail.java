package com.funoverflowwebservices.common.core.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class SendEmail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8061120520414362474L;
	
    private String from;   
    private String to;   
    private String cc;
    private String bcc; 
    private String subject;  
    
    private Map<String, Object> mailContext;
    private String mailVm;
	public SendEmail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendEmail(String from, String to, String cc, String bcc,
			String subject, Map<String, Object> mailContext, String mailVm) {
		super();
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.mailContext = mailContext;
		this.mailVm = mailVm;
	}
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Map<String, Object> getMailContext() {
		return mailContext;
	}
	public void setMailContext(Map<String, Object> mailContext) {
		this.mailContext = mailContext;
	}
	public String getMailVm() {
		return mailVm;
	}
	public void setMailVm(String mailVm) {
		this.mailVm = mailVm;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "SendEmail [from=" + from + ", to=" + to + ", cc=" + cc
				+ ", bcc=" + bcc + ", subject=" + subject + ", mailContext="
				+ mailContext + ", mailVm=" + mailVm + "]";
	}
	
	
}
