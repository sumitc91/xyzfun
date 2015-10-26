package com.funoverflowwebservices.common.core.technology.solr;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.utils.config.IConfiguration;

@Configuration
@PropertySource(value = { "classpath:properties/solr.properties" })
@EnableSolrRepositories(basePackages = { "com.buddymewebservices" })
public class SolrConfiguration implements IConfiguration {
    
    @Resource
    private Environment environment;
    
    @Bean(name="solrBuddyMeUserMasterTemplate")
    public SolrTemplate solrBuddyMeUserMasterTemplate() throws FunOverflowBaseException{
        try {
            HttpSolrServer solrServer = new HttpSolrServer(environment.getRequiredProperty("solr.server.url.user.master"));
            return new SolrTemplate(solrServer);
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "BuddyMe User Master Core connection exception", e, false);
        }
    }
    
    @Bean(name="solrBuddyMeUserSlaveTemplate")
    public SolrTemplate solrBuddyMeUserSlaveTemplate() throws FunOverflowBaseException{
        try {
            HttpSolrServer solrServer = new HttpSolrServer(environment.getRequiredProperty("solr.server.url.user.slave"));
            return new SolrTemplate(solrServer);
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "BuddyMe User Master Core connection exception", e, false);
        }
    }
    
    @Bean(name="solrBuddyMePublicEventMasterTemplate")
    public SolrTemplate solrBuddyMePublicEventMasterTemplate() throws FunOverflowBaseException{
        try {
            HttpSolrServer solrServer = new HttpSolrServer(environment.getRequiredProperty("solr.server.url.publicevent.master"));
            return new SolrTemplate(solrServer);
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "BuddyMe User Master Core connection exception", e, false);
        }
    }
    
    @Bean(name="solrBuddyMePublicEventSlaveTemplate")
    public SolrTemplate solrBuddyMePublicEventSlaveTemplate() throws FunOverflowBaseException{
        try {
            HttpSolrServer solrServer = new HttpSolrServer(environment.getRequiredProperty("solr.server.url.publicevent.slave"));
            return new SolrTemplate(solrServer);
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "BuddyMe User Master Core connection exception", e, false);
        }
    }
    
    @Bean(name="solrBuddyMePrivateEventMasterTemplate")
    public SolrTemplate solrBuddyMePrivateEventMasterTemplate() throws FunOverflowBaseException{
        try {
            HttpSolrServer solrServer = new HttpSolrServer(environment.getRequiredProperty("solr.server.url.privateevent.master"));
            return new SolrTemplate(solrServer);
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "BuddyMe User Master Core connection exception", e, false);
        }
    }
    
    @Bean(name="solrBuddyMePrivateEventSlaveTemplate")
    public SolrTemplate solrBuddyMePrivateEventSlaveTemplate() throws FunOverflowBaseException{
        try {
            HttpSolrServer solrServer = new HttpSolrServer(environment.getRequiredProperty("solr.server.url.privateevent.slave"));
            return new SolrTemplate(solrServer);
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "BuddyMe User Master Core connection exception", e, false);
        }
    }
} 
