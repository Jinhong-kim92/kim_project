package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.spring_mvc_board.board.BoardDAO;
import com.company.spring_mvc_board.board.BoardDO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�Խñ� �󼼺��� ó��");
		
		//getBoardList.jsp ���������� get ������� �Ѿ�� �Խñ۹�ȣ ����
		String seq = request.getParameter("seq");
		
		BoardDO boardDO = new BoardDO();
		boardDO.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardDO board = boardDAO.getBoard(boardDO);	
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);  //Model ��� ���� ����
		mav.setViewName("getBoard");    //View ����(������) ����
		
		return mav;
	}
}



