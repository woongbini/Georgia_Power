package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.RegiLocationDAO;
import model.RegiPeopleDAO;
import model.domain.CommentDTO;
import model.domain.RegiLocationDTO;
import model.domain.RegiPeopleDTO;

public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int arti_num = 0;
		String command = request.getParameter("command");
		String sports = request.getParameter("sports");
		String reqData = request.getParameter("reqData");

		if (command.equals("register_people")) {
			// db에 등록 저장
			System.out.println("정보저장 실행");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);

			try {

				java.util.Date insert_date = fmt.parse(request.getParameter("date") + " " + request.getParameter("time") + ":00");
				java.sql.Timestamp sqlDate1 = new java.sql.Timestamp(insert_date.getTime());
				java.sql.Timestamp today = new java.sql.Timestamp(new java.util.Date().getTime());
				
				//사람게시판 넣기
				RegiPeopleDTO insert_regi = new RegiPeopleDTO( 
						request.getParameter("title"),
						request.getParameter("city"), 
						sqlDate1, 
						today, 
						Integer.parseInt(request.getParameter("number")),
						request.getParameter("age"), 
						request.getParameter("gender"), 
						sports, 
						request.getParameter("nickname"), // 세션에 저장된 닉네임 가져오기
						request.getParameter("location_name"),
						(float) 127.1052208,
						(float) 37.3595122, 
						request.getParameter("detail")
						);

				try {
					RegiPeopleDAO.insertRegi(insert_regi);
					request.setAttribute("insertData", insert_regi);
					request.getRequestDispatcher("main.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else if (command.equals("register_location")) {
			// db에 등록 저장
			System.out.println("정보저장 실행");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);

			try {
				java.util.Date insert_date = fmt
						.parse(request.getParameter("date") + " " + request.getParameter("time") + ":00");
				java.sql.Timestamp sqlDate1 = new java.sql.Timestamp(insert_date.getTime());
				java.sql.Timestamp today = new java.sql.Timestamp(new java.util.Date().getTime());
				
				//장소게피나 넣기
				RegiLocationDTO insert_regi = new RegiLocationDTO(
						request.getParameter("title"),
						request.getParameter("city"), 
						sqlDate1, 
						today, 
						sports, 
						request.getParameter("nickname"),
						request.getParameter("detail")
						);

				try {
					RegiLocationDAO.insertRegi(insert_regi);
					request.setAttribute("insertData", insert_regi);
					request.getRequestDispatcher("main.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else if (command.equals("get_location")) { // 장소게시판 불러오기
			System.out.println("장소 정보조회 실행");
			// db에서 조회
			ArrayList<RegiLocationDTO> regi;

			try {
				regi = RegiLocationDAO.getRegiAll();
				request.setAttribute("regiLocationData", regi);
				request.setAttribute("data", "loc");
				request.getRequestDispatcher("main.jsp").forward(request, response);
				System.out.println("장소 정보조회 실행완료");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (command.equals("get_people")) { // 사람게시판 불러오기
			System.out.println("사람 정보조회 실행");
			// db에서 조회
			ArrayList<RegiPeopleDTO> regi;
			try {
				regi = RegiPeopleDAO.getRegiAll();
				request.setAttribute("data", "peo");
				request.setAttribute("regiPeopleData", regi);
				request.getRequestDispatcher("main.jsp").forward(request, response);
				System.out.println("사람 정보조회 실행완료");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (command.equals("get_sport")) {
			if (sports.equals("get_soccer")) { // 축구
				System.out.println("축구 정보조회 실행");
				// db에서 조회
				try {
					if (reqData.equals("location")) {
						System.out.println("축구 장소 정보조회 실행");
						ArrayList<RegiLocationDTO> regi;
						regi = RegiLocationDAO.getSelectedRegi("축구");
						request.setAttribute("regiLocationData", regi);
						request.setAttribute("data", "loc");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("축구 장소 정보조회 실행완료");
					} else if (reqData.equals("people")) {
						System.out.println("축구 사람 정보조회 실행");
						ArrayList<RegiPeopleDTO> regi;
						regi = RegiPeopleDAO.getSelectedRegi("축구");
						request.setAttribute("regiPeopleData", regi);
						request.setAttribute("data", "peo");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("축구 사람 정보조회 실행완료");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (sports.equals("get_baseball")) { // 야구
				System.out.println("야구 정보조회 실행");
				// db에서 조회
				try {
					if (reqData.equals("location")) {
						System.out.println("야구 장소 정보조회 실행");
						ArrayList<RegiLocationDTO> regi;
						regi = RegiLocationDAO.getSelectedRegi("야구");
						request.setAttribute("regiLocationData", regi);
						request.setAttribute("data", "loc");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("야구 장소 정보조회 실행완료");
					} else if (reqData.equals("people")) {
						System.out.println("야구 사람 정보조회 실행");
						ArrayList<RegiPeopleDTO> regi;
						regi = RegiPeopleDAO.getSelectedRegi("야구");
						request.setAttribute("regiPeopleData", regi);
						request.setAttribute("data", "peo");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("야구 사람 정보조회 실행완료");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else if (sports.equals("get_tennis")) { // 테니스
				System.out.println("테니스 정보조회 실행");
				// db에서 조회
				try {
					if (reqData.equals("location")) {
						System.out.println("테니스 장소 정보조회 실행");
						ArrayList<RegiLocationDTO> regi;
						regi = RegiLocationDAO.getSelectedRegi("테니스");
						request.setAttribute("regiLocationData", regi);
						request.setAttribute("data", "loc");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("테니스 장소 정보조회 실행완료");
					} else if (reqData.equals("people")) {
						System.out.println("테니스 사람 정보조회 실행");
						ArrayList<RegiPeopleDTO> regi;
						regi = RegiPeopleDAO.getSelectedRegi("테니스");
						request.setAttribute("regiPeopleData", regi);
						request.setAttribute("data", "peo");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("테니스 사람 정보조회 실행완료");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (sports.equals("get_basketball")) { // 농구
				System.out.println("농구 정보조회 실행");
				// db에서 조회
				try {
					if (reqData.equals("location")) {
						System.out.println("농구 장소 정보조회 실행");
						ArrayList<RegiLocationDTO> regi;
						regi = RegiLocationDAO.getSelectedRegi("농구");
						request.setAttribute("regiLocationData", regi);
						request.setAttribute("data", "loc");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("농구 장소 정보조회 실행완료");
					} else if (reqData.equals("people")) {
						System.out.println("농구 사람 정보조회 실행");
						ArrayList<RegiPeopleDTO> regi;
						regi = RegiPeopleDAO.getSelectedRegi("농구");
						request.setAttribute("regiPeopleData", regi);
						request.setAttribute("data", "peo");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("농구 사람 정보조회 실행완료");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (sports.equals("get_running")) { // 런닝
				System.out.println("런닝 정보조회 실행");
				// db에서 조회
				try {
					if (reqData.equals("location")) {
						System.out.println("런닝 장소 정보조회 실행");
						ArrayList<RegiLocationDTO> regi;
						regi = RegiLocationDAO.getSelectedRegi("런닝");
						request.setAttribute("regiLocationData", regi);
						request.setAttribute("data", "loc");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("런닝 장소 정보조회 실행완료");
					} else if (reqData.equals("people")) {
						System.out.println("런닝 사람 정보조회 실행");
						ArrayList<RegiPeopleDTO> regi;
						regi = RegiPeopleDAO.getSelectedRegi("런닝");
						request.setAttribute("regiPeopleData", regi);
						request.setAttribute("data", "peo");
						request.getRequestDispatcher("main.jsp").forward(request, response);
						System.out.println("런닝 사람 정보조회 실행완료");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else if (command.equals("get_comment")) {
			System.out.println("get_comment started");
			ArrayList<CommentDTO> data = null;
			// int arti_num = 0;
			String artinum = request.getParameter("arti_num");
			if (artinum != null) {
				arti_num = Integer.parseInt(artinum);
			}
			System.out.println("arti_num" + arti_num);

			try {
				data = CommentDAO.getCommAll(arti_num);
				request.setAttribute("arti_num", arti_num);
				request.setAttribute("commData", data);
				System.out.println("commData : " + data);
				request.getRequestDispatcher("comment.jsp").forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (command.equals("register_comment")) {
			System.out.println("1");
			String artinum = request.getParameter("arti_num");
			if (artinum != null) {
				arti_num = Integer.parseInt(artinum);
			}
			System.out.println("arti_num" + arti_num);
			ArrayList<CommentDTO> data = null;
			java.sql.Timestamp today = new java.sql.Timestamp(new java.util.Date().getTime());

			CommentDTO insert_comm = new CommentDTO(arti_num, "웅비니", today, request.getParameter("comm"), "777kaka");

			try {
				System.out.println("2");
				CommentDAO.insertComm(insert_comm);
				request.setAttribute("insertComm", insert_comm);

				try {
					System.out.println("3");
					data = CommentDAO.getCommAll(arti_num);
					request.setAttribute("arti_num", arti_num);
					request.setAttribute("msg", "commReq");
					request.setAttribute("commData", data);
					request.getRequestDispatcher("comment.jsp").forward(request, response);

				} catch (SQLException e) {
					System.out.println("4");
					e.printStackTrace();
				}
			} catch (SQLException e) {
				System.out.println("5");
				e.printStackTrace();
			}
		}

	}

}
