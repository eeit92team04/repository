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

import model.OrderDetailsBean;
import model.OrderDetailsDAO;


public class OrderDetailsDAOjdbc implements OrderDetailsDAO {
	//private static DataSource dataSource;
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=UncleSu";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
//	private  DataSource dataSource;

	//public OrderDetailsDAOjdbc(DataSource dataSource) {
//	public OrderDetailsDAOjdbc() {
//		 try {
//		 Context ctx =new InitialContext();
//		 dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
//		 } catch (NamingException e) {
//		 e.printStackTrace();
//		 }
//		//this.dataSource = dataSource;
//	}
	public static void main(String[] args) {
		OrderDetailsDAO dao=new OrderDetailsDAOjdbc();
		List<OrderDetailsBean> select2=dao.select(1);
		System.out.println("select2="+select2);
		
	}
	private static final String SELECT_ALL = "select * from OrderDetails where odd_orderid=?";

	@Override
	public List<OrderDetailsBean> select(int odd_mealid) {
		// TODO Auto-generated method stub
		List<OrderDetailsBean> result = null;
		ResultSet rset = null;
		try (  Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				//Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				) {
			stmt.setInt(1, odd_mealid);
			rset = stmt.executeQuery();
			result = new ArrayList<OrderDetailsBean>();
			while(rset.next()) {
				OrderDetailsBean row = new OrderDetailsBean();
				row.setOdd_id(rset.getInt("odd_id"));
				row.setOdd_mealid(rset.getInt("Odd_mealid"));
				row.setOdd_orderid(rset.getInt("Odd_orderid"));
				row.setOrdd_count(rset.getInt("Ordd_count"));
				row.setOdd_money(rset.getDouble("Odd_money"));
				
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public OrderDetailsBean update(int odd_id, int odd_mealid, int ordd_count, double odd_money, int odd_orderid) {
		// TODO Auto-generated method stub
		return null;
	}

}
