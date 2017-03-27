package output;

import java.sql.*;
import java.io.*;

public class BLOBDemo {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=UncleSu";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			for (int i = 1; i <= 15; i++) {

				String qryStmt = "SELECT meal_image FROM Meals WHERE meal_id = ?";
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setInt(1, i);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					FileOutputStream fos = new FileOutputStream(
							"C:/Project/workspace/unclesu/src/test/resources/output/" + i + ".jpg");
					Blob b = rs.getBlob("meal_image");
					byte[] data = b.getBytes(1, (int) b.length());
					fos.write(data, 0, (int) b.length());
					fos.close();
					System.out.println("File output is successful!" + i);
				}
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
