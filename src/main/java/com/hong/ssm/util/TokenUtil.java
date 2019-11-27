package com.hong.ssm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hong.ssm.domain.ResponseOutDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenUtil {
	private static final Logger LOG = LoggerFactory.getLogger(TokenUtil.class);

	private static final String TOKEN_VERIFY_URL = "https://portal.chinacscs.com/portal/token/verify";
	
	private static final String COMPANY_VERIFY_URL = "https://portal.chinacscs.com/portal/company/info/search/byName";

	private static final String TOKEN_GET_URL = "https://portal.chinacscs.com/portal/token/temporary/user";
	
	private static final String COMPANY_SEARCH_URL = "https://portal.chinacscs.com/portal/company/info/search/company";
	
	private static final Map<String,String> HIGHLIGHT_MAP = new HashMap<String, String>();
	
	static {
		HIGHLIGHT_MAP.put("securityCd", "证券代码匹配");
		HIGHLIGHT_MAP.put("legalPersonName", "法定代表人匹配");
		HIGHLIGHT_MAP.put("chairman", "董事长匹配");
		HIGHLIGHT_MAP.put("gmanager", "总经理匹配");
		HIGHLIGHT_MAP.put("oldCompanyNm", "曾用名匹配");
		HIGHLIGHT_MAP.put("companyName", "企业名称匹配");
		HIGHLIGHT_MAP.put("securitySnm", "证券简称匹配");
	}
	
	public static Map<String, String> TOKEN_MAP = new HashMap<String, String>();

	public static String getToken(String userName) {
		String token = null;
		if (TOKEN_MAP.containsKey(userName) && verifyToken(TOKEN_MAP.get(userName))) {
			return TOKEN_MAP.get(userName);
		}

		HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("userName", userName);
		maps.put("expireTime", "3600000");
		// String res = httpClientUtil.sendHttpPost(TOKEN_GET_URL, maps);
		String bodyString = JSONObject.toJSONString(maps);
		String res = httpClientUtil.sendHttpPost(TOKEN_GET_URL, bodyString);
		
		ResponseOutDto response = JSONObject.parseObject(res, ResponseOutDto.class);
		LOG.info("userName:[],获取token响应信息：[]",userName,response);
		
		token = response.getData();
		TOKEN_MAP.put(userName, token);
		return token;
	}

	private static boolean verifyToken(String token) {
		HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("token", token);
		String bodyString = JSONObject.toJSONString(maps);
		String res = httpClientUtil.sendHttpPost(TOKEN_VERIFY_URL, bodyString);
		if (StringUtils.isEmpty(res)) {
			return false;
		}

		ResponseOutDto response = JSONObject.parseObject(res, ResponseOutDto.class);
		if ("0".equals(response.getCode())) {
			return true;
		}

		return false;
	}
	
	public static String verifyCompany(String token,String name) {
		HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("name", name);
		String bodyString = JSONObject.toJSONString(maps);
		String res = httpClientUtil.sendHttpPost(COMPANY_VERIFY_URL, bodyString,token);
		if (StringUtils.isEmpty(res)) {
			return "";
		}

		ResponseOutDto response = JSONObject.parseObject(res, ResponseOutDto.class);
		if (0 == response.getCount()) {
			return "";
		}
		
		String dataString = response.getData();
		JSONArray list = JSONObject.parseArray(dataString);
		JSONObject company = (JSONObject)list.get(0);
		Object searchOut = company.get("searchOut");
		JSONObject com = JSON.parseObject(searchOut.toString());
		String companyId = com.get("companyId").toString();
		
		return companyId;
	}
	
	 
	public static List<Map<String,Object>> getCompanyList(String token, String keyword){
		 List<Map<String,Object>> list = new ArrayList();
		 HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
		 Map<String, Object> maps = new HashMap<String, Object>();
		 maps.put("keyword", keyword);
		 String bodyString = JSONObject.toJSONString(maps);
		 String res = httpClientUtil.sendHttpPost(COMPANY_SEARCH_URL, bodyString, token); 	
		 LOG.info("getCompanyList:[{}]",res );
		 
		 if (StringUtils.isEmpty(res)) {
				return list;
			}
		 
		 ResponseOutDto response = JSONObject.parseObject(res, ResponseOutDto.class);
		 if (!"0".equals(response.getCode())) {
				return list;
			}
		 
		 String dataString = response.getData();
		 if (StringUtils.isEmpty(dataString)) {
			return list;
		 }
		 
		 JSONObject obj = JSONObject.parseObject(dataString);
		 JSONArray array = JSONObject.parseArray(JSON.toJSONString(obj.get("result")));
		 Map<String,Object> map = null;
		 for (int i = 0; i < array.size(); i++) {
			map = new HashMap<String, Object>();
			JSONObject company = array.getJSONObject(i);
			map.put("companyId", company.getString("companyId"));
			String highlightColumn = null;
			String comName = company.getString("companyName");
			if (!comName.contains("<span class=\"highlight\">")) {
				comName =  company.getString("oldCompanyNm").split(",")[0];
				highlightColumn = "oldCompanyNm";
			}
			comName = comName.replace("<span class=\"highlight\">","").replace("</span>", "");
			map.put("companyName", comName);
			if (highlightColumn == null) {
				String s = JSON.toJSONString(company.get("highlightColumns"));
				JSONArray highlightColumns = JSONObject.parseArray(s);
				highlightColumn = highlightColumns.getString(0);
			}
			map.put("highlightColumns", HIGHLIGHT_MAP.get(highlightColumn));
			list.add(map);
		}
		 
		return list;
	}
	
	public static String getMasterToken() {
		HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("userName", "csci_hong");
		maps.put("client_id", "clientapp");
		maps.put("grant_type", "password");
		maps.put("password", "ac29a7db80c84eb3bc4ed4aadb7b982d6b816565918096083bed4bea4f55c7ec");
		// String res = httpClientUtil.sendHttpPost(TOKEN_GET_URL, maps);
		String bodyString = JSONObject.toJSONString(maps);
		String res = httpClientUtil.sendHttpPost(TOKEN_GET_URL, bodyString);
		if (StringUtils.isEmpty(res)) {
			LOG.info("获取Master-token响应信息失败");
			return null;
		}
		
		JSONObject obj = JSON.parseObject(res);
		String token = obj.getString("access_token");
		LOG.info("获取Master-token响应信息：[]",obj);
		return token;
	}

    public static void main(String[] args) {
        String URL = "https://portal.chinacscs.com/SYService/login";
		//String URL = "https://10.100.40.10:8080/SYService/login";
        HttpClientUtil httpClientUtil = HttpClientUtil.getInstance();
        Map<String, String> maps = new HashMap<>();
        maps.put("username", "XWJY_TEST");
        maps.put("password", "3D0A5CB9");
        String bodyString = JSONObject.toJSONString(maps);
        String res = httpClientUtil.sendHttpPost(URL, bodyString);
        System.out.println(res);

        //ResponseOutDto response = JSONObject.parseObject(res, ResponseOutDto.class);


    }
}
