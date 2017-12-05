package cn.lxy.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import cn.lxy.utils.Md5Encrypt;

public class MyTest1 {

    public static void main(String[] args) {
        System.out.println("11925_bbbbbb?"+"bizid=11925&"+getSafeUrl("2e501ec27812117a0dcb00e801745961", "11925_bbbbbb",1511539199L));
        
        
        
    }

    private static final char[] DIGITS_LOWER =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//11925_678ca76b63?bizid=11925&txSecret=da8eecc56c113a90d52fd69bc99e8ce7&txTime=59F9EF7F
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
    
    public static String outputTxSecret(String arg) {
    	return new Md5Encrypt(arg).to32MD5();
    }
}
