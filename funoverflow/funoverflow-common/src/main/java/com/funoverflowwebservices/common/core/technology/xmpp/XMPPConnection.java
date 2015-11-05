package com.funoverflowwebservices.common.core.technology.xmpp;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
//import org.jivesoftware.smack.tcp.XMPPTCPConnection;
//import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.util.TLSUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;

@Configuration
@PropertySource(value = { "classpath:properties/xmpp.properties" })
public class XMPPConnection {
	
	@Resource
    private Environment environment;

	/*@Bean
	public XMPPTCPConnection getXMPPConnection() throws FunOverflowBaseException {
		XMPPTCPConnectionConfiguration.Builder conf = XMPPTCPConnectionConfiguration.builder();
		conf.setHost(environment.getProperty("XMPP.HOST"));
		conf.setServiceName(environment.getProperty("XMPP.HOST"));
		conf.setUsernameAndPassword(environment.getProperty("XMPP.USER"), environment.getProperty("XMPP.PASSWORD"));
		conf.setSecurityMode(SecurityMode.disabled);
		conf.setCompressionEnabled(true);
		try {
			TLSUtils.acceptAllCertificates(conf);
		} catch (KeyManagementException e) {
			throw new FunOverflowBaseException("90", "exception while conecting to XMPP server", e, false);
		} catch (NoSuchAlgorithmException e) {
			throw new FunOverflowBaseException("90", "exception while conecting to XMPP server", e, false);
		}
		XMPPTCPConnection connection = new XMPPTCPConnection(conf.build());
		
		try {
			connection.connect();
			connection.login(environment.getProperty("XMPP.USER"), environment.getProperty("XMPP.PASSWORD"));
		} catch (SmackException e) {
			throw new FunOverflowBaseException("90", "exception while conecting to XMPP server ", e, false);
		} catch (IOException e) {
			throw new FunOverflowBaseException("90", "exception while conecting to XMPP server ", e, false);
		} catch (XMPPException e) {
			throw new FunOverflowBaseException("90", "exception while conecting to XMPP server ", e, false);
		}
		
		return connection;

	}*/

}
