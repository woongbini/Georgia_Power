package member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MemberFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberFormServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
         
        if(session.getAttribute("login_session")!=null){
            dispatcher = request.getRequestDispatcher("./res/modify_form.jsp");
            dispatcher.forward(request, response);
        }
        else{
            request.setAttribute("login_failure_message", "정보를 수정할 수 없습니다.\n로그인을 먼저 해주세요");
            dispatcher = request.getRequestDispatcher("./login_form.jsp");
             
            dispatcher.forward(request, response);
        }
    }
 
}
