package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping("/login")
	public String getSuaccessView() {
		return "login";
				
	}
	@GetMapping("/register")
	public String getView() {
		return "register";
	}
	@RequestMapping(value = "/ulogin",method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password,
			ModelAndView mv) {
		mv.addObject("username",username);
		
		UserInfo userInfo = userInfoPepository.findByName (username);
		System.out.println(userInfo);
		if(username.equals(userInfo.getName()) && password.equals(userInfo.getPassword())) {
			mv.setViewName("home");
		}else {
			mv.setViewName("fail");
		}
		return mv;
	 }
	@RequestMapping(value = "/registerInfo")
	public ModelAndView register(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("password") String password,
			ModelAndView mv) {
		mv.addObject("username",username);
		UserInfo  userInfo = new UserInfo();
			userInfo.setEmail(email);
			userInfo.setName(username);
			userInfo.setPassword(password);
			userInfo.setId((long)100);
		UserInfo userInfo1 = userInfoPepository.save(userInfo);
		
		System.out.println(userInfo1);
		if(username.equals(userInfo1.getName()) && email.equals(userInfo1.getEmail()) && password.equals(userInfo1.getPassword())) {
			mv.setViewName("register");
		}else {
			mv.setViewName("fail");
		}
		return mv;
	 }

}


