package com.experiment.questionnaire.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.experiment.questionnaire.mapper.PaperMapper;
import com.experiment.questionnaire.mapper.UserAnswerMapper;
import com.experiment.questionnaire.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Paper getPaperByOrder(Integer order){
        return paperMapper.selectPaperByNOrder(order);
    }

    public String getPaperJsonStr(String userName){
        Integer paperCount = userAnswerMapper.getPaperCountByUserName(userName);
        Paper paper = getPaperByOrder(paperCount + 1);
        return paperToJsonStr(paper);
    }

    private String paperToJsonStr(Paper paper){
        return JSON.toJSONString(paper);
    }
}
