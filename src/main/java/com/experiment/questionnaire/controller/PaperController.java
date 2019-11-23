package com.experiment.questionnaire.controller;

import com.experiment.questionnaire.service.PaperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author hjt
 * @date 2019/11/19 19:58
 */
//@RestController
@Controller
@ResponseBody
public class PaperController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaperService paperService;

    @RequestMapping("/paper")
    public String hello(HttpServletRequest request) {
        logger.info("nsukey:{}", request.getParameter("nsukey"));
        return paperService.getPaperById("759A41BB3F49407D83C04F90A844727E").toString();
    }
}
