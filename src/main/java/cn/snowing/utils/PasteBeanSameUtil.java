package cn.snowing.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PasteBeanSameUtil {
    public static Object pasteBeanSame(Object sourceBean, Object targetBean){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String sourceBeanJson = objectMapper.writeValueAsString(sourceBean);
            return objectMapper.readValue(sourceBeanJson, targetBean.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return targetBean;
    }
}
