package com.swil.userservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swil.userservice.user.entity.UserDetailsBean;

public interface UserDetailsDao extends JpaRepository<UserDetailsBean, Long>{
    
}
