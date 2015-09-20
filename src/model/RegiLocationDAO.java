//submit�������� db�� �Է� ���� ���� ��Ű�� ����
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.RegiLocationDTO;
import model.domain.SportDTO;
import util.DBUtil;

public class RegiLocationDAO {

	// submit->����
	public static int insertRegi(RegiLocationDTO regi) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// db����
		int result = 0;
		try {
			con = DBUtil.getConnection();
			System.out.println("db���� ����");
			
			// insert ���常 ���డ���� ��ü ����
			pstmt = con.prepareStatement("insert into regi_location_table values(seq_loc1.nextval,?,?,?,?,?,?,?)");

			// ������ ���� - ? ǥ������� �� ����
			pstmt.setString(1, regi.getTitle());
			pstmt.setString(2, regi.getRegion());
			pstmt.setTimestamp(3, regi.getRegi_date());
			pstmt.setTimestamp(4, regi.getSys_date());
			pstmt.setString(5, regi.getSport());
			pstmt.setString(6,regi.getUser_id());
			pstmt.setString(7, regi.getDetail());
			

			// DB�� insert ����
			result = pstmt.executeUpdate();// DML���� ���� �޼ҵ�
			System.out.println("db���强��");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
/*	public class RegiDTO {
	private int board_number;
	private String title;
	private String region;
	private Date date;
	private int number_of_person;
	private String age;
	private String gender;
	private String sport;
	private String user_id;
	private float location_x;
	private float location_y;
	private String detail;
*/
	public static ArrayList<RegiLocationDTO> getRegiAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// select = query������ ��ü ���
		ResultSet rset = null;
		ArrayList<RegiLocationDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_location_table ");
			// table ������ ��� ������ �����ȯ, ������ ���� ������ �żҵ� ���ؼ� ���� �ʼ�
			rset = pstmt.executeQuery();

			/* boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���� ��� false */
			data = new ArrayList<RegiLocationDTO>(); // ���� ���� �� �ٷ� ���� ��ü �������ֱ�
			while (rset.next()) {
				data.add(new RegiLocationDTO(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getTimestamp(4),rset.getTimestamp(5),rset.getString(6),
						rset.getString(7),rset.getString(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	public static ArrayList<RegiLocationDTO> getSelectedRegi(String sport_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// select = query������ ��ü ���
		ResultSet rset = null;
		ArrayList<RegiLocationDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_location_table where sports = ?");
			// table ������ ��� ������ �����ȯ, ������ ���� ������ �żҵ� ���ؼ� ���� �ʼ�
			pstmt.setString(1,sport_name);
			rset = pstmt.executeQuery();

			/* boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���� ��� false */
			data = new ArrayList<RegiLocationDTO>(); // ���� ���� �� �ٷ� ���� ��ü �������ֱ�
			while (rset.next()) {
				data.add(new RegiLocationDTO(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getTimestamp(4),rset.getTimestamp(5),rset.getString(6),
						rset.getString(7),rset.getString(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	public static void main(String[] args){
		try {
			System.out.println(getSelectedRegi("�߱�"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
