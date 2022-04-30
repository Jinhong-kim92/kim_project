package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.spring_mvc_board.user.UserDAO;
import com.company.spring_mvc_board.user.UserDO;

public class LoginController implements Controller{

	@Override  //������ => �޼ҵ� �������̵�
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�α��� ó��");
		
		//1. ����� �Է� ���� ������
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. Model�� �̿��Ͽ� H2 DB ���� ó��
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		//3. ������
		ModelAndView mav = new ModelAndView();
		
		if(user != null) {			
			//System.out.println("�α��� ���� ����");
			HttpSession session = request.getSession();
			session.setAttribute("IdKey", id);
			
			//�α��� ���� �� ����� ȭ�� ������ ModelAndView ��ü�� �����Ͽ� �����Ѵ�.
			mav.setViewName("redirect:getBoardList.do");
		}else {
			mav.setViewName("redirect:login.jsp");
			//System.out.println("�α��� ���� ����");
		}		
		return mav;
	}
}







