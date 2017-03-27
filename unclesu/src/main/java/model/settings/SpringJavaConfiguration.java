package model.settings;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import model.CustomerService;
import model.ProductService;
import model.dao.CustomerDAOJdbc;
import model.dao.ProductDAOJdbc;

@Configuration
public class SpringJavaConfiguration {
	@Bean
	public DataSource dataSource() {
		System.out.println("calling dataSource()");
//		DriverManagerDataSource dmds = new DriverManagerDataSource();
//		dmds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		dmds.setUrl("jdbc:sqlserver://localhost:1433;database=java");
//		dmds.setUsername("sa");
//		dmds.setPassword("passw0rd");
		try {
			Context ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
		
		return null;
	}
	
	
	@Bean
	public CustomerService customerService(){	
//	CustomerDAO CustomerDAOJdbc = new CustomerDAOJdbc() ;
//	CustomerService customerService = new CustomerService(CustomerDAOJdbc);
//		return customerService;
//---------------------------------------------------------------------------------		
//	CustomerService customerService = new CustomerService(new CustomerDAOJdbc());	
//	return customerService;
	//---------------------------------------------------------------------------------		
	return new CustomerService(new CustomerDAOJdbc(dataSource()));
	}
	
	@Bean
	public ProductService productService(){	
		return new ProductService(new ProductDAOJdbc(dataSource()));
	}
}
