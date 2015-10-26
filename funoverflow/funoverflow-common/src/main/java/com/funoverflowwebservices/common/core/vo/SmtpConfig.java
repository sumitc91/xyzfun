package com.funoverflowwebservices.common.core.vo;

import java.io.Serializable;

public class SmtpConfig implements Serializable {
	     
	private static final long serialVersionUID = 3841299829377921641L;
	public String mailSmtpHost;
    public String mailSmtpUser;
    public String mailSmtpPassword;
    public int mailSmtpPort;
    public String mailSmtpFrom;
    public String contactUsSendTo;
    public String dataFeedBackSendTo;
    public String adminAddress;

    public SmtpConfig() {
           super();
    }

    public SmtpConfig(String mailSmtpHost, String mailSmtpUser, String mailSmtpPassword, int mailSmtpPort, String mailSmtpFrom) {
           super();
           this.mailSmtpHost = mailSmtpHost;
           this.mailSmtpUser = mailSmtpUser;
           this.mailSmtpPassword = mailSmtpPassword;
           this.mailSmtpPort = mailSmtpPort;
           this.mailSmtpFrom = mailSmtpFrom;
    }

    public String getMailSmtpHost() {
           return mailSmtpHost;
    }

    public void setMailSmtpHost(String mailSmtpHost) {
           this.mailSmtpHost = mailSmtpHost;
    }

    public String getMailSmtpUser() {
           return mailSmtpUser;
    }

    public void setMailSmtpUser(String mailSmtpUser) {
           this.mailSmtpUser = mailSmtpUser;
    }

    public String getMailSmtpPassword() {
           return mailSmtpPassword;
    }

    public void setMailSmtpPassword(String mailSmtpPassword) {
           this.mailSmtpPassword = mailSmtpPassword;
    }

    public int getMailSmtpPort() {
           return mailSmtpPort;
    }

    public void setMailSmtpPort(int mailSmtpPort) {
           this.mailSmtpPort = mailSmtpPort;
    }

    public String getMailSmtpFrom() {
           return mailSmtpFrom;
    }

    public void setMailSmtpFrom(String mailSmtpFrom) {
           this.mailSmtpFrom = mailSmtpFrom;
    }

    public String getContactUsSendTo() {
           return contactUsSendTo;
    }

    public void setContactUsSendTo(String contactUsSendTo) {
           this.contactUsSendTo = contactUsSendTo;
    }
   
    public String getDataFeedBackSendTo() {
           return dataFeedBackSendTo;
    }

    public void setDataFeedBackSendTo(String dataFeedBackSendTo) {
           this.dataFeedBackSendTo = dataFeedBackSendTo;
    }
   
    public String getAdminAddress() {
           return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
           this.adminAddress = adminAddress;
    }
}
