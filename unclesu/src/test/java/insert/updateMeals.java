package insert;

import java.sql.*;
import java.io.*;

public class updateMeals {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=UncleSu";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			for (int i = 1; i <= 15; i++) {

				String inFile = "C:/Project/workspace/unclesu/src/test/resources/temp/"+i+".jpg";
				File f = new File(inFile);
				FileInputStream fis = new FileInputStream(f);
				String insertStmt = "UPDATE Meals SET meal_image=? WHERE meal_id=?";
				PreparedStatement stmt = conn.prepareStatement(insertStmt);
				stmt.setBinaryStream(1, fis, f.length());
				stmt.setInt(2, i);
				stmt.executeUpdate();
				System.out.println("Insert blob is successful!"+i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class BLOBDemo
