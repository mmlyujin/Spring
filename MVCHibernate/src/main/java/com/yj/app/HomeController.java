package com.yj.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	HiberDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping({"/","selectAll"})
	public String home(Model model) {//메인 페이지 ->첫페이지에서 select한거 다 나오게 하고 싶음.
		// List로 값 가져옴
		List<HiberDTO> list = dao.selectAll();
		
		// model에 담기
		model.addAttribute("list",list);
		
		
		return "home";
	}
	
	@RequestMapping("/selectOne")
	public String selectOne(Model model,HiberDTO dto) {
		//idx를 이용해서 한개의 Dto로 값 가져옴
		HiberDTO d = dao.selectOne(dto);
		
		//모델에 담기
		model.addAttribute("dto",d);
		
		return "one";
	}
	
	
	@RequestMapping("/insertData")
	public String insertData(HiberDTO dto) {
		//dao의 insert 실행
		dao.insertData(dto);
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/deleteData")
	public String deleteData(HiberDTO dto) {
		//dao의 delete 실행
		dao.deleteData(dto);
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/updateData")
	public String updateData(HiberDTO dto) {
		dao.updateData(dto);
		
		return "redirect:/";
	}
	
	//=============hbdummy table end===========
	
	
	
	
	//========board table start
	@RequestMapping({"/board","selectAllBoard"})
	public String board(Locale locale,Model model) {//게시판 입력 페이지
		// List로 값 가져옴
		List<BoardDTO> blist = dao.selectAllBoard();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("list", blist); 
		
		return "boardMain";
	}
	
	
	@RequestMapping("/selectOneBoard")
	public String selectOneBoard(Model model,BoardDTO bdto) {
		//idx를 이용해서 한개의 Dto로 값 가져옴
		BoardDTO bd = dao.selectOneBoard(bdto);
		
		//모델에 담기
		model.addAttribute("dto",bd);
		
		return "oneBoard"; 
	}
	
	
	@RequestMapping("/insertBoard")
	public String insertBoard(BoardDTO bdto) {
		dao.insertBoard(bdto);	
		return "redirect:/board";
	}
	
	
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardDTO bdto) {
		//dao의 delete 실행
		dao.deleteBoard(bdto);
		
		
		return "redirect:/board";
	}
	
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardDTO bdto) {
		dao.updateBoard(bdto);
		
		return "redirect:/board";
		
	}
	
}
