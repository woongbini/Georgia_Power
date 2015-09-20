//submit�������� db�� �Է� ���� ���� ��Ű�� ����
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.domain.RegiPeopleDTO;
import util.DBUtil;

public class RegiPeopleDAO {

	// submit->����
	public static int insertRegi(RegiPeopleDTO regi) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// db����
		int result = 0;
		try {
			con = DBUtil.getConnection();
			System.out.println("db���� ����");
			
			// insert ���常 ���డ���� ��ü ����
			pstmt = con.prepareStatement("insert into regi_people_table values(sq_loc_1.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			// ������ ���� - ? ǥ������� �� ����
			pstmt.setString(1, regi.getTitle());
			pstmt.setString(2, regi.getRegion());
			pstmt.setTimestamp(3, regi.getRegi_date());
			pstmt.setTimestamp(4, regi.getSys_date());
			pstmt.setInt(5, regi.getNumber_of_person());
			pstmt.setString(6, regi.getAge());
			pstmt.setString(7,regi.getGender());
			pstmt.setString(8,regi.getSport());
			pstmt.setString(9,regi.getUser_id());
			pstmt.setString(10, regi.getLocation_name());
			pstmt.setFloat(11, regi.getLocation_x());
			pstmt.setFloat(12, regi.getLocation_y());
			pstmt.setString(13, regi.getDetail());
			

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
	public static ArrayList<RegiPeopleDTO> getRegiAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// select = query������ ��ü ���
		ResultSet rset = null;
		ArrayList<RegiPeopleDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_people_table ");
			// table ������ ��� ������ �����ȯ, ������ ���� ������ �żҵ� ���ؼ� ���� �ʼ�
			rset = pstmt.executeQuery();

			/* boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���� ��� false */
			data = new ArrayList<RegiPeopleDTO>(); // ���� ���� �� �ٷ� ���� ��ü �������ֱ�
			while (rset.next()) {
				data.add(new RegiPeopleDTO(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getTimestamp(4),rset.getTimestamp(5),rset.getInt(6),rset.getString(7),
						rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11), rset.getFloat(12),rset.getFloat(13),rset.getString(14)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	public static ArrayList<RegiPeopleDTO> getSelectedRegi(String sport_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// select = query������ ��ü ���
		ResultSet rset = null;
		ArrayList<RegiPeopleDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_people_table where sports = ?  ");
			pstmt.setString(1,sport_name);
			// table ������ ��� ������ �����ȯ, ������ ���� ������ �żҵ� ���ؼ� ���� �ʼ�
			rset = pstmt.executeQuery();

			/* boolean next() : �ش� ��ġ���� ���� ������ ��� true��ȯ, ���� ��� false */
			data = new ArrayList<RegiPeopleDTO>(); // ���� ���� �� �ٷ� ���� ��ü �������ֱ�
			while (rset.next()) {
				data.add(new RegiPeopleDTO(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getTimestamp(4),rset.getTimestamp(5),rset.getInt(6),rset.getString(7),
						rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getFloat(12),rset.getFloat(13),rset.getString(14)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	public static void main(String[] args){
		try {
			System.out.println(getRegiAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
