package com.experiment.questionnaire.controller;

import com.experiment.questionnaire.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjt
 * @date 2019/11/19 19:58
 */
@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @RequestMapping("/paper")
    public String hello() {
        return paperService.getPaperById("759A41BB3F49407D83C04F90A844727E").toString();
    }
}
