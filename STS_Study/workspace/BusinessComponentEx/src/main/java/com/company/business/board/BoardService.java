package com.company.business.board;

import java.util.List;

public interface BoardService {
	//�߻� �޼ҵ� => �Խ���(board)�� � ����� �ʿ��ұ�?
	//�Խñ� ��� ���
	void insertBoard(BoardDO boardDO);
	
	//�Խñ� ���� ���
	void updateBoard(BoardDO boardDO);
	
	//�Խñ� ���� ���
	void deleteBoard(BoardDO boardDO);
	
	//��ü �Խñ� ��� ���� ���
	List<BoardDO> getBoardList();
	
	//Ư�� �Խñ� �󼼺��� ���
	BoardDO getBoard(BoardDO boardDO);
}


