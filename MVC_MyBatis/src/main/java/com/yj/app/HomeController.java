package com.yj.app;


import java.util.List;
import java.text.DateFormat;
import java.util.Date;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MDao dao;
	
	@RequestMapping({"/","/main"})
	public String myMain(Model model) {
		List<MDto> list = dao.selectAll();
		model.addAttribute("list",list);
		
		return "main";
	} 
	
	
}
