package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.domain.MemberDTO;

public class RegistController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");
		if (command.equals("LoginCheck")) {
			// 嚥≪뮄�젃占쎌뵥 占쎌돳占쎌뜚揶쏉옙占쎌뿯 筌ｋ똾寃�
			String kakao_key = request.getParameter("kakao_key");
			try {
				if (MemberDAO.isMember(kakao_key)) {
					request.getRequestDispatcher("goMain.html").forward(request, response);
					;
				} else {
					request.getRequestDispatcher("register.html").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("regist_request")) {
			String kakao_key = request.getParameter("kakao_key");
			String nickname = request.getParameter("nickname");
			String inter_loc = request.getParameter("inter_loc");
			String gender = request.getParameter("gender");
			String inter_sport = request.getParameter("inter_sport");
			int age = Integer.parseInt(request.getParameter("age"));

			try {
				MemberDAO.insertMember(new MemberDTO(kakao_key, nickname, inter_loc, gender, inter_sport, age));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("goMain.html").forward(request, response);
		}
	}
}
