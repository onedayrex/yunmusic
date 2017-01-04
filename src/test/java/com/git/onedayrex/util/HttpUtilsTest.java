package com.git.onedayrex.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.git.onedayrex.entity.Result;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by fuxiang.zhong on 2016/12/15 at 14:22.
 */
public class HttpUtilsTest {
	public static final String JSONOBJ = "com.alibaba.fastjson.JSONObject";
	@Test
	public void post() throws Exception {
		Logger log = Logger.getLogger(HttpUtilsTest.class);
		Map<String, String> map = new HashMap<String, String>();
		String s = HttpUtils.post("http://music.163.com/api/search/get/web?csrf_token=", "王菲", 10);
		JSONObject json = JSON.parseObject(s);
		Result result = JSON.toJavaObject(json, Result.class);
//		Set<Map.Entry<String, Object>> entries = json.entrySet();
//		for (Map.Entry<String, Object> entry : entries){
//			if (JSONOBJ.equals(entry.getValue().getClass().getName())) {
//				JSONObject temp = (JSONObject) entry.getValue();
//				Set<Map.Entry<String, Object>> entries1 = temp.entrySet();
//				for (Map.Entry<String, Object> stringObjectEntry : entries1) {
//					log.info(stringObjectEntry.getValue());
//				}
//			}
//		}
	}

	@Test
	public void get() throws Exception {
		HttpUtils.get("http://music.163.com");
	}

}