package com.experiment.questionnaire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.experiment.questionnaire.mapper.PaperMapper;
import com.experiment.questionnaire.mapper.UserAnswerMapper;
import com.experiment.questionnaire.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjt
 * @date 2019/11/20 22:22
 */
@Service
public class PaperService {

    @Autowired
    PaperMapper paperMapper;

    @Autowired
    UserAnswerMapper userAnswerMapper;

    public List<Paper> getTestByOrder(Integer order){
        return paperMapper.selectPaperListByTestOrder(order);
    }

    public String getPaperJsonStr(String userName){
        Integer testCount = userAnswerMapper.getTestCountByUserName(userName);
        List<Paper> paperList = getTestByOrder(testCount + 1);
        return paperToJsonStr(paperList);
    }

    private String paperToJsonStr(List<Paper> paperList){
        return JSON.toJSONString(paperList);
    }
}
