package cn.lxy.utils;

/**
 * <p>Title:ServerInfo</p>
 * <p>Description: ��������Ϣ</p>
 * @author ������
 *		2017��11��19��
 *		����10:37:30
 */
public class ServerInfo {
	public static final String SERVER_IP = "120.78.208.115";
//	public static final String SERVER_IP = "localhost:8080";
//	public static final String SERVER_IP = "182.61.20.165:8080";
	public static final String STUDENT_ICON_ADDRESS = "http://" + SERVER_IP + "/sourcefile/studenticon/";
	public static final String FILE_ADDRESS = "http://" + SERVER_IP + "/sourcefile/examfile/";
	public static final String IMAGE_ADDRESS = "http://" + SERVER_IP + "/sourcefile/examimage/";
	public static final String COURSE_IMAGE_ADDRESS = "http://"+SERVER_IP+"/sourcefile/courseimage/";
	public static final String CAROUSEL_IMAGE_ADDRESS = "http://"+SERVER_IP+"/sourcefile/Image/";
	public static final String SOURCEFILE_REALPATH = "/apache/tomcat8/webapps/CollegeLiveSourcefile/sourcefile/";
//	public static final String STUDENT_ICON_ADDRESS = "http://" + SERVER_IP + "/CollegeLive/sourcefile/studenticon/";
//	public static final String FILE_ADDRESS = "http://" + SERVER_IP + "/CollegeLive/sourcefile/examfile/";
//	public static final String IMAGE_ADDRESS = "http://" + SERVER_IP + "/CollegeLive/sourcefile/examimage/";
//	public static final String COURSE_IMAGE_ADDRESS = "http://"+SERVER_IP+"/CollegeLive/sourcefile/courseimage/";
//	public static final String CAROUSEL_IMAGE_ADDRESS = "http://"+SERVER_IP+"/CollegeLive/sourcefile/Image/";
	public static final String BIZID = "11016";
	public static final String STREAM_BASIC = "rtmp://" + BIZID + ".livepush.myqcloud.com/live/" + BIZID + "_";
	public static final String STREAM_SHORT = "rtmp://" + BIZID + ".livepush.myqcloud.com/live/";
	public static final String STREAMID = "rtmp://" + BIZID + ".livepush.myqcloud.com/live/";
	public static final String KEY = "5cdf9b9606ceadebba73ae0c70014728";
}