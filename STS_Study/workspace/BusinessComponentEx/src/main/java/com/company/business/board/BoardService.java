package com.company.business.board;

import java.util.List;

public interface BoardService {
	//추상 메소드 => 게시판(board)의 어떤 기능이 필요할까?
	//게시글 등록 기능
	void insertBoard(BoardDO boardDO);
	
	//게시글 수정 기능
	void updateBoard(BoardDO boardDO);
	
	//게시글 삭제 기능
	void deleteBoard(BoardDO boardDO);
	
	//전체 게시글 목록 보기 기능
	List<BoardDO> getBoardList();
	
	//특정 게시글 상세보기 기능
	BoardDO getBoard(BoardDO boardDO);
}


