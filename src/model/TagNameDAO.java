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
	      // db����
	      
	      int result = 0;
	   
	      
	      try {
	         con = DBUtil.getConnection();
	         System.out.println("db���� ����");
	         
	         // ratings(nickname, �� data �ֱ�! 
	         pstmt = con.prepareStatement("insert into room_participants values(seq_room.nextval,?,?,?)");

	         // ������ ���� - ? ǥ������� �� ����
	            pstmt.setInt(1,participants.getRoom_num());
	            pstmt.setString(2, participants.getNickname());
	            pstmt.setInt(3,participants.getLeader());
	            result = pstmt.executeUpdate();// DML���� ���� �޼ҵ�
	         

	         // DB�� insert ����
	         
	         System.out.println("db���强��");
	      } finally {
	         DBUtil.close(con, pstmt);
	      }
	      return result;
	   }
}
