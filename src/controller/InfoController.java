/* 처리로직
 *  1. 모든부서 정보요청:all.html
 *  2. 특정부서 정보요청:deptno.html
 *  3. 추가 저장로직 요청:insert.html
 *  4. 삭제 로직요청:delete.html
 *  5. 추가 로직요청 : login.html -로그인 후에나 다른 로직 수행
 * 
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.domain.MemberDTO;

public class InfoController extends HttpServlet {
	// client가 접속시 container가 자동실행
	/*
	 * 1. 어떤요청인지 구분 2. 해당 요청별 처리 로직 명확하게 구분해서 실행 위임 3. 발생된 모든 경우의 수에 적합한 jsp를
	 * 지정해서 view 실행 위임
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command");
		/*
		 * 모두 보기 요청 1.DAO의 getAll()메소드 호출 2.ArrayList 획득 3.데이터존재유무확인? 4.정상데이터반환시
		 * -successAll.jsp -포워드[디스페처]page이동 - 비정상데이터 반환시 - errorAll.jsp
		 * -포워드page이동
		 * 
		 */

		if (command.equals("myinfo")) {
			MemberDTO myinfo = null;

			String kakao_key = (String) request.getParameter("kakao_key");

			try {
				myinfo = MemberDAO.getMyInfo(kakao_key);
				String nickname = myinfo.getNickname();
				int age = myinfo.getAge();
				String gender = myinfo.getGender();
				String inter_loc = myinfo.getInter_loc();
				String inter_sport = myinfo.getInter_sport();
				request.setAttribute("nickname", nickname);
				request.setAttribute("age", age);
				request.setAttribute("gender", gender);
				request.setAttribute("inter_loc", inter_loc);
				request.setAttribute("inter_sport", inter_sport);
				request.getRequestDispatcher("modify_info.jsp").forward(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "모든검색실패");
				request.getRequestDispatcher("errorAll.jsp").forward(request, response);
			}
		}else if (command.equals("regist_request")) {
			String kakao_key = "49853625";
			String nickname = request.getParameter("nickname");
			String inter_loc = request.getParameter("inter_loc");
			String gender = request.getParameter("gender");
			String inter_sport = request.getParameter("inter_sport");
			int age = Integer.parseInt(request.getParameter("age"));

			try {
				MemberDAO.updateMember(new MemberDTO(kakao_key, nickname, inter_loc, gender, inter_sport, age));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("goMain.html").forward(request, response);
		}
		
			/*
			 * id를 리다이렉트로 이동시에도 사용 가능하게 데이터 유지 = 상태유지 1.세션 - 상태유지값 서버 메모리 활용
			 * 2.쿠키 - 상태유지값을 client pc에 저장(쿠키파일 도는 브라우저 자체 메모리)
			 * 
			 */
			// 세션 객체 생성
			/*
			 * [1] getSession() 1.접속한 client만의 세션 객체가 미 존재시 새로 생성 2. ""이미 존재할 경우
			 * 재사용 [2] jsp 특징 HttpSession = request.getSession();//생성
			 * session.setAttribute("name","반석");//세션에 이름 저장
			 */

		 		}	

	}	
	

