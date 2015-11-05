package com.funoverflowwebservices.common.core.technology.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

import com.funoverflowwebservices.common.core.utils.config.IConfiguration;

/*@Configuration
@PropertySource(value = { "classpath:properties/cassandra.properties" })
@EnableCassandraRepositories(basePackages = { "com.buddymewebservices" })*/
public class FunOverflowCassandraConfiguration extends AbstractCassandraConfiguration implements IConfiguration {

	@Autowired
	private Environment environment;

	@Override
	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
		cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
		return cluster;
	}

	@Override
	protected String getKeyspaceName() {
		return environment.getProperty("cassandra.keyspace.buddyme");
	}

	@Override
	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}

}