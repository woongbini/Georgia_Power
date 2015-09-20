package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import util.DBUtil;

	public class Room_participantsDAO {

		public static ArrayList <String> getRoom_participantsAll(int room_number) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt =  null;
			ResultSet rset= null;
			ArrayList <String> nicknames = null;
		
			try{
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement("select nickname from room_participants where room_number=?");
				pstmt.setInt(1, room_number);
				rset=pstmt.executeQuery();
				nicknames = new ArrayList<String>();
				while(rset.next()){
					nicknames.add(new String (rset.getString(1)));
				}
			}
			finally{
				DBUtil.close(con,pstmt,rset);
			}
			return nicknames;
		}
		
		public static void main(String[] args) {
		
			
			ArrayList<String> nicknames = null;
		      
		      try {
		         nicknames=Room_participantsDAO.getRoom_participantsAll(2);
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      
		      for(int i=0 ; i<nicknames.size() ;i++) {
		         System.out.println(nicknames.get(i));
		      }
		   }

		
	}
