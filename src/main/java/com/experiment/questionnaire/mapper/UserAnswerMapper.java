package com.experiment.questionnaire.mapper;

import com.experiment.questionnaire.pojo.UserAnswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author hjt
 * @date 2019/11/25 13:45
 */

@Repository
public interface UserAnswerMapper {

    Integer getTestCountByUserName(String userName);

    int deleteByUserIdAndTestOrder(@Param("userId") String userId, @Param("order") Integer order);

    int insertByBatch(List<UserAnswer> list);

    List<Map<String, Object>> selectEveryScoreByUserName(@Param("userName") String userName,
                                                         @Param("paperOrder") Integer paperOrder);
}
