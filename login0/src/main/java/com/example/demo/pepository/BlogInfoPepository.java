package com.example.demo.pepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BlogInfo;

public interface BlogInfoPepository extends JpaRepository<BlogInfo,Long>{

	BlogInfo findByTitle (String name);
}
