package TheBombBoy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GameDBConnection {
	
	String conString = "bombboyDB";
	
	Connection conn = null;
	Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/"+conString;
			String id = "root";
			String pw = "1234";
			
			try {
				conn = DriverManager.getConnection(url, id, pw);
				System.out.println("연결 성공");
				
			} catch (SQLException e) {
				System.out.println("DB와 연결 실패");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB 찾기 실패");
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		
		new GameDBConnection().getConnection();
		
	}
	
}
