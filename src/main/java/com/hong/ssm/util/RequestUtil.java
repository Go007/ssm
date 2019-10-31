package com.hong.ssm.util;

import com.hong.ssm.config.Restful;
import java.util.Map;

/**
 * @author wanghong
 * @date 2019/10/31 13:26
 **/
public class RequestUtil {

    public static Map<String, Object> doGet(String url, Map<String, Object> map) {
        Restful restful = new Restful();
        Map<String, Object>  result = null;
        try {
            String urls = jointParamsToUrl(map, url);
            result = restful.getForObject(urls,Map.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String jointParamsToUrl(Map<String, Object> params, String url) {
        if (params == null) {
            return url;
        }

        StringBuilder strBuilder = new StringBuilder("?");
        params.forEach((key, value) -> strBuilder.append(key).append("=").append(value).append("&"));
        strBuilder.deleteCharAt(strBuilder.length() - 1);

        return url + strBuilder.toString();
    }
}
