package com.funoverflowwebservices.common.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import com.funoverflowwebservices.common.core.utils.CassandraSplitStringUtil;
import com.funoverflowwebservices.common.dao.CassandraCommonAdapter;

//@Service("CassandraCommonAdapterImpl")
public class CassandraCommonAdapterImpl implements CassandraCommonAdapter {

	@Autowired
    CassandraOperations cassandraTemplate;
    
    private Logger logger = Logger.getLogger(this.getClass());
    CassandraSplitStringUtil cassandraSplitStringUtil = new CassandraSplitStringUtil();
    
    /*public BuddyMeUser getBuddyMeUserDetailsFromToken(String token) throws BuddyMeBaseException {
        logger.debug("Fetching the buddyme user details for oauth :" + token);
        CassandraOperations cassandraOps = new CassandraTemplate(cassandraTemplate.getSession());
        Select s = QueryBuilder.select().from("buddyme", "user");
        s.where(QueryBuilder.eq("oauth", token.trim()));
        logger.debug("Query String: " + s.getQueryString());
        BuddyMeUser buddyMeUser = cassandraOps.selectOne(s, BuddyMeUser.class);
        logger.debug("buddyMeUser: " + buddyMeUser);
        return buddyMeUser;
    }*/

    
}
