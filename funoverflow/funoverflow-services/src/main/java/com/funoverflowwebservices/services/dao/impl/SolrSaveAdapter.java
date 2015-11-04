package com.funoverflowwebservices.services.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.utils.DateTimeUtil;

@Component(value = "SolrSaveAdapter")
public class SolrSaveAdapter {

    
    @Autowired
    SolrTemplate solrFunoverflowTemplate;
    
    private static Logger log = Logger.getLogger(SolrSaveAdapter.class);

    
    public Map<String,Integer> insertNewImage() throws FunOverflowBaseException {
        
        SolrInputDocument doc = new SolrInputDocument();
        List<String> tags = new ArrayList<String>();
        tags.add("project");
        tags.add("coder");
        
        doc.addField("id", "1000");
        doc.addField("title", "my face when I read the specifications of a huge project");
        doc.addField("description", "my face when I read the specifications of a huge project");
        doc.addField("author", "1");
        doc.addField("tags", tags);
        doc.addField("imageurl_l","https://raw.githubusercontent.com/sumitc91/xyzfun/master/funoverflow/funoverflow-services/src/main/webapp/resources/images/1000__.gif");
        doc.addField("last_modified", DateTimeUtil.getCurrentGMT());
        
        
        SolrServer solrServer = solrFunoverflowTemplate.getSolrServer();
        try {
            UpdateResponse add = solrServer.add(doc);
            UpdateResponse commit = solrServer.commit();
            UpdateResponse optimize = solrServer.optimize();
            
            Map<String,Integer> status = new HashMap<String,Integer>();
            status.put("SolrAddStatus",  add.getStatus());
            status.put("SolrCommitStatus",   commit.getStatus());
            status.put("SolrOptimizeStatus",   optimize.getStatus());
            log.debug("Insert Status: "+ status);
            return status;
        } catch (Exception e) {
            throw new FunOverflowBaseException("90", "insertNewPublicEvent Fail exception", e, false);
        }
        
    }

	

}
