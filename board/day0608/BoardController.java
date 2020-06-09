package com.ncs.green;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.BService;
import vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BService service;
	// 새글 등록
	@RequestMapping(value = "/binsertf")
	public ModelAndView binsertf(ModelAndView mv) {
		mv.setViewName("board/binsertForm");
		return mv;
	}// binsertf 
	
	@RequestMapping(value = "/blist")
	public ModelAndView blist(ModelAndView mv) {
		ArrayList<BoardVO> list = service.selectList();
		if (list != null) {
			mv.addObject("Banana", list);  
		} else {
			mv.addObject("message", "~~ 검색된 자료가 1건도 없습니다. ~~");
		}
		mv.setViewName("board/boardList");
		return mv;
	} // blist
	
	@RequestMapping(value = "/bdetail")
	public ModelAndView bdetail(HttpServletRequest request, ModelAndView mv, BoardVO vo) {
		// selectOne
		vo = service.selectOne(vo);
		mv.setViewName("board/boardDetail");
		if (vo!=null) {
			mv.addObject("Detail", vo);
			// 글 수정 인지 확인
			if ("U".equals(request.getParameter("code"))) {
				mv.setViewName("board/bupdateForm");
			} else if ("E".equals(request.getParameter("code"))) { // 글정보 수정에서 오류 상황
				mv.addObject("message", "~~ 내정보 수정 오류  !!! 다시 하세요 ~~");
			}
		}else {
			mv.addObject("fCode","BN");
			mv.setViewName("member/doFinish");
		}
		return mv;
	}// bdetail
	
	// 새글등록 , 수정, 삭제 => login 후에만 가능
	// boardList, boardDetail -> login 한 경우에만 [새글등록]
	// boardDetail 
	// -> login 한 본인의 글 인경우에만 [수정, 삭제]
	// -> login 했고 본인글 아닌경우 [새글등록] 만가능
	@RequestMapping(value = "/binsert")
	public ModelAndView binsert(ModelAndView mv, BoardVO vo) {
		
		if (service.insert(vo)>0) {
			// 글등록 성공 -> boardList 로 
			mv.setViewName("redirect:blist");
		}else {
			// 글등록 실패
			//	-> doFinish 로
			//     메시지 출력 , 다시 하기 ===> 새글등록 
			mv.addObject("fCode","BI");
			mv.setViewName("member/doFinish");
		}
		return mv;
	}// binsert
	
	@RequestMapping(value="/bupdate")
	public ModelAndView bupdate(ModelAndView mv, BoardVO vo) {
		
		if (service.update(vo)>0) //성공 => 글목록 출력 (blist)
			mv.setViewName("redirect:blist");
		else { // 실패 => doFinish.jsp
			mv.addObject("fCode","BU");
			mv.setViewName("member/doFinish");
		}	
		return mv ;	
	} //bupdate
	
	@RequestMapping(value="/bdelete")
	public ModelAndView bdelete(ModelAndView mv, BoardVO vo) {
		
		if (service.delete(vo)>0) //성공 => 글목록 출력 (blist)
			mv.setViewName("redirect:blist");
		else { // 실패 => doFinish.jsp
			mv.addObject("fCode","BD");
			mv.setViewName("member/doFinish");
		}	
		return mv ;	
	} //bdelete

} // class
