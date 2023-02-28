package com.swil.userservice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swil.userservice.core.dto.Response;
import com.swil.userservice.core.utils.UserLoginUtils;
import com.swil.userservice.user.dao.UserDetailsDao;
import com.swil.userservice.user.dto.UserDetailsDto;
import com.swil.userservice.user.entity.UserDetailBean;

@Service
public class UserDetailService {

    public static Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Autowired
    UserDetailsDao userDetailsDao;

    public String saveUser(UserDetailsDto dto) {
        try {
            UserDetailBean bean = new UserDetailBean();
            bean.setEmailId("talk2nimai@gmail.com");
            bean.setUsername("nimai.c");
            bean.setPassword("Nimai@123");
            bean.setRole((short) 1);
            bean.setUUID(UserLoginUtils.generateUuid());
            bean = userDetailsDao.save(bean);
            dto.setId(bean.getId());
            dto.setUUID(bean.getUUID());
            return Response.success("User added successfully", dto);
        } catch (Exception e) {
            logger.error("ERROR WHILE SAVING USER", e);
            return Response.error("Unable to save user details");
        }
    }

}
