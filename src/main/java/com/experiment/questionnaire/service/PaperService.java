package com.experiment.questionnaire.service;

import com.experiment.questionnaire.mapper.PaperMapper;
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

    public Paper getPaperById(String id){
        return paperMapper.selectByCId(id);
    }
}
