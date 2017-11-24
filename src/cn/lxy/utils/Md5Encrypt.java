package cn.lxy.utils;

import java.security.MessageDigest;
public class Md5Encrypt {
    StringBuffer buf = new StringBuffer("");
//    MessageDigest md = MessageDigest.getInstance("MD5");  
    MessageDigest md = null;  
    
   public  Md5Encrypt(String plainText) {
        try {
        //生成实现指定摘要算法的 MessageDigest 对象。
        md = MessageDigest.getInstance("MD5"); 
        //使用指定的字节数组更新摘要。
        md.update(plainText.getBytes());
        //通过执行诸如填充之类的最终操作完成哈希计算。
        byte b[] = md.digest();
        //生成具体的md5密码到buf数组
        int i;
        for (int offset = 0; offset < b.length; offset++) {
          i = b[offset];
          if (i < 0)
            i += 256;
          if (i < 16)
            buf.append("0");
          buf.append(Integer.toHexString(i));
        }
     } 
     catch (Exception e) {
       e.printStackTrace();
     }
   }
   public String to32MD5(){
	   return buf.toString();// 32位的加密
	   
   }
   public String to16MD5(){
	   return buf.toString().substring(8, 24);// 16位的加密，其实就是32位加密后的截取
	   
   } 
}
