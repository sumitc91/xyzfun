package com.funoverflowwebservices.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
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
			throws FunOverflowBaseException {
		
		Response response = new Response();
		Map<String,String> responseMap = new HashMap<String,String>();
		//responseMap = mySqlFetchAdapterDao.insertImageInMySqlDB(newImageListInsertRequestObject);
		solrSaveAdapter.insertNewImage();
		response.setResponseCode("200");
		response.setResponseMessage("success");
		response.setResponseDetails("result", responseMap);
		
		return response;
	}

}
