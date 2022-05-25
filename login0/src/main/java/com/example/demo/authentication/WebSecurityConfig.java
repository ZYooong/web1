package com.example.demo.authentication;

import org.springframework.security.config.annotation.web.builders.WebSecurity;

public class WebSecurityConfig {
	public void configure(WebSecurity web) throws Exception {
	  web
	    .debug(false)
	    .ignoring()
	    .antMatchers("*.jpg", "*.css");
	}
}
