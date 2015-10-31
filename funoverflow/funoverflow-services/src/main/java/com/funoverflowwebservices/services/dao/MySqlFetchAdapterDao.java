package com.funoverflowwebservices.services.dao;

import java.util.List;
import java.util.Map;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;


public interface MySqlFetchAdapterDao {
	public Map<String,String> insertImageInMySqlDB(List<NewImageInsertRequestObject> newImageList) throws FunOverflowBaseException;	
}
