package com.swil.userservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swil.userservice.user.entity.UserInfoBean;

public interface UserInfoDao extends JpaRepository<UserInfoBean, Long>{

    UserInfoBean findByEmailId(String emailId);

    UserInfoBean findByEmailIdIgnoreCaseOrMobile(String emailId);
    
}
