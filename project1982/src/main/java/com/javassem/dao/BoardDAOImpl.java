package com.javassem.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.BoardVO;
import com.javassem.util.PagingVO;



@Repository("boardDAO") 
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard() 호출");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() 호출");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList(HashMap map) {
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("BoardDAO.getBoardList", map);
	}

	public int countBoard() {
		return mybatis.selectOne("BoardDAO.countboard");
	}

	public List<BoardVO> selectBoard(PagingVO vo) {
		 List<BoardVO> result = mybatis.selectList("BoardDAO.selectBoard", vo);
			return result;
		}	
}

