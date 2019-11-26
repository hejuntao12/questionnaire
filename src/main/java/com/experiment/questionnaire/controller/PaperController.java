package com.experiment.questionnaire.controller;

import com.experiment.questionnaire.service.AnswerService;
import com.experiment.questionnaire.service.PaperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
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

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/paper")
    public String getPaper(HttpServletRequest request) {
        logger.info("nsukey:{}", request.getParameter("nsukey"));
        return paperService.getPaperJsonStr(request.getParameter("username"));
    }

    @RequestMapping(value="/submit", method=RequestMethod.POST)
    public void submitUserAnswer(HttpServletRequest request, HttpServletResponse response) {
        logger.info("nsukey:{}", request.getParameter("nsukey"));
        Map<String, String[]> paramMap = request.getParameterMap();
        answerService.saveUserAnswer(paramMap);
        try{
            String userName = URLEncoder.encode(paramMap.get("username")[0],"utf-8");
            response.sendRedirect(String.format("/chart.html?username=%s", userName));
        } catch (Exception e){
            logger.error("重定向失败", e);
        }
    }

    @RequestMapping("/score")
    public String getHistoryData(HttpServletRequest request) {
        logger.info("nsukey:{}", request.getParameter("nsukey"));
        return answerService.getHistoryScore(request.getParameter("username"));
    }
}
