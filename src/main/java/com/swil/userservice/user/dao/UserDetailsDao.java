package com.swil.userservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swil.userservice.user.entity.UserDetailBean;

public interface UserDetailsDao extends JpaRepository<UserDetailBean, Long>{
    
}
