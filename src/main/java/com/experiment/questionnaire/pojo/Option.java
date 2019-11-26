package com.experiment.questionnaire.pojo;

/**
 * @author hjt
 * @date 2019/11/25 14:14
 */
public class Option {

    private String CId;

    private String CIdQues;

    private String CDescription;

    private Integer NScore;

    private Integer NOrder;

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCIdQues() {
        return CIdQues;
    }

    public void setCIdQues(String CIdQues) {
        this.CIdQues = CIdQues;
    }

    public String getCDescription() {
        return CDescription;
    }

    public void setCDescription(String CDescription) {
        this.CDescription = CDescription;
    }

    public Integer getNScore() {
        return NScore;
    }

    public void setNScore(Integer NScore) {
        this.NScore = NScore;
    }

    public Integer getNOrder() {
        return NOrder;
    }

    public void setNOrder(Integer NOrder) {
        this.NOrder = NOrder;
    }
}
