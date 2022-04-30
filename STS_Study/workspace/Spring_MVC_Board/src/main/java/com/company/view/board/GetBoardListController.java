package com.company.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.spring_mvc_board.board.BoardDAO;
import com.company.spring_mvc_board.board.BoardDO;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("��ü �Խñ� ��� ���� ó��");
		
		String searchField = "";
		String searchText = "";
		
		if(request.getParameter("searchCondition") != "" 
				&& request.getParameter("searchKeyword") != "") {
			searchField = request.getParameter("searchCondition");
			searchText = request.getParameter("searchKeyword");			
		}
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
		
		/*
		 * �Ʒ� �ҽ��� MVC �����ӿ�ũ ���� ��İ��� ������
		 */
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardList", boardList); //Model ���� ����
		mav.setViewName("getBoardList");       //View ���� ����
		
		return mav;
	}
}





