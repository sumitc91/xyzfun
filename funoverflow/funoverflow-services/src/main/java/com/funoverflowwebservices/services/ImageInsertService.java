package com.funoverflowwebservices.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.vo.SolrInsertImageEntity;
import com.funoverflowwebservices.common.domain.Response;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;

public interface ImageInsertService {

	Response insertNewImageIntoSql(
			List<NewImageInsertRequestObject> newImageListInsertRequestObject) throws FunOverflowBaseException, SolrServerException, IOException;
	public Response fetchAndInsertNewImageFromMySqlToSolr(
			)
			throws FunOverflowBaseException, SolrServerException, IOException ;
	public List<SolrInsertImageEntity> getFunOverflowImagesFromSolr(Map<String,String> searchCriteria)
            throws FunOverflowBaseException;
}
