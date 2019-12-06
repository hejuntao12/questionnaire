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

import java.util.*;

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
        Map<String, Object> scoreMap = new HashMap<>();
        scoreMap.put("anxious", userAnswerMapper.selectEveryScoreByUserName(userName, 1));
        scoreMap.put("depressed", userAnswerMapper.selectEveryScoreByUserName(userName, 2));
//        List<Map<String, Object>> scoreList = userAnswerMapper.selectEveryScoreByUserName(userName, 1);
//        List<Map<String, Object>> scoreList = userAnswerMapper.selectEveryScoreByUserName(userName, 2);
        return JSON.toJSONString(scoreMap);
    }

    public void saveUserAnswer(Map<String, String[]> map){
        try{
            User user = userService.getOrCreateUserByName(map.get("username")[0]);
            String userId = user.getCId();
            Integer testCount = userAnswerMapper.getTestCountByUserName(user.getCName());
            userAnswerMapper.deleteByUserIdAndTestOrder(userId, testCount + 1);
            List<UserAnswer> answerList = parseAnswerList(map, userId, testCount + 1);
            userAnswerMapper.insertByBatch(answerList);
        } catch (Exception e) {
            logger.error("解析表单提交失败", e);
        }
    }

    private List<UserAnswer> parseAnswerList(Map<String, String[]> map, String userId, Integer testOrder){
        List<UserAnswer> answerList = new ArrayList<>();
        Date now = new Date();
        for(Map.Entry<String, String[]> entity: map.entrySet()){
            if(StringUtils.contains(entity.getKey(), "ques")){
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setCId(CommonUtil.getUUID());
                userAnswer.setCIdUser(userId);
                userAnswer.setCIdOption(entity.getValue()[0]);
                userAnswer.setNOrderTest(testOrder);
                userAnswer.setNOrderPaper(getPaperOrderByQuesName(entity.getKey()));
                userAnswer.setDTjsj(now);
                answerList.add(userAnswer);
            }
        }
        return answerList;
    }

    private Integer getPaperOrderByQuesName(String quesName){
        String paper = quesName.split("-")[0];
        String order = paper.replace("paper", "");
        return Integer.valueOf(order);
    }
}
