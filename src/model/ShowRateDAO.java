package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.ShowRateDTO;
import util.DBUtil;

public class ShowRateDAO {
	// submit->저장
	public static int insertratedata(String names[], int yes_or_no[], String stars[]) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// db연결
		int result = 0;
		int i = 0;

		try {
			con = DBUtil.getConnection();
			System.out.println("db연결 성공");

			// ratings(nickname, 에 data 넣기!
			pstmt = con.prepareStatement("insert into ratings values(?,?,?)");

			// 데이터 대입 - ? 표기순으로 값 대입

			for (i = 0; i < stars.length; i++) {
				pstmt.setString(1, names[i]);
				pstmt.setInt(2, yes_or_no[i]);
				pstmt.setString(3, stars[i]);
				result = pstmt.executeUpdate();// DML문장 실행 메소드
				// System.out.println("i의 값" + i);

			}

			// DB에 insert 실행

			System.out.println("db저장성공");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}

	// average 구하기
	public static ArrayList<ShowRateDTO> averageData() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ShowRateDTO> data = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"select nickname, avg(yes_or_no), avg(rate) from ratings group by nickname");
			// 테이블 존재 할 경우 무조건 정상 반환, 데이터 존재 유무는 메소드 통해서 검증 필수
			rset = pstmt.executeQuery();

			System.out.println("average 계산 성공");
			data = new ArrayList<ShowRateDTO>();
			while (rset.next()) {
				data.add(new ShowRateDTO(rset.getString(1), rset.getInt(2), rset.getInt(3)));
			}

			System.out.println("db저장 성공");
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}

	public static void main(String[] args) {
		// insertDept(new DeptDTO()); //접속이 되는지 확인
		ArrayList<ShowRateDTO> data = null;
		try {
			data = ShowRateDAO.averageData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(data);
	}

}
