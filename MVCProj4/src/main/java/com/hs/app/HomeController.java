package com.hs.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MVCDao dao;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping({"/","/main"})
	public String home(Model model) {
				
		List<MVCDto> list = dao.selectDataAll();
		model.addAttribute("list", list);
		return "main";
	}
	
	@RequestMapping("/insert")
	public String insert(MVCDto dto) {
		int res = dao.insertData(dto);
		// if (res >0){~~~~
		return "redirect:/main";
	}
	
	@RequestMapping("/delete")
	public String delete(MVCDto dto) {
		int res = dao.deleteData(dto.getIdx());
		// 실제로는 /main이 처리되는 부분이다.
		// 하지만 향후 개발에 있어서 return의 내용이 헤깔리수 있어서 
		// 명시적으로 내부에서 이동한다는 뜻으로 redirect:를 사용한다.
		return "redirect:/main";
	}
	
	@RequestMapping("/selectOne")
	public String selectOne(int idx, Model model) { // select 1개 한 값을 가지고 넘어갈 예정
		MVCDto rsone = dao.selectDataOne(idx);		
		if(rsone!=null) {
			model.addAttribute("rsone", rsone);
		}
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(MVCDto dto) {
		
		dao.update(dto);// 에러 여부에 따라 if 해주면 좋다
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="/ajax",method = RequestMethod.POST)
	@ResponseBody
	public HashMap ajaxCheckId(@RequestBody MVCDto dto) {
		//@RequestMapping 	@ResponseBody
		//클라이언트에서 서버로 필요한 데이터를 요청하기 위해서 json데이터를 요청 본문에 담아서
		//서버로 보내면 @requestBody 에노테이션을 사용하여 HTTP요청을 자바 객체로 만들어서 저장한다.
		//본 하단의 코드는 저장된 객체인 map을 return 으로 호출한 클라이언트로 던져준다.
		//map형식으로 하는 이유는 key,value 쌍으로 이루어진 json 과 같기 때문에 바로 적용 가능하다.
		//JSON은 최신의 데이터 전송 타입
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("res",dao.checkId(dto.getId()));
		return map;
	}
	
	
	
}


