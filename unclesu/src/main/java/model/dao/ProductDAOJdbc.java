package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ProductBean;
import model.ProductDAO;

public class ProductDAOJdbc implements ProductDAO {
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=java";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "passw0rd";
	
	private DataSource dataSource;

public ProductDAOJdbc(DataSource dataSource) {
//	 try {
//		Context ctx =new InitialContext();
//		  dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
//	} catch (NamingException e) {
//		e.printStackTrace();
//	}
		this.dataSource = dataSource;
	}

	//	public static void main(String[] args) {
//		ProductDAO productDao = new ProductDAOJdbc();
//		ProductBean select = productDao.select(2);
//		System.out.println(select);
//		
//		ProductBean update = productDao.update("HotDog1", 30, new java.util.Date(), 2, 10);
//		
////		update.setId(11);
////		ProductBean insert = productDao.insert(update);
////		System.out.println("insert="+insert);
//		
//		productDao.delete(11);
//		
//		List<ProductBean> beans = productDao.select();
//		System.out.println("beans="+beans);
//		
//	}
	private static final String SELECT_BY_ID = "select * from product where id=?";
	@Override
	public ProductBean select(int id) {
		ProductBean result = null;

		ResultSet rset = null;
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();	
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new ProductBean();
				result.setId(rset.getInt("id"));
				result.setName(rset.getString("name"));
				result.setPrice(rset.getDouble("price"));
				result.setMake(rset.getDate("make"));
				result.setExpire(rset.getInt("expire"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		return result;
	}
	
	private static final String SELECT_ALL = "select * from product";
	@Override
	public List<ProductBean> select() {
		List<ProductBean> result = null;
		
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<ProductBean>();
			while(rset.next()) {
				ProductBean row = new ProductBean();
				row.setId(rset.getInt("id"));
				row.setName(rset.getString("name"));
				row.setPrice(rset.getDouble("price"));
				row.setMake(rset.getDate("make"));
				row.setExpire(rset.getInt("expire"));
				
				result.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String INSERT = "insert into product (id, name, price, make, expire) values (?, ?, ?, ?, ?)";
	@Override
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			
			if(bean!=null) {
				stmt.setInt(1, bean.getId());
				stmt.setString(2, bean.getName());
				stmt.setDouble(3, bean.getPrice());
				java.util.Date make = bean.getMake();
				if(make!=null) {
					stmt.setDate(4, new java.sql.Date(make.getTime()));
				} else {
					stmt.setDate(4, null);
				}
				stmt.setInt(5, bean.getExpire());

				int i = stmt.executeUpdate();
				if(i==1) {
					result = this.select(bean.getId());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String UPDATE = "update product set name=?, price=?, make=?, expire=? where id=?";
	@Override
	public ProductBean update(String name,
			double price, java.util.Date make, int expire, int id) {
		ProductBean result = null;
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			if(make!=null) {
				stmt.setDate(3, new java.sql.Date(make.getTime()));
			} else {
				stmt.setDate(3, null);
			}
			stmt.setInt(4, expire);
			stmt.setInt(5, id);

			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.select(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String DELETE = "delete from product where id=?";
	@Override
	public boolean delete(int id) {
		try(//Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			
			stmt.setInt(1, id);
			int i = stmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
