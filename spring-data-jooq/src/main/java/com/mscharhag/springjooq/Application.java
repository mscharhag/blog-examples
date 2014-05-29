package com.mscharhag.springjooq;

import com.mscharhag.springjooq.entity.User;
import com.mscharhag.springjooq.jooq.JooqRepositoryBean;
import com.mscharhag.springjooq.repository.UserRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.jooq.*;
import org.jooq.impl.*;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jooq");
		dataSource.setUsername("spring-data-jooq");
		dataSource.setPassword("spring-data-jooq");
		return dataSource;

//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		return builder.setType(EmbeddedDatabaseType.H2).build();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() throws SQLException {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.mscharhag.springjooq.entity");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public TransactionAwareDataSourceProxy transactionAwareDataSource() {
		return new TransactionAwareDataSourceProxy(dataSource());
	}

	@Bean
	public DataSourceConnectionProvider connectionProvider() {
		return new DataSourceConnectionProvider(transactionAwareDataSource());
	}


	@Bean
	public DefaultConfiguration configuration() {
		DefaultConfiguration jooqConfiguration = new DefaultConfiguration();

		jooqConfiguration.set(connectionProvider());
		jooqConfiguration.set(SQLDialect.MYSQL);
		jooqConfiguration.set(
				new RecordMapperProvider() {
					@Override
					public <R extends Record, E> RecordMapper<R, E> provide(RecordType<R> recordType, Class<? extends E> type) {
//						if (type == Product.class) {
//							return new RecordMapper<R, E>() {
//								@Override
//								public E map(R record) {
//									Object name = record.getValue("name");
//									Object price = record.getValue("price");
//									return (E) record.getValue("ID");
//								}
//							};
//						}

						return new DefaultRecordMapper(recordType, type);
					}
				}
		);
		return jooqConfiguration;
	}

	@Bean
	public DefaultDSLContext dsl() {
		return new DefaultDSLContext(configuration());
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public JpaRepositoryFactoryBean<UserRepository, User, Long> jpaRepositoryFactoryBean() {
		JpaRepositoryFactoryBean factory = new JooqRepositoryBean<UserRepository, User, Long>();
		factory.setRepositoryInterface(UserRepository.class);
		return factory;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
