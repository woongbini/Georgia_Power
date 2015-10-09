package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.CommentDTO;
import util.DBUtil;

public class CommentDAO {
	
	//INSERT
	public static int insertComm(CommentDTO comm) throws SQLException {
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into comment_table values(?,?,seq_loc1.nextval,?,?,?)");
			
			pstmt.setInt(1, comm.getArticle_number());
			pstmt.setString(2,  comm.getNickname());
			pstmt.setTimestamp(3, comm.getComm_regi_time());
			pstmt.setString(4, comm.getComm());
			pstmt.setString(5, comm.getKakao_key());
			
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	//select 
	/*public static CommentDTO getCommAll(int article_number) throws SQLException {
		CommentDTO comm = null;
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection(); //select * from comment_table order by COMMENT_NUM desc;
			pstmt = con.prepareStatement("select * from comment_table where article_number=? order by comment_num desc");
			pstmt.setInt(1, article_number);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				comm = new CommentDTO ( rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getTimestamp(4), rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return comm;
	}*/
	
	public static ArrayList<CommentDTO> getCommAll(int article_number) throws SQLException {
		ArrayList<CommentDTO> data = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from comment_table where article_number=? order by comment_num desc");
			pstmt.setInt(1,  article_number);
			rset = pstmt.executeQuery();
			data = new ArrayList<CommentDTO>();
			while(rset.next()) {
				data.add(new CommentDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getTimestamp(4), rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return data;
	}
	
	/*public static ArrayList<CommentDTO> getCommAll() throws SQLException {
		ArrayList<CommentDTO> data = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from comment_table order by COMMENT_NUM desc");
			rset = pstmt.executeQuery();
			data = new ArrayList<CommentDTO>();
			while(rset.next()) {
				data.add(new CommentDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getTimestamp(4), rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}*/
	
	//public static int deleteComm (int )
	
	/*private int article_number;
	private String nickname;
	private int comment_number;
	private Date comm_regi_time;
	private String comm;
	*/
}
