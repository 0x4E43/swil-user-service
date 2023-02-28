package com.swil.userservice.user.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.swil.userservice.user.dto.UserInfoDto;
import com.swil.userservice.user.entity.UserInfoBean;

public class UserInfoAssembler {
    private static Logger logger = LoggerFactory.getLogger(UserInfoAssembler.class);
    public static UserInfoDto convertBeantoDto(UserInfoBean bean){
        try {
            UserInfoDto dto = new UserInfoDto();
            BeanUtils.copyProperties(bean, dto);
            return dto;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("Exception occured: ", e);
            return null;
        }
    }
}
