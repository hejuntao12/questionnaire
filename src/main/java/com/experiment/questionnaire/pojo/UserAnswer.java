package com.experiment.questionnaire.pojo;

import java.util.Date;

/**
 * @author hjt
 * @date 2019/11/25 15:54
 */
public class UserAnswer {

    private String CId;

    private String CIdOption;

    private String CIdUser;

    private Integer NOrderPaper;

    private Integer NOrderTest;

    private Date DTjsj;

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCIdOption() {
        return CIdOption;
    }

    public void setCIdOption(String CIdOption) {
        this.CIdOption = CIdOption;
    }

    public String getCIdUser() {
        return CIdUser;
    }

    public void setCIdUser(String CIdUser) {
        this.CIdUser = CIdUser;
    }

    public Integer getNOrderPaper() {
        return NOrderPaper;
    }

    public void setNOrderPaper(Integer NOrderPaper) {
        this.NOrderPaper = NOrderPaper;
    }

    public Integer getNOrderTest() {
        return NOrderTest;
    }

    public void setNOrderTest(Integer NOrderTest) {
        this.NOrderTest = NOrderTest;
    }

    public Date getDTjsj() {
        return DTjsj;
    }

    public void setDTjsj(Date DTjsj) {
        this.DTjsj = DTjsj;
    }
}
