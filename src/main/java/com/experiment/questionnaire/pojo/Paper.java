package com.experiment.questionnaire.pojo;

import java.util.List;

/**
 * @author hjt
 * @date 2019/11/20 22:06
 */
public class Paper {

    private String CId;

    private String CName;

    private Integer NOrder;

    private List<Question> questionList;

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public Integer getNOrder() {
        return NOrder;
    }

    public void setNOrder(Integer NOrder) {
        this.NOrder = NOrder;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString(){
        return "Paper{" +
                "CId=" + CId +
                ", CName='" + CName + '\'' +
                ", NOrder='" + NOrder + '\'' +
                '}';
    }
}
