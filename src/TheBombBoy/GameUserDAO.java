package TheBombBoy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GameUserDAO extends GameDBConnection{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public ArrayList<GameUser> InputUser(String userid){
		
		ArrayList<GameUser> UserInformationList = new ArrayList<GameUser>();
		
		conn = getConnection();
		String sql = "select * from gameuser where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				GameUser gu = new GameUser(rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				
				UserInformationList.add(gu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return UserInformationList;
	}
	
	void SignUpUser(String userid, String userpw, String username) {
		conn = getConnection();
		
		String sql = "insert into gameuser value(?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			pstmt.setString(3, username);
			pstmt.setInt(4, 1);
			pstmt.setString(5, "Beginner");
			pstmt.setInt(6, 1);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 1);
			
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("회원가입 실패");
		}
		close();
	}
	
	public boolean LoginUser(String userid, String userpw) {
		
		conn = getConnection();
		
		String sql = "select * from gameuser where userid = ? and userpw = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			rs = pstmt.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}finally {
			close();
		}
	}
	
	public boolean CheckUser(String userid) {
		conn = getConnection();
		
		String sql = "select * from gameuser where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	void updatePw(String userpw, String userid) {
		conn = getConnection();
		
		String sql = "update gameuser set userpw = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userpw);
			pstmt.setString(2, userid);
			
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("비밀번호 변경 실패");
			
		}
		close();
		
	}
	
	void updateName(String username, String userid) {
		conn = getConnection();
		
		String sql = "update gameuser set username = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, userid);
			
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("닉네임 변경 실패");
		}
		close();
		
	}
	
	void updateLevel(int userlevel, String userid) {
		conn = getConnection();
		String sql = "update gameuser set userlevel = ? where userid = ?";
		
		int newlevel = userlevel+1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newlevel);
			pstmt.setString(2, userid);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		
	}
	
	void updateAlias(String useralias, String userid) {
		conn = getConnection();
		String sql = "update gameuser set useralias = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, useralias);
			pstmt.setString(2, userid);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}
	
	void updateStage(int userstage, String userid) {
		conn = getConnection();
		String sql = "update gameuser set userstage = ? where userid = ?";
		
		int newstage = userstage+1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newstage);
			pstmt.setString(2, userid);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}
	
	void updateCoin(int usercoin, int getcoin,String userid) {
		conn = getConnection();
		
		String sql = "update gameuser set usercoin = ? where userid = ?";
		
		int newcoin = usercoin + getcoin;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newcoin);
			pstmt.setString(2, userid);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("코인 업데이트 실패");
		}
		close();
	}
	
	void updateAvatar(int useravatar, int usercoin ,int buycoin, String userid) {
		conn = getConnection();
		
		String sql = "update gameuser set useravatar = ?, usercoin = ? where userid = ?";
		
		int newcoin = usercoin - buycoin;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, useravatar);
			pstmt.setInt(2,  newcoin);
			pstmt.setString(3, userid);
			int n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("아바타 변경 실패");
		}
		close();
	}
	
	void close() {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
