package insert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertAttendanceRecord {
	public static void main(String[] args) {
		Connection conn = null;


		try {
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=UncleSu";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			String qryStmt = "SELECT * FROM MSchedule";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				

				Date date = rs.getDate("msched_date");
				String mc = rs.getString("msched_class").trim();
				int me = rs.getInt("msched_empid");
				
				String insStmt = "INSERT INTO AttendanceRecord (arecord_empid, arecord_date, arecord_start, arecord_end) VALUES (?, ?, ?, ?)";
				pstmt = conn.prepareStatement(insStmt);
				int temp;
				System.out.println(mc);
				switch (mc) {
				case "A":
					System.out.println("hereA");
					pstmt.setInt(1, me);
					pstmt.setDate(2, date);
					temp = (int) ((Math.random()) * 10);
					pstmt.setString(3, "9:5" + temp);
					pstmt.setString(4, "14:0" + temp);
					pstmt.addBatch();
					pstmt.setInt(1, me);
					pstmt.setDate(2, date);
					temp = (int) ((Math.random()) * 10);
					pstmt.setString(3, "16:2" + temp);
					pstmt.setString(4, "20:3" + temp);
					pstmt.addBatch();

					break;
				case "B":
					System.out.println("hereB");
					pstmt.setInt(1, me);
					pstmt.setDate(2, date);
					temp = (int) ((Math.random()) * 10);
					pstmt.setString(3, "10:5" + temp);
					pstmt.setString(4, "15:0" + temp);
					pstmt.addBatch();
					pstmt.setInt(1, me);
					pstmt.setDate(2, date);
					temp = (int) ((Math.random()) * 10);
					pstmt.setString(3, "17:2" + temp);
					pstmt.setString(4, "21:3" + temp);
					pstmt.addBatch();

					break;
				case "C":
					System.out.println("hereC");
					pstmt.setInt(1, me);
					pstmt.setDate(2, date);
					temp = (int) ((Math.random()) * 10);
					pstmt.setString(3, "11:2" + temp);
					pstmt.setString(4, "15:3" + temp);
					pstmt.addBatch();
					pstmt.setInt(1, me);
					pstmt.setDate(2, date);
					temp = (int) ((Math.random()) * 10);
					pstmt.setString(3, "18:5" + temp);
					pstmt.setString(4, "22:0" + temp);
					pstmt.addBatch();

					break;
				}
				pstmt.executeBatch();

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
