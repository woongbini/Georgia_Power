//submit눌렀을때 db로 입력 정보 저장 시키는 로직
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

	// submit->저장
	public static int insertRegi(RegiPeopleDTO regi) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// db연결
		int result = 0;
		try {
			con = DBUtil.getConnection();
			System.out.println("db연결 성공");
			
			// insert 문장만 실행가능한 객체 생성
			pstmt = con.prepareStatement("insert into regi_people_table values(seq_loc1.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			// 데이터 대입 - ? 표기순으로 값 대입
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
			

			// DB에 insert 실행
			result = pstmt.executeUpdate();// DML문장 실행 메소드
			System.out.println("db저장성공");
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
		// select = query문장의 객체 결과
		ResultSet rset = null;
		ArrayList<RegiPeopleDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_people_table order by article_number desc");
			// table 존재할 경우 무조건 정상반환, 데이터 존재 유무는 매소드 통해서 검증 필수
			rset = pstmt.executeQuery();

			/* boolean next() : 해당 위치상의 행이 존재할 경우 true반환, 없을 경우 false */
			data = new ArrayList<RegiPeopleDTO>(); // 실제 쓰일 때 바로 위에 객체 생성해주기
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
		// select = query문장의 객체 결과
		ResultSet rset = null;
		ArrayList<RegiPeopleDTO> data = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from regi_people_table where sports = ?  ");
			pstmt.setString(1,sport_name);
			// table 존재할 경우 무조건 정상반환, 데이터 존재 유무는 매소드 통해서 검증 필수
			rset = pstmt.executeQuery();

			/* boolean next() : 해당 위치상의 행이 존재할 경우 true반환, 없을 경우 false */
			data = new ArrayList<RegiPeopleDTO>(); // 실제 쓰일 때 바로 위에 객체 생성해주기
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
