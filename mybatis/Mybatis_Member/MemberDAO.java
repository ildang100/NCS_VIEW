package jdbcUtil;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MPageVO;
import vo.MemberVO;

@Repository
public class MemberDAO {
	// @Inject 는  Java 에서 제공 , @Autowired 는 스프링 이 제공 
	@Autowired
	private SqlSession sqlsession;
	// 스프링 컨테이너가 setSqlSessionFactory 메서드를 자동으로 호출하여 
	// 스프링 설정파일(..-context.xml)에 <bean> 등록된 SqlSessionFactoryBean 객체를 인자로 받아	
	// 부모인 	SqlSessionDaoSupport 에 setSqlSessionFactory() 메서드로 설정해줌.
	// 이렇게 함으로 SqlSessionDaoSupport 로부터 상속된 getSqlSession() 메서드를 호출하여
	// SqlSession 객체를 return 받을 수 있게됨.
	
	private static final String NS="green.mappers.memberMapper.";
	
	public MPageVO pageList(MPageVO pvo) {
		// 1) totalCount (totalRowCount) 
		// => 전체 Row 갯수 set
		pvo.setTotalCount(sqlsession.selectOne(NS+"totalRowCount", pvo));
		// 2) 출력할 row select ( sno ~ eno )
		pvo.setList((ArrayList)sqlsession.selectList(NS+"pageList", pvo));
		return pvo;
	} // pageList()	
	
	public ArrayList<MemberVO> selectList() {
		return (ArrayList)sqlsession.selectList(NS+"selectList") ;
	} // selectList()
	
	public MemberVO selectOne(MemberVO vo) {
		return sqlsession.selectOne(NS+"selectOne", vo);
	} // selectList()
	
	public int insert(MemberVO vo) { 
		return sqlsession.insert(NS+"insert", vo);
	}
	public int update(MemberVO vo) { 
		return sqlsession.update(NS+"update", vo);
	}
	public int delete(MemberVO vo) {
		return sqlsession.delete(NS+"delete", vo) ;
	}

} // class
