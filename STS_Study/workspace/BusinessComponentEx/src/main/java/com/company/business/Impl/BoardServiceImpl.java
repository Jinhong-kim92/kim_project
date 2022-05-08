package com.company.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.business.board.BoardDO;
import com.company.business.board.BoardService;
import com.company.business.common.LogAdvice;

//������ => �������̽��� �����Ͽ� �ذ��Ѵ�.

//����Ͻ� ������ ó���ϴ� Ŭ����
@Service("boardService")
public class BoardServiceImpl implements BoardService{  //���� Ŭ����
	//[�߿�]
	@Autowired
	private BoardDAO boardDAO;    //������ �����̳ʰ� �̹� ������� ��ü�� ������ ����(DI)
	//���� �߰�
	private LogAdvice log;        //������ �����̳ʰ� �̹� ������� ��ü�� ������ ����(DI)
	
	//������
	//public BoardServiceImpl() {
		//log = new LogAdvice();
	//}

	@Override
	public void insertBoard(BoardDO boardDO) {
		//�߰�
		//log.printLog();
		boardDAO.insertBoard(boardDO);		
	}

	@Override
	public void updateBoard(BoardDO boardDO) {
		//log.printLog();
		//boardDAO.updateBoard(boardDO);
	}

	@Override
	public void deleteBoard(BoardDO boardDO) {
		//log.printLog();
		//boardDAO.deleteBoard(boardDO);
	}

	@Override //������
	public List<BoardDO> getBoardList() {	
		//log.printLog();
		return boardDAO.getBoardList();
	}

	@Override
	public BoardDO getBoard(BoardDO boardDO) {
		//log.printLog();
		return boardDAO.getBoard(boardDO);
	}
}