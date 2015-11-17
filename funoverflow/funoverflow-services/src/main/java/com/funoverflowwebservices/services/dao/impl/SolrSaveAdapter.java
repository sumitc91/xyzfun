package com.funoverflowwebservices.services.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.utils.DateTimeUtil;
import com.funoverflowwebservices.common.core.vo.SolrInsertImageEntity;

@Component(value = "SolrSaveAdapter")
public class SolrSaveAdapter {

    
    @Autowired
    SolrTemplate solrFunoverflowTemplate;
    
    private static Logger log = Logger.getLogger(SolrSaveAdapter.class);

    
    public Map<String,Integer> insertNewImage(List<SolrInsertImageEntity> solrInsertImageEntityList,boolean isTesting) throws FunOverflowBaseException, SolrServerException, IOException {
        
        
        SolrServer solrServer = solrFunoverflowTemplate.getSolrServer();
        UpdateResponse add = new UpdateResponse();
        if(isTesting)
        {
        	List<String> tags = new ArrayList<String>();
            tags.add("project");
            tags.add("coder");
            SolrInputDocument doc = new SolrInputDocument();
            
            doc.addField("id", "1000");
            doc.addField("title", "my face when I read the specifications of a huge project - testing");
            doc.addField("description", "my face when I read the specifications of a huge project - testing");
            doc.addField("author", "1");
            doc.addField("tags", tags);
            doc.addField("imageurl_l","1000__.gif");
            doc.addField("last_modified", DateTimeUtil.getCurrentGMT());
            add = solrServer.add(doc);
        }
        else
        {
        	for (SolrInsertImageEntity solrInsertImageEntity : solrInsertImageEntityList) {
        		
        		List<String> tags = new ArrayList<String>();
        		if(solrInsertImageEntity.getTagsString() != null)
        		{
        			for (String tag : solrInsertImageEntity.getTagsString().split(",")) {
        				tags.add(tag);
    				}
        		}
        		
        		SolrInputDocument doc = new SolrInputDocument();
        		doc.addField("id", solrInsertImageEntity.getId());
                doc.addField("title", solrInsertImageEntity.getTitle());
                doc.addField("description", solrInsertImageEntity.getDescription());
                doc.addField("author", solrInsertImageEntity.getAuthor());
                doc.addField("tags", tags);
                doc.addField("imageurl_l",solrInsertImageEntity.getImageurl_l());
                doc.addField("last_modified", solrInsertImageEntity.getLast_modified());
                add = solrServer.add(doc);
                log.debug("id : "+solrInsertImageEntity.getId());
			}
            
        }
        
        try {
            
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

    public List<SolrInsertImageEntity> getFunOverflowImagesFromSolr(Map<String,String> searchCriteria)
            throws FunOverflowBaseException {
            SolrServer solrServer = solrFunoverflowTemplate.getSolrServer();
            SolrQuery query = new SolrQuery();
            
            String fetchFrom=searchCriteria.get("fetchFrom");
            String fetchUpto = searchCriteria.get("fetchUpto");
            query.add("q", "*:*");
            query.add("sort", "last_modified desc");            
            query.add("start", fetchFrom);
            query.add("rows", fetchUpto);
            log.debug("Solr Query: "+ query.getQuery());

            try {
                QueryResponse queryResponse = solrServer.query(query, METHOD.POST);
                List<SolrInsertImageEntity> list = queryResponse.getBeans(SolrInsertImageEntity.class);
                return list;
            } catch (SolrServerException e) {
                throw new FunOverflowBaseException("90", "getFunOverflowImagesFromSolr exception", e, false);
            }
        }
	

}
