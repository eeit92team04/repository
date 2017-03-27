package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.dao.ProductDAOJdbc;

public class ProductService {
	//private ProductDAO productDao = new ProductDAOJdbc();
	private ProductDAO productDao ;
	public ProductService(ProductDAO productDao) {		
		this.productDao = productDao;
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context =new  ClassPathXmlApplicationContext("/WEB-INF/beans.config.xml");
	//	ApplicationContext context =new 
	//			AnnotationConfigApplicationContext(model.settings.SpringJavaConfiguration.class);
		ProductService product	= (ProductService)context.getBean("productService");
		//select all
		List<ProductBean> sel =product.select(null);
		System.out.println("select"+sel);
		//select  
		ProductBean s1=sel.get(14);		
		System.out.println("select"+s1);
		//update
		s1.setPrice(160);
		ProductBean	up=product.update(s1);
		System.out.println("update"+up);
		//insert
		ProductBean pb1= new ProductBean();
		pb1.setId(555);
		pb1.setName("sss");
		pb1.setPrice(10);
		pb1.setMake(new java.util.Date());
		pb1.setExpire(10);
		ProductBean ins= product.insert(pb1);
		System.out.println("insert"+ins);
		//
		boolean de =product.delete(pb1);
		System.out.println("delete="+de);
		    
		((ConfigurableApplicationContext) context).close();
	}
	
	public List<ProductBean> select(ProductBean bean) {
		List<ProductBean> result = null;
		if(bean!=null && bean.getId()!=0) {
			ProductBean temp = productDao.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<ProductBean>();
				result.add(temp);
			}
		} else {
			result = productDao.select(); 
		}
		return result;
	}
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			result = productDao.insert(bean);
		}
		return result;
	}
	public ProductBean update(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			result = productDao.update(bean.getName(), bean.getPrice(),
					bean.getMake(), bean.getExpire(), bean.getId());
		}
		return result;
	}
	public boolean delete(ProductBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = productDao.delete(bean.getId());
		}
		return result;
	}
}
