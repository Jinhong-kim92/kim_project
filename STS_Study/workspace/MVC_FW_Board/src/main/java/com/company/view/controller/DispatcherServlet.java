package com.company.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	//�߰�
	private HandlerMapping handelerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException {
		handelerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
   
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
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
			   throws IOException {
		//1. Ŭ���̾�Ʈ�� ��û path ���� ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")); //    "/login.do"
		
		//2. HandlerMapping�� ���ؼ� path�� �ش��ϴ� Controller�� �˻��Ѵ�.
		Controller ctrl = handelerMapping.getController(path);
		
		//3. �˻��� Controller�� �����Ѵ�.
		//   ���� �� => "getBoardList.do" ���� ���� �� => "login" ����
		String viewName = ctrl.handleRequest(request, response);
		
		//4. ViewResolver�� ���ؼ� viewName�� �ش��ϴ� �������� �������ض�!!
		String view = null;
		
		if(viewName.contains(".do")) {  // "getBoardList.do"
			view = viewName;   // "getBoardList.do"
		}else {     // "login"
			view = viewResolver.getView(viewName);   // "./login.jsp"
		}		
		//5.�˻��� �������� �̵��Ѵ�.
		response.sendRedirect(view);
	}
}






