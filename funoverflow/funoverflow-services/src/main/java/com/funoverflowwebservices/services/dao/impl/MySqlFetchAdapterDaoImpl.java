package com.funoverflowwebservices.services.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.technology.mysql.AbstractDAO;
import com.funoverflowwebservices.common.core.utils.ApiUrlSource;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;
import com.funoverflowwebservices.services.dao.MySqlFetchAdapterDao;

@Service("MySqlFetchAdapterImpl")
public class MySqlFetchAdapterDaoImpl extends AbstractDAO implements MySqlFetchAdapterDao{

	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "ApiUrlSource")
	private ApiUrlSource apiUrlSource;
	
	/*public static void main(String args[])
	{
		System.out.println("testing..");
		List<NewImageInsertRequestObject> newImageList = new ArrayList<NewImageInsertRequestObject>();
		NewImageInsertRequestObject newImageInsertRequestObject = new NewImageInsertRequestObject();
		newImageInsertRequestObject.setAuthor("Author");
		newImageInsertRequestObject.setCategory("Category");
		newImageList.add(newImageInsertRequestObject);
		
		MySqlFetchAdapterDaoImpl mySqlFetchAdapterDaoImpl = new MySqlFetchAdapterDaoImpl();
		try {
			mySqlFetchAdapterDaoImpl.insertImageInMySqlDB(newImageList);
		} catch (FunOverflowBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public Map<String,String> insertImageInMySqlDB(List<NewImageInsertRequestObject> newImageList) throws FunOverflowBaseException
	{
		Map<String,String> response =new  HashMap<String,String>();
		String QUERY_INSERT_DISTRIBUTION_GROUP = "INSERT INTO `funoverflow`.`funImages` (`title`, `subject`, `description`, `comments`, `author`, `tags`, `category`, `imageurl_s`, `imageurl_l`, `lastmodified`, `views`, `likes`, `dislikes`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		logger.info(QUERY_INSERT_DISTRIBUTION_GROUP);

		try {
			List<Object[]> inputList = new ArrayList<Object[]>();
			for (NewImageInsertRequestObject newImage : newImageList) {
				Object[] inputArray = { newImage.getTitle(),
						newImage.getSubject(),
						newImage.getDescription(), 
						newImage.getComments(),
						newImage.getAuthor(),
						newImage.getTags(),
						newImage.getCategory(),
						newImage.getImageurl_s(),
						newImage.getImageurl_l(),
						newImage.getLast_modified(),
						newImage.getViews(),
						newImage.getLikes(),
						newImage.getDislikes()
						};
				inputList.add(inputArray);
			}

			getJdbcTemplate().batchUpdate(QUERY_INSERT_DISTRIBUTION_GROUP,
					inputList);
			
			response.put("mysql status", "success");
			return response;
		} catch (DataAccessException e) {
			throw new FunOverflowBaseException(
					"error in insertDistributionGroupList", "90", e, false);
		}
	}
}
