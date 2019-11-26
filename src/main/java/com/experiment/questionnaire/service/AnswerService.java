package com.experiment.questionnaire.service;

import com.alibaba.fastjson.JSON;
import com.experiment.questionnaire.mapper.UserAnswerMapper;
import com.experiment.questionnaire.pojo.User;
import com.experiment.questionnaire.pojo.UserAnswer;
import com.experiment.questionnaire.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hjt
 * @date 2019/11/25 18:14
 */
@Service
public class AnswerService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserAnswerMapper userAnswerMapper;

    public String getHistoryScore(String userName){
        List<Map<String, Object>> scoreList = userAnswerMapper.selectEveryScoreByUserName(userName);
        return JSON.toJSONString(scoreList);
    }

    public void saveUserAnswer(Map<String, String[]> map){
        try{
            User user = userService.getOrCreateUserByName(map.get("username")[0]);
            String userId = user.getCId();
            Integer paperOrder = Integer.valueOf(map.get("paperorder")[0]);
            userAnswerMapper.deleteByUserIdAndPaperOrder(userId, paperOrder);
            List<UserAnswer> answerList = parseAnswerList(map, userId, paperOrder);
            userAnswerMapper.insertByBatch(answerList);
        } catch (Exception e) {
            logger.error("解析表单提交失败", e);
        }
    }

    private List<UserAnswer> parseAnswerList(Map<String, String[]> map, String userId, Integer paperOrder){
        List<UserAnswer> answerList = new ArrayList<>();
        for(Map.Entry<String, String[]> entity: map.entrySet()){
            if(StringUtils.contains(entity.getKey(), "ques")){
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setCId(CommonUtil.getUUID());
                userAnswer.setCIdUser(userId);
                userAnswer.setCIdOption(entity.getValue()[0]);
                userAnswer.setNOrderPaper(paperOrder);
                answerList.add(userAnswer);
            }
        }
        return answerList;
    }
}
