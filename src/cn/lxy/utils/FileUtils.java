package cn.lxy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;

@Component(value="fileUtils")
public class FileUtils {
	private ServerInfo serverInfo;
	public String GenerateImage(String imgStr,String path,String name){   
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
            return serverInfo.IMAGEADDRESS+name;  
        }   
        catch (Exception e)   
        {  
            return null;
        }  
    }
	
	public String saveFile(File file,String path,String name) throws Exception {
        OutputStream os = new FileOutputStream(new File(path,name));       
        InputStream is = new FileInputStream(file);     
        byte[] buf = new byte[1024];  
        int length = 0 ;    
        while(-1 != (length = is.read(buf))){
            os.write(buf, 0, length);
        }   
        is.close();  
        os.close(); 
        return serverInfo.FILEADDRESS+name;
	}
	
	
	
	
	
}
