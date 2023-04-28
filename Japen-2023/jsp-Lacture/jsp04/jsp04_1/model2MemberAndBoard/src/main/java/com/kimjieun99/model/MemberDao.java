package com.kimjieun99.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// dao가 db에 crud 할 예정임.
public class MemberDao {
	// crud 메서드를 생성.
	// create
	
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "KIMJIEUN99";
	private String pw = "1112";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("db연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void close() {
		
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
		        if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}
	
	public int insertMember(MemberDto memberDto) {
		int result=0;
		getConnection();
		
		String sql = "INSERT INTO MEMBER02 VALUES" 
		+ "(MEMBER02_SEQ.NEXTVAL,?,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,memberDto.getUserId());
			pstmt.setString(2,memberDto.getUserPW());
			pstmt.setString(3,memberDto.getUserName());
			pstmt.setString(4,memberDto.getUserEmail());
			pstmt.setString(5,memberDto.getUserHp());
			pstmt.setInt(6,memberDto.getZipCode());
			pstmt.setString(7,memberDto.getAddress());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	public MemberDto getLoggedMember(MemberDto memberDto) {
		MemberDto loggedMember = null;
		
		getConnection();
		String sql = "SELECT * FROM MEMBER02 WHERE USERID = ? AND USERPW = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserPW());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loggedMember = new MemberDto();
				loggedMember.setUserId(rs.getString("userId"));
				loggedMember.setUserName(rs.getString("userName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return loggedMember;
	}
	
	public MemberDto getLoggedMember(String userId, String userPW) {
MemberDto loggedMember = null;
		
		getConnection();
		String sql = "SELECT * FROM MEMBER02 WHERE USERID = ? AND USERPW = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.setString(2,userPW);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loggedMember = new MemberDto();
				loggedMember.setUserId(rs.getString("userId"));
				loggedMember.setUserName(rs.getString("userName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return loggedMember;
	}
	public int idCheck(String userId) {
		int result = 0;
		getConnection();
		String sql = "SELECT COUNT(*)AS COUNT" 
		+ "FROM MEMBER02 WHERE USERID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return result;
	}
}
