package jdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import vo.BoardVO;

@Repository
public class BoardDAO {
	static Connection cn = DBConnection.getConnection();
	static Statement st;
	static PreparedStatement pst;
	static ResultSet rs;
	String sql;

	
	// Board Table 의 CRUD 구현
	// => selectList, selectOne, insert, update, delete 
	
	public ArrayList<BoardVO> selectList() {
		sql = "select * from board order by seq desc";
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				do {
					BoardVO vo = new BoardVO();
					vo.setSeq(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setId(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setRegdate(rs.getString(5));
					vo.setCnt(rs.getInt(6));
					list.add(vo);
				} while (rs.next());
			} else {
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception=>" + e.toString());
			list = null;
		}
		return list;
	} // selectList()
	
	public BoardVO selectOne(BoardVO vo) {
		sql = "select * from board where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			rs = pst.executeQuery();
			if (rs.next()) {
				vo.setTitle(rs.getString(2));
				vo.setId(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setRegdate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
			} else {
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception=>" + e.toString());
			vo = null;
		}
		return vo;
	} // selectOne

	public int insert(BoardVO vo) {
		sql = "insert into board values" + 
			  "((select nvl(max(seq), 0)+1 from board),?,?,?,sysdate,0)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getId());
			pst.setString(3, vo.getContent());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** insert Exception=>" + e.toString());
			return 0;
		}
	} // insert

	public int update(BoardVO vo) {
		sql = "update board set title=?, content=? where seq=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2,vo.getContent());
			pst.setInt(3, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception=>" + e.toString());
			return 0;
		}
	} // update

	public int delete(BoardVO vo) {
		sql = "delete board where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Exception=>" + e.toString());
			return 0;
		}
	} // delete

} // class
