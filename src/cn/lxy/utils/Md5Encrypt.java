package cn.lxy.utils;

import java.security.MessageDigest;
public class Md5Encrypt {
    StringBuffer buf = new StringBuffer("");
//    MessageDigest md = MessageDigest.getInstance("MD5");  
    MessageDigest md = null;  
    
   public  Md5Encrypt(String plainText) {
        try {
        //����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
        md = MessageDigest.getInstance("MD5"); 
        //ʹ��ָ�����ֽ��������ժҪ��
        md.update(plainText.getBytes());
        //ͨ��ִ���������֮������ղ�����ɹ�ϣ���㡣
        byte b[] = md.digest();
        //���ɾ����md5���뵽buf����
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
	   return buf.toString();// 32λ�ļ���
	   
   }
   public String to16MD5(){
	   return buf.toString().substring(8, 24);// 16λ�ļ��ܣ���ʵ����32λ���ܺ�Ľ�ȡ
	   
   } 
}
