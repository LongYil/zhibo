package cn.lxy.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * <p>Title:StreamUtils</p>
 * <p>Description: 获取推流码工具类</p>
 * @author 李银龙
 *		2017年11月24日
 *		下午9:48:51
 */
public class StreamUtils {
	
	public static String getStreamId(String roomid,String txTime) {
		txTime = addThreeday(txTime);
		String streamid = "";
		try {	
			 streamid = ServerInfo.STREAM_BASIC+roomid+"?"+"bizid="+ServerInfo.BIZID+"&"+(getSafeUrl(ServerInfo.KEY,ServerInfo.BIZID+"_"+roomid,getLongTime(txTime)));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return streamid;
	}
	
    private static final char[] DIGITS_LOWER =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /*
     * KEY+ stream_id + txTime
     */
    private static String getSafeUrl(String key, String streamId, long txTime) {
        String input = new StringBuilder().
                append(key).
                append(streamId).
                append(Long.toHexString(txTime).toUpperCase()).toString();

        String txSecret = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            txSecret  = byteArrayToHexString(
                    messageDigest.digest(input.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return txSecret == null ? "" :
            new StringBuilder().
                append("txSecret=").
                append(txSecret).
                append("&").
                append("txTime=").
                append(Long.toHexString(txTime).toUpperCase()).
                toString();
    }

    private static String byteArrayToHexString(byte[] data) {
        char[] out = new char[data.length << 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }
    
    private static String getTxTime(String arg) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = format.parse(arg).getTime()/1000;
        String t =  Long.toHexString(time);
        t = t.toUpperCase();
        return t;
    }
    
    private static long getLongTime(String arg) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = format.parse(arg).getTime()/1000;    	
		return time;
    }
    public static String addThreeday(String today){   
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        try   {   
            Date  d  =  new Date(f.parse(today).getTime()+3*24*3600*1000);     
              return  f.format(d);   
        }   
        catch(Exception ex) {   
            return   "输入格式错误";
        }   
    }
}
