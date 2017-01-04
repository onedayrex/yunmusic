package com.git.onedayrex.main;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fuxiang.zhong on 2016/12/29 at 11:22.
 */
public class Main {
	private static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		ExecutorService cached = Executors.newCachedThreadPool();
		cached.execute(new Runnable() {
			Long l = 0L;
			public void run() {
				log.info(l);
				l++;
			}
		});
	}

}
class Rl implements Runnable{
	private static final Logger log = Logger.getLogger(Rl.class);
	private String cmd;

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void run() {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process exec = runtime.exec(cmd);
			InputStream inputStream = exec.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
			String temp = null;
			StringBuffer sb = new StringBuffer();
			while ((temp=bf.readLine()) != null) {
				sb.append(temp);
			}
			log.info(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
