package com.experiment.questionnaire.pojo;

import java.util.List;

/**
 * @author hjt
 * @date 2019/11/25 14:12
 */
public class Question {

    private String CId;

    private String CIdPaper;

    private String CDescription;

    private String CType;

    private Integer NOrder;

    private List<Option> optionList;

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCIdPaper() {
        return CIdPaper;
    }

    public void setCIdPaper(String CIdPaper) {
        this.CIdPaper = CIdPaper;
    }

    public String getCDescription() {
        return CDescription;
    }

    public void setCDescription(String CDescription) {
        this.CDescription = CDescription;
    }

    public String getCType() {
        return CType;
    }

    public void setCType(String CType) {
        this.CType = CType;
    }

    public Integer getNOrder() {
        return NOrder;
    }

    public void setNOrder(Integer NOrder) {
        this.NOrder = NOrder;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
