package com.company.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.model2board.board.BoardDAO;
import com.company.model2board.board.BoardDO;
import com.company.model2board.user.UserDAO;
import com.company.model2board.user.UserDO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public DispatcherServlet() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
		
	}
	//������ ���� �޼ҵ�
	private void process(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws IOException {
		
		//1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		/* �Ʒ� �� ���� Model2 ��Ű��ó �������� ���� �߿��� �κ� */
		//    http://localhost:8080/Model2_Board/login.do
		String uri = request.getRequestURI();  // "/Model2_Board/login.do"�� ����
		String path = uri.substring(uri.lastIndexOf("/"));  // "/login.do" �� ����`
		
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó����!");
			
			//1. ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. Model�� �̿��� DB ���� ó��
			UserDO userDO = new UserDO();
			userDO.setId(id);
			userDO.setPassword(password);
			
			UserDAO userDAO =  new UserDAO();
			UserDO user = userDAO.getUser(userDO);
			
			//3. ȭ�� �׺���̼�(������)
			if(user != null) {
				//System.out.println("�α��� ����");
				HttpSession session = request.getSession();
				session.setAttribute("IdKey", id);
				response.sendRedirect("getBoardList.do");
			}else {
				//System.out.println("�α��� ����");
				response.sendRedirect("login.jsp");
			}
		}else if(path.equals("/getBoardList.do")){
			System.out.println("��ü �Խñ� ��� ���� ó����!");
			
			String searchField = "";
			String searchText = "";
			
			//����ڰ� ���ǿ� �´� ���ڵ� ���� �˻��ϴ� ���
			if(request.getParameter("searchCondition") != "" &&
					request.getParameter("searchKeyword") != "") {
				//1. ����� �Է� ���� ����
				searchField = request.getParameter("searchCondition");
				searchText = request.getParameter("searchKeyword");				
			}
			//2. Model�� �̿��� DB ���� ó��
			BoardDAO boardDAO =new BoardDAO();
			List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
			
			//3. [�߿�] board ���̺��� select ����� ���ǿ� �����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			//4. ������ => ����
			response.sendRedirect("getBoardList.jsp");
		}else if(path.equals("/getBoard.do")){
			System.out.println("�Խñ� �󼼺��� ó����!");
			
			//1. �˻��� �Խñ� ��ȣ ����
			String seq = request.getParameter("seq");
			
			//2. Model�� �̿��� DB ���� ó��
			BoardDO boardDO = new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardDO board = boardDAO.getBoard(boardDO);
			
			//3. [�߿�] board ���̺��� select ����� ���ǿ� �����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//4. ������ => ����
			response.sendRedirect("getBoard.jsp");			
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�Խñ� �Է� ó����!!");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardDO boardDO = new BoardDO();
			boardDO.setTitle(title);
			boardDO.setWriter(writer);
			boardDO.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(boardDO);
			
			response.sendRedirect("getBoardList.do");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�Խñ� ���� ó����!");
			
			request.setCharacterEncoding("EUC-KR");
			
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDO boardDO = new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));
			boardDO.setTitle(title);
			boardDO.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(boardDO);
			
			response.sendRedirect("getBoardList.do");		
		}else if(path.equals("/deleteBoard.do")){
			System.out.println("�Խñ� ���� ó����!");
			
			String seq = request.getParameter("seq");
			
			BoardDO boardDO = new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(boardDO);
			
			response.sendRedirect("getBoardList.do");
		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó����!");
			
			HttpSession session = request.getSession();
			session.invalidate(); //���� ����
			
			response.sendRedirect("login.jsp");
		}
	}
}










