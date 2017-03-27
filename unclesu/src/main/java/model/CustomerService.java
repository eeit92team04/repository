package model;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerService {
	// private CustomerDAO customerDao = new CustomerDAOJdbc();
	private CustomerDAO customerDao;

	public CustomerService(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}

	public boolean changePassword(String username, String oldPassword, String newPassword) {
		CustomerBean bean = this.login(username, oldPassword);
		if (bean != null) {
			if (newPassword != null && newPassword.length() != 0) {
				byte[] pass = newPassword.getBytes(); // �ϥΪ̿�J
				return customerDao.update(pass, bean.getEmail(), bean.getBirth(), username);
			}
		}
		return false;
	}

	public CustomerBean login(String username, String password) {
		CustomerBean bean = customerDao.select(username);
		if (bean != null) {
			if (password != null && password.length() != 0) {
				byte[] pass = password.getBytes(); // �ϥΪ̿�J
				byte[] temp = bean.getPassword(); // ��Ʈw��X

				if (Arrays.equals(pass, temp)) {
					return bean;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// CustomerService customerService = new CustomerService();
		// CustomerBean login = customerService.login("Alex", "A");
		// System.out.println("login="+login);
		//
		// customerService.changePassword("Ellen", "E", "EEE");
		//
		///LabWebServletJdbc/src/main/webapp/WEB-INF/beans.config.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/beans.config.xml");
		
//		ApplicationContext context = new AnnotationConfigApplicationContext(
//		model.settings.SpringJavaConfiguration.class);
		
		CustomerService customerService = (CustomerService) context.getBean("customerService");
		CustomerBean c = customerService.login("Alex", "A");
		System.out.println("login=" + c);
		((ConfigurableApplicationContext) context).close();
	}
}
