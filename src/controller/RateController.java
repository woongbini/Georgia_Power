package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Room_participantsDAO;
import model.ShowRateDAO;
import model.domain.ShowRateDTO;


public class RateController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String command = request.getParameter("command");

		if (command.equals("saveddata")) {
			// db에 등록 저장
			System.out.println("정보저장 실행");

			String[] countAll = request.getParameterValues("count");

			System.out.println("전체 개수 " + countAll.length + "<br>");
			// System.out.println("마지막 데이터 " + countAll[countAll.length-1]);

			String[] names = new String[countAll.length];
			String[] stars = new String[countAll.length];
			int[] yes_or_no = new int[countAll.length];

			// ShowRateDTO insert_rate = null;

			for (int i = 0; i < countAll.length; i++) {
				names[i] = request.getParameter("name" + (i + 1));
				stars[i] = request.getParameter("star" + (i + 1));
				if (stars[i].equals("0")) {
					yes_or_no[i] = 0;
				} else
					yes_or_no[i] = 1;
			}

			/*
			 * for(int i=0; i<countAll.length; i++){
			 * System.out.println(names[i]); System.out.println(stars[i]);
			 * System.out.println(yes_or_no[i]); } System.out.println("");
			 */

			try {
				ShowRateDAO.insertratedata(names, yes_or_no, stars);
				// request.setAttribute("insertData", insert_rate);
				response.sendRedirect("mydb?command=get_location");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (command.equals("all")) {
			try {
				// getroom_participantsall 불러주기! 여기다 방번호 추가
				ArrayList<String> all = Room_participantsDAO.getRoom_participantsAll(2);
				request.setAttribute("allData", all);
				request.getRequestDispatcher("evaluate.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "에러입니다");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
			}

		}else if(command.equals("showaverage")){
			try {
				System.out.println(2);
				ArrayList<ShowRateDTO> all = ShowRateDAO.averageData();
				request.setAttribute("allData", all);
				request.getRequestDispatcher("result.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "모든 검색 실패");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
			}
			
		}

	}

}