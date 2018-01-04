package cn.lxy.utils;

/**
 * <p>Title:ServerInfo</p>
 * <p>Description: 服务器信息</p>
 * @author 李银龙
 *		2017年11月19日
 *		上午10:37:30
 */
public class ServerInfo {
	public static final String SERVER_IP = "120.78.133.12";
	public static final String STUDENT_ICON_ADDRESS = "http://" + SERVER_IP + ":8080/CollegeLive/sourcefile/studenticon/";
	public static final String FILE_ADDRESS = "http://" + SERVER_IP + ":8080/CollegeLive/sourcefile/examfile/";
	public static final String IMAGE_ADDRESS = "http://" + SERVER_IP + ":8080/CollegeLive/sourcefile/examimage/";
	public static final String COURSE_IMAGE_ADDRESS = "http://"+SERVER_IP+":8080/CollegeLive/sourcefile/courseimage/";
	public static final String CAROUSEL_IMAGE_ADDRESS = "http://"+SERVER_IP+":8080/CollegeLive/Image/";
	public static final String BIZID = "11016";
	public static final String STREAM_BASIC = "rtmp://" + BIZID + ".livepush.myqcloud.com/live/" + BIZID + "_";
	public static final String STREAMID = "rtmp://" + BIZID + ".livepush.myqcloud.com/live/";
	public static final String KEY = "5cdf9b9606ceadebba73ae0c70014728";
}