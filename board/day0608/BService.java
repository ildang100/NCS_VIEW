package service;

import java.util.ArrayList;

import vo.BoardVO;

public interface BService {

	ArrayList<BoardVO> selectList(); // selectList()

	BoardVO selectOne(BoardVO vo); // selectOne

	int insert(BoardVO vo); // insert

	int update(BoardVO vo); // update

	int delete(BoardVO vo); // delete

}