package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Date date = new Date();
		String command = request.getParameter("command");
		if (command.equals("GoMain")) {
			//濡쒓렇�씤 �쉶�썝媛��엯 泥댄겕
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		}
	}

