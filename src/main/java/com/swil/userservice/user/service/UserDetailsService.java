package com.swil.userservice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swil.userservice.user.dao.UserDetailsDao;
import com.swil.userservice.user.dto.UserDetailsDto;
import com.swil.userservice.user.entity.UserDetailsBean;

@Service
public class UserDetailsService {

    public static Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    UserDetailsDao userDetailsDao;

    public void saveUser(UserDetailsDto dto) {
        try {
            UserDetailsBean bean = new UserDetailsBean();
            bean.setEmailId("talk2nimai@gmail.com");
            bean.setUsername("nimai.c");
            bean.setPassword("Nimai@123");
            bean.setRole((short) 1);
            userDetailsDao.save(bean);
        } catch (Exception e) {
            logger.error("ERROR WHILE SAVING USER", e);
        }
    }

}
