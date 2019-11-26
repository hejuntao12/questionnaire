package com.experiment.questionnaire.utils;

import java.util.UUID;

/**
 * @author hjt
 * @date 2019/11/25 20:20
 */
public class CommonUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
