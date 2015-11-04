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
@EnableSolrRepositories(basePackages = { "com.funoverflowwebservices" })
public class SolrConfiguration implements IConfiguration {
    
    @Resource
    private Environment environment;
    
    @Bean(name="solrFunoverflowTemplate")
    public SolrTemplate solrFunoverflowTemplate() throws FunOverflowBaseException{
        try {
            HttpSolrServer solrServer = new HttpSolrServer(environment.getRequiredProperty("solr.server.url.funoverflow"));
            return new SolrTemplate(solrServer);
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "Funoverflow Core connection exception", e, false);
        }
    }
    
} 
