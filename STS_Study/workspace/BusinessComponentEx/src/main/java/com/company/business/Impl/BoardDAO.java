package com.company.business.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.business.board.BoardDO;
import com.company.business.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<BoardDO> getBoardList(){
		System.out.println("===> getBoardList() �޼ҵ� ó����!");
		
		//ArrayList ���� �迭 ��ü ����
		List<BoardDO> boardList = new ArrayList<BoardDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			//���� ���� ���� => �ֱٿ� �ۼ��� ������ ��������!!
			String BOARD_LIST = "select * from board order by seq desc";
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDO board = new BoardDO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				boardList.add(board);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return boardList;
	} //end getBoardList() �޼ҵ� ==========================================
	
	//�Խñ� ��� ó�� �޼ҵ�
	public void insertBoard(BoardDO boardDO) {
		System.out.println("===> JDBC�� insertBoard() ó����");
		
		try {
			conn = JDBCUtil.getConnection();
			String INSERT_BOARD 
			   = "insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
			pstmt = conn.prepareStatement(INSERT_BOARD);
			pstmt.setString(1, boardDO.getTitle());
			pstmt.setString(2, boardDO.getWriter());
			pstmt.setString(3, boardDO.getContent());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	} //end insertBoard() ====================================
	
	public BoardDO getBoard(BoardDO boardDO) {
		return null;
	}
}








