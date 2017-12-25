package cn.lxy.test;

import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyTest6 {

	public static void main(String[] args) {
//		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
//		StringBuffer temp = new StringBuffer();
//		for(int i = 0;i < 4 ;i++) {
//			temp.append(chars.charAt((int)(Math.random() * 62)));
//		}
//		System.out.println(temp.toString());
//		String[] info = "a,b,c,d".split(".");
//		System.out.println(info.toString());
		String sTotalString = "["+"{\"appid\":1254290539,\"channel_id\":\"11016_157f7a813b\",\"duration\":255,\"end_time\":1513867432,\"event_type\":100,\"file_format\":\"flv\",\"file_id\":\"4564972818715035210\",\"file_size\":32403376,\"media_start_time\":67,\"record_file_id\":\"4564972818715035210\",\"sign\":\"5afb6540a8740b47a1ffdbba780c6c03\",\"start_time\":1513867179,\"stream_id\":\"11016_157f7a813b\",\"stream_param\":\"bizid=11016&txSecret=47afe50b10c8f33c8225d9e8e053198e&txTime=5A3BDA7F\",\"t\":1513868039,\"task_id\":\"15380682540481908757\",\"video_id\":\"210014154_484c2eaa917d498e89c723893046af34\",\"video_url\":\"http://1254290539.vod2.myqcloud.com/76ae8fc7vodgzp1254290539/36a8a0e34564972818715035210/f0.flv\"}"+"]";
		
       	// 把字符串转换为JSONArray对象
       	JSONArray jsonArray = JSONArray.fromObject(sTotalString);
       	JSONObject jsonObject = jsonArray.getJSONObject(0);
       	System.out.println(jsonObject.get("appid"));
       	System.out.println(jsonObject.get("channel_id"));
       	System.out.println(jsonObject.get("video_url"));
		
		
	}

}
