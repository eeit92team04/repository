package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.ProductBean;
import model.ProductService;
@WebServlet("/pages/product.controller")
public class ProductServlet extends HttpServlet {
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//	ProductService ProductService = new ProductService();
	ProductService productService;
	
	@Override
	public void init() throws ServletException {
		ServletContext application =this.getServletContext();
	 	ApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(application);
	 	 productService= (ProductService)context.getBean("productService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resporse) throws ServletException, IOException {
		//接收資料
		//id=aaa&name=bbb&price=ccc&make=ddd&expire=eee&prodaction=Select
		String temp1=request.getParameter("id");
		String name=request.getParameter("name");
		String temp3=request.getParameter("price");
		String temp4=request.getParameter("make");
		String temp5=request.getParameter("expire");
		String prodaction=request.getParameter("prodaction");	
		System.out.println("sss");
		
		
		//驗證資料
		
		
		
		Map<String,String> errors= new HashMap<String,String>();
		request.setAttribute("errors", errors);
		if("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)){
			System.out.println("判斷prodaction");
			if(temp1==null || temp1.length()==0){
				String errortext =("請輸入id已便"+prodaction+"操作");
				errors.put("xxx", errortext);
				System.out.println("xxx");
				
			}
		}else{
			System.out.println(prodaction);
		}		
		//轉換
		
		//輸入型別轉換
		int id =0;
		if(temp1!=null && temp1.length()!=0){
			try {
				id=Integer.parseInt(temp1);
			} catch (NumberFormatException e) {				
				e.printStackTrace();
				errors.put("xxx", "id:請輸入正確的int型態");
			}
		}
		
		double price =0;
		if(temp3!=null && temp3.length()!=0){
			try {
				price=Double.parseDouble(temp3);
			} catch (NumberFormatException e) {				
				e.printStackTrace();
				errors.put("price", "expire:請輸入正確的double型態");
			}
		}
	
		int expire =0;
		if(temp5!=null && temp5.length()!=0){
			try {
				expire=Integer.parseInt(temp5);
			} catch (NumberFormatException e) {				
				e.printStackTrace();
				errors.put("expire", "expire:請輸入正確的int型態");
			}
		}
		
		java.util.Date make =null;
		if(temp4!=null && temp4.length()!=0){			
				 try {
					make =sdf.parse(temp4);					
				}  catch (ParseException e) {
					errors.put("make", "make:請輸入正確的日期型態");					
					e.printStackTrace();
				}	
		}
		//輸入型別轉換
		System.out.println(make);
		if(errors!=null && ! errors.isEmpty()){
			request.getRequestDispatcher("/pages/product.jsp").forward(request, resporse);
		}
		
		//呼叫model
		
		ProductBean ProductBean=new ProductBean();
		ProductBean.setId(id);
		ProductBean.setName(name);
		ProductBean.setPrice(price);
		ProductBean.setMake(make);
		ProductBean.setExpire(expire);
		
		
		//根據model執行結果呼叫view
		
		if("Select".equals(prodaction)){
			List<ProductBean> select =productService.select(ProductBean);					
			request.setAttribute("select", select);			
			request.getRequestDispatcher("/pages/display.jsp").forward(request, resporse);
			}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}

}
