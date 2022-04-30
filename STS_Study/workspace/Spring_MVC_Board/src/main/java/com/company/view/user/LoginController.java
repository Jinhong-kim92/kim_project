package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.spring_mvc_board.user.UserDAO;
import com.company.spring_mvc_board.user.UserDO;

public class LoginController implements Controller{

	@Override  //다형성 => 메소드 오버라이딩
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		
		//1. 사용자 입력 정보 얻어오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. Model을 이용하여 H2 DB 연동 처리
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		//3. 포워딩
		ModelAndView mav = new ModelAndView();
		
		if(user != null) {			
			//System.out.println("로그인 인증 성공");
			HttpSession session = request.getSession();
			session.setAttribute("IdKey", id);
			
			//로그인 성공 시 실행될 화면 정보를 ModelAndView 객체에 저장하여 리턴한다.
			mav.setViewName("redirect:getBoardList.do");
		}else {
			mav.setViewName("redirect:login.jsp");
			//System.out.println("로그인 인증 실패");
		}		
		return mav;
	}
}







