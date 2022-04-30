package com.company.view.controller;

public class ViewResolver {
	//��� �ʵ� ����
	public String prefix;	//���λ�   "./"
	public String suffix;	//���̻�   ".jsp"
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	/*
	 * (��) ������ �� �� => ./getBoardList.jsp
	 *    ./   => ���λ�   setPrefix("./");
	 *    getBoardList   => viewName
	 *    .jsp => ���̻�   setSuffix(".jsp");
	 */
	//�����(������) ���� �޼ҵ� ����
	public String getView(String viewName) {
		return prefix + viewName + suffix;   // "./login.jsp"
	}
}




