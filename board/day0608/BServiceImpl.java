package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcUtil.BoardDAO;
import vo.BoardVO;

//** interface 자동완성 
//=> Shift + Alt + T

@Service
public class BServiceImpl implements BService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public ArrayList<BoardVO> selectList() {
		return dao.selectList() ;
	} // selectList()
	
	@Override
	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOne(vo);
	} // selectOne
	
	@Override
	public int insert(BoardVO vo) {  
		return dao.insert(vo);  // 처리된 row 갯수 return	 
	} // insert

	@Override
	public int update(BoardVO vo) { // row(vo) 전달 받아 수정
		return dao.update(vo);  // 처리된 row 갯수 return
	} // update

	@Override
	public int delete(BoardVO vo) {
		return dao.delete(vo);  // 처리된 row 갯수 return
	} // delete

} // class
