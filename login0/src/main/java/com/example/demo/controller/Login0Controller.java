package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserInfo;
import com.example.demo.pepository.UserInfoPepository;

@Controller
public class Login0Controller {
	@Autowired
	private UserInfoPepository userInfoPepository;

	
	@GetMapping("/home")
	public String getSuccessView() {
		return "home";
				
	}
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password,
			ModelAndView mv) {
		mv.addObject("username",username);
		
		
		UserInfo userInfo = userInfoPepository.findByName (username);
		System.out.println(username);
		if(username.equals(userInfo.getName()) && password.equals(userInfo.getPassword())) {
			mv.setViewName("home");
		}else {
			mv.setViewName("register");
		}
		return mv;
	 }
	
}


