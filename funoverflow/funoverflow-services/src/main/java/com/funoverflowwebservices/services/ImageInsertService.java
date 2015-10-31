package com.funoverflowwebservices.services;

import java.util.List;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.domain.Response;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;

public interface ImageInsertService {

	Response insertNewImageIntoSql(
			List<NewImageInsertRequestObject> newImageListInsertRequestObject) throws FunOverflowBaseException;

}
