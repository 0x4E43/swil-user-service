package com.swil.userservice.auth.service;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swil.userservice.auth.dto.UserAuthDto;
import com.swil.userservice.core.dto.Response;
import com.swil.userservice.core.enums.FlagEnums;
import com.swil.userservice.core.enums.UserRoleEnums;
import com.swil.userservice.core.utils.UserLoginUtils;
import com.swil.userservice.user.component.UserInfoAssembler;
import com.swil.userservice.user.dao.UserInfoDao;
import com.swil.userservice.user.dto.UserInfoDto;
import com.swil.userservice.user.entity.UserInfoBean;

@Service
public class AuthService {

    private static Logger logger = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    UserInfoDao userInfoDao;

    public String login(UserAuthDto dto){
        return Response.success("Login Successfull", dto);
    }

    public String signup(UserInfoDto dto) {
        try{
            if(dto.getEmailId()==null || dto.getMobile()==null){
                Response.error("Email ID or Mobile Number can't be empty");
            }
            if(dto.getPassword()==null){
                Response.error("Password can't be empty.");
            }
            //TODO: filter based on isDeleted and isDisabled
            UserInfoBean bean = userInfoDao.findByEmailIdIgnoreCaseOrMobile(dto.getEmailId());
            if(bean==null){
                bean.setFname(dto.getFname()!=null?dto.getFname():generateRandomString());
                bean.setLname(dto.getLname()!=null?dto.getLname():generateRandomString());
                bean.setMobile(dto.getMobile());
                bean.setEmailId(dto.getEmailId());
                bean.setPassword(null);
                bean.setRole(dto.getRole()!=null?dto.getRole():UserRoleEnums.USER.getValue());
                bean.setUUID(UserLoginUtils.generateUuid());
                //TODO: set as per creator
                bean.setCreatedBy(10000l);
                
                //TODO: set as per modifier
                bean.setModifiedBy(10000l);
                bean.setCreatedDate(new Date());
                bean.setModifiedDate(new Date());
                bean.setIsDeleted(FlagEnums.NO.getValue());
                bean.setIsDisabled(FlagEnums.NO.getValue());
                bean = userInfoDao.save(bean);
                dto = UserInfoAssembler.convertBeantoDto(bean);
                //TODO: generate JWT Token
                // dto.setToken(UserLoginUtils.generateJWT(dto));
                return Response.success("User created successfully", dto);
            }
            return Response.error("User with same email or mobile already exists");
        }catch(Exception e){
            logger.error("Exception occured: ", e);
            return Response.error("Something went wrong while creating user.");
        }
        
    }

    private String generateRandomString(){
        try{
            int length = 10;
            boolean useLetters = true;
            boolean useNumbers = false;
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
            return generatedString;
        }catch(Exception e){
            logger.info("Exception occured: "+e.getMessage());
            return null;
        }
    }
}
