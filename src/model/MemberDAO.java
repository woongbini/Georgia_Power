package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.MemberDTO;
import util.DBUtil;

public class MemberDAO {
	
	//insert
	public static int insertMember(MemberDTO member) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?,?)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getKakao_key());
			pstmt.setString(2, member.getNickname());
			pstmt.setString(3, member.getInter_loc());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getInter_sport());
			pstmt.setInt(6, member.getAge());
			
			result = pstmt.executeUpdate();
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static Boolean isMember(String kakao_key) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "select kakao_key from member where kakao_key=?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, kakao_key);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				if(kakao_key.equals(rset.getString(1))){
					return true;
				}
			}
		}catch(SQLException e){
			e.getStackTrace();
		}
		finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static MemberDTO getMyInfo(String kakao_key) throws SQLException {
		MemberDTO data = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from member where kakao_key=?");
			pstmt.setString(1, kakao_key);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				data = new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getString(5), rset.getInt(6) );
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return data;
	}
	
	public static ArrayList<MemberDTO> getMemberAll() throws SQLException {
		ArrayList<MemberDTO> data = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from member");
			rset = pstmt.executeQuery();
			data = new ArrayList<MemberDTO>();
			while (rset.next()) {
				data.add(new MemberDTO (rset.getString(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getString(5), rset.getInt(6) ) );
				
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return data;
	}
	public static int idCheck(String id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt =  null;
		ResultSet rset = null;
		int result = 1;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from member where nickname = ?");
			pstmt.setString(1,id);
			rset = pstmt.executeQuery();
			if(rset.next()){
				result = 0;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		System.out.println(result + "-------------------------------");
		return result;
	}
		
	
	public static String idsearch(String id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt =  null;
		ResultSet rset = null;
		String id1 = null;
		
		
		try{
			con = DBUtil.getConnection();System.out.println("db�뿰寃곗셿猷�");
			pstmt = con.prepareStatement("select nickname from member where nickname = ?");
			pstmt.setString(1,id);
			rset = pstmt.executeQuery();
			System.out.println("�떎�뻾�셿猷�");
			
			
			id1 = new String();
			if(rset.next()){
				  id1= rset.getString(1);
		         
			}
			return id1;
		}finally{
			DBUtil.close(con, pstmt);
		}
	}
	
	public static int updateMember(MemberDTO member) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update member set nickname = ?, inter_loc = ?, gender = ?, inter_sport = ?, age = ? where kakao_key = ?");
			
			//데이터 대입 - ? 표기순으로 값 대입
			
			pstmt.setString(1, member.getNickname());
			pstmt.setString(2, member.getInter_loc());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getInter_sport());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getKakao_key());
			
			//DB에 insert 실행
			result = pstmt.executeUpdate();//DML 문장 실행 메소드
		}finally{
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	
}