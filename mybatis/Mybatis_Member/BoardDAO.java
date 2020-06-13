package jdbcUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.BoardVO;
import vo.PageVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlsession ;
	private static final String NS ="green.mappers.boardMapper." ;
	
	// Paging Test	
		public PageVO pageList(PageVO pvo) {
			pvo.setTotalCount(sqlsession.selectOne(NS+"totalRowCount"));
			pvo.setList(sqlsession.selectList(NS+"pageList", pvo));
			return pvo;
		} 
		
		public List<BoardVO> selectList() {
			return sqlsession.selectList(NS+"selectList");
		} // selectList
		
		public BoardVO selectOne(BoardVO vo) {
			return sqlsession.selectOne(NS+"selectOne",vo) ;
		} // selectOne
		
		public int insert(BoardVO vo) {
			return sqlsession.insert(NS+"insert",vo) ;
		} // insert
		
		public int update(BoardVO vo) {
			return sqlsession.update(NS+"update",vo) ;
		} // update
		
		public int delete(BoardVO vo) {
			return sqlsession.delete(NS+"delete",vo) ;
		} // delete
		
		public int countUp(BoardVO vo) {
			return sqlsession.update(NS+"countUp",vo) ;    
		} // countUp
		
		public int rinsert(BoardVO vo) {
			System.out.println("** rinsert StepUp count =>"+sqlsession.update(NS+"stepUpdate",vo));
			return sqlsession.insert(NS+"rinsert",vo) ;
		} // rinsert

} // class
