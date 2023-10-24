package com.manerstech.resources;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.manerstech.dao.EmployeeDao;
import com.manerstech.dao.EmployeeDaoImpl;

@Configuration
@EnableTransactionManagement
public class SpringConfigFile {
	@Bean
	public DriverManagerDataSource dmDataSource() {
		DriverManagerDataSource dmDataSource=new DriverManagerDataSource();
		dmDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmDataSource.setUrl("jdbc:mysql://localhost:3306/springwithhibernate");
		dmDataSource.setUsername("root");
		dmDataSource.setPassword("Bhumi@123");
		
		return dmDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean mySessionFactory() {
		LocalSessionFactoryBean mySessionFactory=new LocalSessionFactoryBean();
		mySessionFactory.setDataSource(dmDataSource());
		
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		
		mySessionFactory.setHibernateProperties(hibernateProperties);
		
		mySessionFactory.setMappingResources("/com/manerstech/resources/employee.hbm.xml");
		
		return mySessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(mySessionFactory().getObject());
		
		return transactionManager;
	}
	
	@Bean
	public HibernateTemplate myHibernateTemplate() {
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory(mySessionFactory().getObject());
		return hibernateTemplate;
	}
	
	@Bean
	public EmployeeDao EmployeeDaoImpl() {
		EmployeeDaoImpl empDaoImpl=new EmployeeDaoImpl();
		empDaoImpl.setHibernateTemplate(myHibernateTemplate());
		return empDaoImpl;
		
	}
}
