package com.funoverflowwebservices.common.core.utils;

import com.funoverflowwebservices.common.constants.ResponseCode;
import com.funoverflowwebservices.common.core.vo.ResponseCodeDetails;

public final class ResponseCodeUtil {
	public static ResponseCodeDetails GetResponseCodeDetails(
			ResponseCode responseCode) {
		switch (responseCode) {
		case INVALID_USER:
			return new ResponseCodeDetails("401", "Invalid User.");
		case DB_EXCEPTION:
			return new ResponseCodeDetails("90",
					"An unexpected Database exception found.");
		case BACKEND_EXCEPTION: 
			return new ResponseCodeDetails("500",
					"Unable to access the backend.");
        case INVALID_PAGE_NO:
            return new ResponseCodeDetails("120",
                    "Invalid page no");
		default:
			break;
		}
		return null;
	}
}
