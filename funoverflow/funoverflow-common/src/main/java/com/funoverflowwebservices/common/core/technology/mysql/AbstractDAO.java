package com.funoverflowwebservices.common.core.technology.mysql;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;

import com.funoverflowwebservices.common.core.utils.config.IConfiguration;

public abstract class AbstractDAO extends JdbcDaoSupport implements IConfiguration
{
	protected Logger log = Logger.getLogger(this.getClass());
	@Autowired(required=false)
	private DataSource dataSource;
	
	@Autowired(required=false)
	private PlatformTransactionManager transactionManager;
	
	@PostConstruct
	void init()
	{
		setDataSource(dataSource);
	}
	
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}