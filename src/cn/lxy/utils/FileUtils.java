package cn.lxy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;

@Component(value="fileUtils")
public class FileUtils {
	private ServerInfo serverInfo;
	public String GenerateImage(String imgStr,String path,String name){
		String[] tempnames = name.split("\\.");
		name = tempnames[0]+"_"+(new SimpleDateFormat("YYYYMMddHHmmss").format(new Date()))+"."+tempnames[1];
		//对字节数组字符串进行Base64解码并生成图片
		String pathAndName = path+"/"+name;
        if (imgStr == null) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片  
            OutputStream out = new FileOutputStream(pathAndName);      
            out.write(b);
            out.flush();
            out.close();  
            return serverInfo.IMAGE_ADDRESS+name;
        }   
        catch (Exception e)   
        {  
            return null;
        }  
    }
	
	public String saveFile(File file,String path,String name) throws Exception {
		String[] tempnames = name.split("\\.");
		name = tempnames[0]+"_"+(new SimpleDateFormat("YYYYMMddHHmmss").format(new Date()))+"."+tempnames[1];
		OutputStream os = new FileOutputStream(new File(path,name));       
        InputStream is = new FileInputStream(file);     
        byte[] buf = new byte[1024];  
        int length = 0 ;    
        while(-1 != (length = is.read(buf))){
            os.write(buf, 0, length);
        }   
        is.close();
        os.close();
        return serverInfo.FILE_ADDRESS+name;
	}
	public String saveImg(File file,String path,String name) throws Exception {
		String[] tempnames = name.split("\\.");
		name = tempnames[0]+"_"+(new SimpleDateFormat("YYYYMMddHHmmss").format(new Date()))+"."+tempnames[1];
		OutputStream os = new FileOutputStream(new File(path,name));       
		InputStream is = new FileInputStream(file);     
		byte[] buf = new byte[1024];
		int length = 0 ;    
		while(-1 != (length = is.read(buf))){
			os.write(buf, 0, length);
		}   
		is.close();
		os.close();
		return serverInfo.CAROUSEL_IMAGE_ADDRESS + name;
	}
	public String saveIcon(File file,String path,String name) throws Exception {
		String[] tempnames = name.split("\\.");
		name = tempnames[0]+"_"+(new SimpleDateFormat("YYYYMMddHHmmss").format(new Date()))+"."+tempnames[1];
		OutputStream os = new FileOutputStream(new File(path,name));       
		InputStream is = new FileInputStream(file);     
		byte[] buf = new byte[1024];  
		int length = 0 ;    
		while(-1 != (length = is.read(buf))){
			os.write(buf, 0, length);
		}   
		is.close();
		os.close();
		return serverInfo.STUDENT_ICON_ADDRESS+name;
	}
	
	public String generateCourseImage(String imgStr,String path,String name){
		String[] tempnames = name.split("\\.");
		name = tempnames[0]+"_"+(new SimpleDateFormat("YYYYMMddHHmmss").format(new Date()))+"."+tempnames[1];
		//对字节数组字符串进行Base64解码并生成图片
		String pathAndName = path+"/"+name;
        if (imgStr == null) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();  
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }
            }
            //生成jpeg图片  
            OutputStream out = new FileOutputStream(pathAndName);      
            out.write(b);
            out.flush();  
            out.close();  
            return serverInfo.COURSE_IMAGE_ADDRESS+name;  
        }   
        catch (Exception e)   
        {  
            return null;
        }  
    }	
	
	
	
}
