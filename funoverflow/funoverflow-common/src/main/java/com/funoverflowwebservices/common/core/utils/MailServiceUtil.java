package com.funoverflowwebservices.common.core.utils;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.funoverflowwebservices.common.core.vo.MailVo;
import com.funoverflowwebservices.common.core.vo.SmtpConfig;

@Component("MailServiceUtil")
public class MailServiceUtil {
	

	//Logger
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private JavaMailSender mailSender;
	@Resource
	private VelocityEngine velocityEngine;
	@Resource
	private SmtpConfig smtpConfig;
	
	public MailServiceUtil(){
		
	}
	
	public String sendMail(MailVo mailVo) {
		MimeMessagePreparator preparator = prepareMailMessage(mailVo.getFrom(), mailVo.getTo(), mailVo.getCc(), mailVo.getBcc(), mailVo.getSubject(), mailVo.getBody());
		mailSender.send(preparator);
		return "Success";
	}

	private MimeMessagePreparator prepareMailMessage(final String from, final String to, final String cc, final String bcc,
			final String subject, final String body) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setFrom(new InternetAddress(from));
				message.setTo(new InternetAddress(to));

				if (StringUtils.isNotBlank(cc)) {
					message.setCc(new InternetAddress(cc));
				}
				if (StringUtils.isNotBlank(bcc)) {
					message.setBcc(bcc);
				}
				message.setSubject(subject);
				message.setText(body, true);
			}
		};
		return preparator;
	}

	public String getEmailBody(String vmTemplate, Map<String, Object> mailContext) {
		return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, vmTemplate, "UTF-8", mailContext);
	}
	
	public String getFromEmailId() {
		return smtpConfig.getMailSmtpFrom();
	}
	
	public String getAdminEmailId() {
		return smtpConfig.getAdminAddress();
	}

	public boolean sendMailWithAttachment(final MailVo mailVo, final File file, final String attachmentName) {
		boolean mailSuccess = false;
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
			
				String[] toEmailIds = mailVo.getTo().toString().split(",");				
				
				MimeMessageHelper message = new MimeMessageHelper(
						mimeMessage, true);
				message.setSubject(mailVo.getSubject());
				message.setText(mailVo.getBody(), true);
				message.setFrom(new InternetAddress(mailVo.getFrom()));
				message.setTo(toEmailIds);				

				if (StringUtils.isNotBlank(mailVo.getCc())) {
					message.setCc(new InternetAddress(mailVo.getCc()));
				}
				if (StringUtils.isNotBlank(mailVo.getBcc())) {
					message.setBcc(mailVo.getBcc());
				}
				
				if(file != null){
					message.addAttachment(attachmentName, file);
				}
			}
		};
		
		try {

			mailSender.send(preparator);
			mailSuccess = true;
		} catch (final MailException e) {
			mailSuccess = false;
			log.error( e);
		} catch (final Exception e) {
			mailSuccess = false;
			log.error(e);
		}
		log.info("<<<   Ending MailSenderService.sendMailWithAttachment()   >>>");
		return mailSuccess;
		
		
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public SmtpConfig getSmtpConfig() {
		return smtpConfig;
	}

	public void setSmtpConfig(SmtpConfig smtpConfig) {
		this.smtpConfig = smtpConfig;
	}

}
