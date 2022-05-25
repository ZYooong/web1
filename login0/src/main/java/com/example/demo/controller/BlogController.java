package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.BlogInfo;

import com.example.demo.pepository.BlogInfoPepository;

@Controller
public class BlogController {
	@Autowired
	private BlogInfoPepository blogInfoPepository;
	
	@GetMapping("/conten")
	public String getBlogView() {
		return "conten";
	}
	@GetMapping("/page")
	public String getBlog1View() {
		return "page";
	}

	@GetMapping("/editor")
	public String getBlog2View() {
		return "editor";
	}
	@RequestMapping(value = "/editorInfo",method = RequestMethod.GET)
	public ModelAndView editorr(@RequestParam("title") String title,@RequestParam("conten") String conten,
			ModelAndView mv) {
		mv.addObject("title",title);
	 BlogInfo  blogInfo = new BlogInfo();
	 	blogInfo.setTitle(title);
		blogInfo.setConten(conten);
		
		BlogInfo blogInfo1 = blogInfoPepository.save(blogInfo);
		
		System.out.println(blogInfo1);
		if(title.equals(blogInfo1.getTitle()) && conten.equals(blogInfo1.getConten())) {
			mv.setViewName("page");
		}else {
			mv.setViewName("fail");
		}
		return mv;
	 }
	
}
