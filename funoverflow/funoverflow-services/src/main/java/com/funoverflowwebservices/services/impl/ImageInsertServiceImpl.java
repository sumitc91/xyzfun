package com.funoverflowwebservices.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.utils.DateTimeUtil;
import com.funoverflowwebservices.common.core.vo.SolrInsertImageEntity;
import com.funoverflowwebservices.common.domain.Response;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;
import com.funoverflowwebservices.services.ImageInsertService;
import com.funoverflowwebservices.services.dao.MySqlFetchAdapterDao;
import com.funoverflowwebservices.services.dao.impl.SolrSaveAdapter;

@Service("ImageInsertServiceImpl")
public class ImageInsertServiceImpl implements ImageInsertService {

	@Autowired
	MySqlFetchAdapterDao mySqlFetchAdapterDao;
	
	@Autowired
	SolrSaveAdapter solrSaveAdapter;
	
	public Response insertNewImageIntoSql(
			List<NewImageInsertRequestObject> newImageListInsertRequestObject)
			throws FunOverflowBaseException, SolrServerException, IOException {
		
		Response response = new Response();
		Map<String,String> responseMap = new HashMap<String,String>();
		responseMap = mySqlFetchAdapterDao.insertImageInMySqlDB(newImageListInsertRequestObject);
		
		/*List<SolrInsertImageEntity> solrInsertImageEntityList = createDummySolrInsertData();
		solrSaveAdapter.insertNewImage(solrInsertImageEntityList,false);*/
		
		response.setResponseCode("200");
		response.setResponseMessage("success");
		response.setResponseDetails("result", responseMap);
		
		return response;
	}

	public Response fetchAndInsertNewImageFromMySqlToSolr(
			)
			throws FunOverflowBaseException, SolrServerException, IOException {
		
		Response response = new Response();
		Map<String,String> responseMap = new HashMap<String,String>();
		int numberOfImagesToBeProcessedAtOnce=100;
		for(int i=0;i<2100;i+=numberOfImagesToBeProcessedAtOnce)
		{
			List<SolrInsertImageEntity> solrInsertImageEntitiesList = mySqlFetchAdapterDao.getImageDetailsFromMySqlDB(i, ((i+numberOfImagesToBeProcessedAtOnce)-1));
			if(solrInsertImageEntitiesList==null || solrInsertImageEntitiesList.size()<1)
				continue;
			solrSaveAdapter.insertNewImage(solrInsertImageEntitiesList, false);
		}
		
		
		/*List<SolrInsertImageEntity> solrInsertImageEntityList = createDummySolrInsertData();
		solrSaveAdapter.insertNewImage(solrInsertImageEntityList,false);*/
		
		response.setResponseCode("200");
		response.setResponseMessage("success");
		response.setResponseDetails("result", responseMap);
		
		return response;
	}
	private List<SolrInsertImageEntity> createDummySolrInsertData() {
		List<SolrInsertImageEntity> solrInsertImageEntityList = new ArrayList<SolrInsertImageEntity>();
		
		SolrInsertImageEntity solrInsertImageEntity = new SolrInsertImageEntity();
		
		List<String> tags = new ArrayList<String>();
        tags.add("project");
        tags.add("coder");
        
		solrInsertImageEntity.setId("1000");		
        solrInsertImageEntity.setTitle("my face when I read the specifications of a huge project.");
    	solrInsertImageEntity.setDescription("my face when I read the specifications of a huge project.");
    	solrInsertImageEntity.setAuthor("1");
    	solrInsertImageEntity.setTags(tags);
    	solrInsertImageEntity.setImageurl_l("1000__.gif");
    	solrInsertImageEntity.setLast_modified(DateTimeUtil.getCurrentGMT());
    	solrInsertImageEntityList.add(solrInsertImageEntity);
    	
    	solrInsertImageEntity = new SolrInsertImageEntity();
		
		tags = new ArrayList<String>();
        tags.add("crash");
        tags.add("tank");
        
		solrInsertImageEntity.setId("1002");		
        solrInsertImageEntity.setTitle("when I prevent a crash during a public presentation.");
    	solrInsertImageEntity.setDescription("when I prevent a crash during a public presentation.");
    	solrInsertImageEntity.setAuthor("1");
    	solrInsertImageEntity.setTags(tags);
    	solrInsertImageEntity.setImageurl_l("1002.gif");
    	solrInsertImageEntity.setLast_modified(DateTimeUtil.getCurrentGMT());
    	solrInsertImageEntityList.add(solrInsertImageEntity);
		//solrInsertImageEntity
		return solrInsertImageEntityList;
	}

	public List<SolrInsertImageEntity> getFunOverflowImagesFromSolr(
			Map<String, String> searchCriteria) throws FunOverflowBaseException {
		// TODO Auto-generated method stub
		return solrSaveAdapter.getFunOverflowImagesFromSolr(searchCriteria);
	}

	public Response fetchAndInsertNewImageFromMySqlToSolrWithoutTags()
			throws FunOverflowBaseException, SolrServerException, IOException {
		Response response = new Response();
		Map<String,String> responseMap = new HashMap<String,String>();
		int numberOfImagesToBeProcessedAtOnce=100;
		for(int i=0;i<2100;i+=numberOfImagesToBeProcessedAtOnce)
		{
			List<SolrInsertImageEntity> solrInsertImageEntitiesList = mySqlFetchAdapterDao.getImageDetailsFromMySqlDBWithoutTags(i, ((i+numberOfImagesToBeProcessedAtOnce)-1));
			if(solrInsertImageEntitiesList==null || solrInsertImageEntitiesList.size()<1)
				continue;
			solrSaveAdapter.insertNewImage(solrInsertImageEntitiesList, false);
		}
		
		
		/*List<SolrInsertImageEntity> solrInsertImageEntityList = createDummySolrInsertData();
		solrSaveAdapter.insertNewImage(solrInsertImageEntityList,false);*/
		
		response.setResponseCode("200");
		response.setResponseMessage("success");
		response.setResponseDetails("result", responseMap);
		
		return response;
	}

}
