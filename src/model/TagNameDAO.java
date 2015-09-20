package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.domain.TagNameDTO;
import util.DBUtil;

public class TagNameDAO {
	public static int inserttag(TagNameDTO participants) throws SQLException {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      // db연결
	      
	      int result = 0;
	   
	      
	      try {
	         con = DBUtil.getConnection();
	         System.out.println("db연결 성공");
	         
	         // ratings(nickname, 에 data 넣기! 
	         pstmt = con.prepareStatement("insert into room_participants values(seq_room.nextval,?,?,?)");

	         // 데이터 대입 - ? 표기순으로 값 대입
	            pstmt.setInt(1,participants.getRoom_num());
	            pstmt.setString(2, participants.getNickname());
	            pstmt.setInt(3,participants.getLeader());
	            result = pstmt.executeUpdate();// DML문장 실행 메소드
	         

	         // DB에 insert 실행
	         
	         System.out.println("db저장성공");
	      } finally {
	         DBUtil.close(con, pstmt);
	      }
	      return result;
	   }
}
