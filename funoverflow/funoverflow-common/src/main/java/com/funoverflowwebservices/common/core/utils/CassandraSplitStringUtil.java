package com.funoverflowwebservices.common.core.utils;

public class CassandraSplitStringUtil {

	public String splitWordonDelimiter(String StringToBeSplitted, String delim) {

		if (delim.equals("|"))
			delim = "\\|";

		if (StringToBeSplitted != null && (StringToBeSplitted.length() > 0)
				&& StringToBeSplitted.split(delim).length > 1) {
			if (StringToBeSplitted.split(delim)[1] == null)
				return "";

			return StringToBeSplitted.split(delim)[1];
		} else {
			return "";
		}
	}

	public String removeStartingAndEndingSingleQuotes(String text) {
		if (text.contains("\'")) {
			return text.substring(1, text.length() - 1);
		}
		return text;
	}

}
