package com.hong.ssm.domain;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghong
 * Date 2019-11-26 18:05
 * Description:
 */
public class ResponseOutDto {
    private int count;
    private String data;
    private String code;
    private String message;

    private List<Map<String,Object>> resList;
    private Map<String,Object> map;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, Object>> getResList() {
        return resList;
    }

    public void setResList(List<Map<String, Object>> resList) {
        this.resList = resList;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
