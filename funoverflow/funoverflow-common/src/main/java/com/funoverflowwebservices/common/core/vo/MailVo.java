package com.funoverflowwebservices.common.core.vo;

import java.io.File;

public class MailVo {
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private File file;
    private String attachmentName;

    public MailVo(String from, String to, String cc, String bcc, String subject, String body) {
           this.from = from;
           this.to = to;
           this.cc = cc;
           this.bcc = bcc;
           this.subject = subject;
           this.body = body;
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

    public String getBody() {
           return body;
    }

    public void setBody(String body) {
           this.body = body;
    }

    public File getFile() {
           return file;
    }

    public void setFile(File file) {
           this.file = file;
    }

    public String getAttachmentName() {
           return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
           this.attachmentName = attachmentName;
    }
   
}
