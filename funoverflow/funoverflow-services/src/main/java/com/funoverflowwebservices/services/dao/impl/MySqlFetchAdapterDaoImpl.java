package com.funoverflowwebservices.services.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;
import com.funoverflowwebservices.common.core.technology.mysql.AbstractDAO;
import com.funoverflowwebservices.common.core.utils.ApiUrlSource;
import com.funoverflowwebservices.common.core.utils.DateTimeUtil;
import com.funoverflowwebservices.common.core.vo.SolrInsertImageEntity;
import com.funoverflowwebservices.common.request.vo.NewImageInsertRequestObject;
import com.funoverflowwebservices.services.dao.MySqlFetchAdapterDao;

@Service("MySqlFetchAdapterImpl")
public class MySqlFetchAdapterDaoImpl extends AbstractDAO implements MySqlFetchAdapterDao{

	private Logger logger = Logger.getLogger(this.getClass());
	
	 private static final String SINGLE_QUOTE = "\'";
	 
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
		String QUERY_IMAGE_INSERT = "INSERT INTO `funoverflow`.`image` (`id`, `imagename`, `height`, `width`, `title`, `description`, `addedby`, `createddate`, `updateddate`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String QUERY_IMAGE_TAGS_INSERT = "INSERT INTO `funoverflow`.`tags` (`imageid`,`name`, `description`, `createddate`) VALUES (?, ?, ?, ?)";

		logger.info(QUERY_IMAGE_INSERT);
		
		try {
			List<Object[]> inputList = new ArrayList<Object[]>();
			List<Object[]> inputListTags = new ArrayList<Object[]>();
			for (NewImageInsertRequestObject newImageInsertRequestObject : newImageList) {
				newImageInsertRequestObject.setImagename(newImageInsertRequestObject.getId()+"__.gif");
				Object[] inputArray = {
						newImageInsertRequestObject.getId(),
						newImageInsertRequestObject.getImagename(),
						newImageInsertRequestObject.getHeight(),
						newImageInsertRequestObject.getWidth(),
						newImageInsertRequestObject.getTitle(),
						newImageInsertRequestObject.getDescription(),
						Integer.parseInt(newImageInsertRequestObject.getAuthor()),
						DateTimeUtil.getCurrentDateTimeGMT(),
						DateTimeUtil.getCurrentDateTimeGMT()};
				
				for (String tag : newImageInsertRequestObject.getTags().split(";")) {
					Object[] inputArrayTags = {
							newImageInsertRequestObject.getId(),
							tag,
							null,
							DateTimeUtil.getCurrentDateTimeGMT()};
					inputListTags.add(inputArrayTags);
				}

				inputList.add(inputArray);
			}

			getJdbcTemplate().batchUpdate(
					QUERY_IMAGE_INSERT, inputList);
			getJdbcTemplate().batchUpdate(
					QUERY_IMAGE_TAGS_INSERT, inputListTags);
			
			return response;
		} catch (DataAccessException e) {
			throw new FunOverflowBaseException(
					"error in insertImageInMySqlDB", "90", e, false);
		}
		
	}
	public Map<String,String> insertImageInMySqlDB_storedProd(List<NewImageInsertRequestObject> newImageList) throws FunOverflowBaseException
	{
		Map<String,String> response =new  HashMap<String,String>();
		
		int userid = 1;
		
		for (NewImageInsertRequestObject newImageInsertRequestObject : newImageList) {
			
			Object[] accountArray = {
					newImageInsertRequestObject.getImagename(),
					newImageInsertRequestObject.getHeight(),
					newImageInsertRequestObject.getWidth(),
					newImageInsertRequestObject.getTitle(),
					newImageInsertRequestObject.getDescription(),
					userid
			};

			logger.info("insert new image api called :>>>" + newImageInsertRequestObject);

			SimpleJdbcCall procedure = new SimpleJdbcCall(getJdbcTemplate());
			procedure
					.withProcedureName("`funoverflow`.`insertnewimage`")
					.withoutProcedureColumnMetaDataAccess()
					.useInParameterNames("imagename", "height", "width",
							"title", "description", "userid")
					.declareParameters(
							new SqlParameter("imagename", Types.VARCHAR),
							new SqlParameter("height", Types.INTEGER),
							new SqlParameter("width", Types.INTEGER),
							new SqlParameter("title", Types.VARCHAR),
							new SqlParameter("description", Types.VARCHAR),
							new SqlParameter("userid", Types.INTEGER));

			Map<String, Object> procInputs = new HashMap<String, Object>();
			procInputs.put("imagename", accountArray[0]);
			procInputs.put("height", accountArray[1]);
			procInputs.put("width", accountArray[2]);
			procInputs.put("title", accountArray[3]);
			procInputs.put("description", accountArray[4]);
			procInputs.put("userid", accountArray[5]);
			

			Map<?, ?> procOutput = new HashMap<Object, Object>();
			try {
				procOutput = procedure.execute(procInputs);
			} catch (Exception e) {
				logger.error("insert new image exception", e);
			}

			logger.debug("insert new image procedure output : "
					+ procOutput);

			if (null != procOutput) {

				/*if (procOutput.get("isUniversityUser") != null) {
					int isUniversityUser = Integer.parseInt(procOutput.get(
							"isUniversityUser").toString());
					String groupId = (String) procOutput.get("groupId");
					if (isUniversityUser == 1) {
						//response.setIsUniversityUser(isUniversityUser);
						//response.setGroupId(groupId);
					}
				} else {
					//response.setIsUniversityUser(0);// if user is not from
													// university set value to zero.
				}*/
			}	
		}
		
		return response;	
	}
	
	public Map<String,String> insertImageInMySqlDB_Prev(List<NewImageInsertRequestObject> newImageList) throws FunOverflowBaseException
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
	public List<SolrInsertImageEntity> getImageDetailsFromMySqlDB(
			int fromId, int toId) throws FunOverflowBaseException {
		String Query = "SELECT image.id id ,tags.imageid tagid,image.imagename imagename,image.title title,image.description description,image.addedby addedby,image.updateddate updateddate,GROUP_CONCAT(DISTINCT (`tags`.`name`)) tags FROM funoverflow.image image  join funoverflow.tags tags where image.id=tags.imageid and image.id>="+fromId+" and image.id<="+toId+" group by tags.imageid ;";

	        logger.info(Query);
	        List<SolrInsertImageEntity> listSolrInsertImageEntity = new ArrayList<SolrInsertImageEntity>();
	        try {
	        	listSolrInsertImageEntity = getJdbcTemplate().query(Query,
	                new RowMapper<SolrInsertImageEntity>() {

	                    public SolrInsertImageEntity mapRow(ResultSet rs, int arg1) throws SQLException {
	                    	SolrInsertImageEntity solrInsertImageEntity = new SolrInsertImageEntity();

	                    	solrInsertImageEntity.setAuthor(rs.getString("addedby"));
	                    	solrInsertImageEntity.setDescription(rs.getString("description"));
	                    	solrInsertImageEntity.setId(rs.getString("id"));
	                    	solrInsertImageEntity.setImageurl_l(rs.getString("imagename"));
	                    	solrInsertImageEntity.setLast_modified(rs.getString("updateddate"));
	                    	solrInsertImageEntity.setTagsString(rs.getString("tags"));
	                    	solrInsertImageEntity.setTitle(rs.getString("title"));
	                        
	                        return solrInsertImageEntity;
	                    }
	                });
	        } catch (DataAccessException e) {
	            throw new FunOverflowBaseException("getImageDetailsFromMySqlDB exception", "90", e, false);
	        }
			return listSolrInsertImageEntity;
	}
}
