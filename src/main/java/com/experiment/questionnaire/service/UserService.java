package com.experiment.questionnaire.service;

import com.experiment.questionnaire.mapper.UserMapper;
import com.experiment.questionnaire.pojo.User;
import com.experiment.questionnaire.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hjt
 * @date 2019/11/25 17:49
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getOrCreateUserByName(String name){
        User user = userMapper.getUserByName(name);
        if(null == user){
            user = new User();
            user.setCId(CommonUtil.getUUID());
            user.setCName(name);
            userMapper.insertUser(user);
        }
        return user;
    }
}
