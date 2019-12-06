package com.experiment.questionnaire.mapper;

import com.experiment.questionnaire.pojo.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hjt
 * @date 2019/11/20 23:11
 */
@Repository
public interface PaperMapper {

    List<Paper> selectPaperListByTestOrder(Integer order);
}
