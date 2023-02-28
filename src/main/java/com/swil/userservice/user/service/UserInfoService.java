package com.swil.userservice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swil.userservice.core.dto.Response;
import com.swil.userservice.core.utils.UserLoginUtils;
import com.swil.userservice.user.dao.UserInfoDao;
import com.swil.userservice.user.dto.UserInfoDto;
import com.swil.userservice.user.entity.UserInfoBean;

@Service
public class UserInfoService {

    public static Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    UserInfoDao userDetailsDao;

    public String saveUser(UserInfoDto dto) {
        try {
            UserInfoBean bean = new UserInfoBean();
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
