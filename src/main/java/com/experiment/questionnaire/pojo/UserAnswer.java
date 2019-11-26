package com.experiment.questionnaire.pojo;

/**
 * @author hjt
 * @date 2019/11/25 15:54
 */
public class UserAnswer {

    private String CId;

    private String CIdOption;

    private String CIdUser;

    private Integer NOrderPaper;

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
}
