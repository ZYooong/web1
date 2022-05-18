package com.example.demo.pepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserInfo;

public interface UserInfoPepository extends JpaRepository<UserInfo,Long>{

	UserInfo findByName (String name);
}
