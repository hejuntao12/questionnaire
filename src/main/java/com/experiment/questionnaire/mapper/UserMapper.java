package com.experiment.questionnaire.mapper;

import com.experiment.questionnaire.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author hjt
 * @date 2019/11/25 20:07
 */
@Repository
public interface UserMapper {

    User getUserByName(String userName);

    int insertUser(User user);
}
