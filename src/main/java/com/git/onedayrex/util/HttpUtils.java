package com.git.onedayrex.util;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * Created by fuxiang.zhong on 2016/12/14 at 16:07.
 */
public class HttpUtils {
	private static final Logger log = Logger.getLogger(HttpUtils.class);


	public static String get(String urlStr){
		try {
			URI uri = new URI(urlStr);
			HttpGet httpGet = new HttpGet();
			httpGet.setURI(uri);
//Cookie: appver=1.5.0.75771;
//Referer: http://music.163.com/
			Cookie cookie = new BasicClientCookie("appver", "1.5.0.75771");
			Map<String, String> headMap = new HashMap<String, String>();
			httpGet.addHeader(new BasicHeader("Cookie","appver=1.5.0.75771"));
			httpGet.addHeader(new BasicHeader("Referer","http://music.163.com/"));
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(httpGet);
			InputStreamReader isr = new InputStreamReader(response.getEntity().getContent());
			char[] b = new char[2048];
			StringBuilder sb = new StringBuilder();
			while (isr.read(b) != -1) {
				sb.append(b);
			}
			Header[] allHeaders = response.getAllHeaders();
			for (Header allHeader : allHeaders) {
				log.info(allHeader.getName()+":"+allHeader.getValue());
			}
			log.info("Status==>"+response.getStatusLine().getStatusCode());
			log.info("请求返回==>"+sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String post(String url,String query,int limit){
		StringBuilder sb = new StringBuilder();
		try {
			URI uri = new URI(url);
			HttpPost httpPost = new HttpPost(uri);
			Map<String, String> headMap = new HashMap<String, String>();
			headMap.put("Host","music.163.com");
			headMap.put("Origin","http://music.163.com");
			headMap.put("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
			headMap.put("Content-Type","application/x-www-form-urlencoded");
			headMap.put("Referer","http://music.163.com/search/");
			Set<Map.Entry<String, String>> entries = headMap.entrySet();
			String param = "hlpretag=<span class=\"s-fc7\">&hlposttag=</span>&s="+query+"&type=1&offset=0&total=true&limit="+limit;
			httpPost.setEntity(new StringEntity(param,"utf-8"));
			for (Map.Entry<String, String> entry : entries) {
				httpPost.setHeader(entry.getKey(),entry.getValue());
			}
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(httpPost);
			InputStream content = response.getEntity().getContent();
			BufferedReader bf = new BufferedReader(new InputStreamReader(content));
			String temp = null;
			while ((temp=bf.readLine())!=null) {
				sb.append(temp);
			}
			log.info("Status==>"+response.getStatusLine().getStatusCode());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static Header[] getHeaders(){
		InputStream inputstream = HttpUtils.class.getClassLoader().getResourceAsStream("info");
		InputStreamReader isr = new InputStreamReader(inputstream);
		BufferedReader br = new BufferedReader(isr);
		String temp = null;
		List<Header> tempList = new ArrayList<Header>();
		try {
			while ((temp = br.readLine()) != null) {
				String[] split = temp.split(":");
				Header header = new BasicHeader(split[0],split[1]);
				log.info("请求头数据加入"+split[0]+":"+split[1]);
				tempList.add(header);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 	tempList.toArray(new Header[0]);
	}
}
