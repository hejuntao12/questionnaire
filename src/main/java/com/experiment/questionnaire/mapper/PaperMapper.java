package com.experiment.questionnaire.mapper;

import com.experiment.questionnaire.pojo.Paper;
import org.springframework.stereotype.Repository;

/**
 * @author hjt
 * @date 2019/11/20 23:11
 */
@Repository
public interface PaperMapper {

    Paper selectPaperByNOrder(Integer order);
}
