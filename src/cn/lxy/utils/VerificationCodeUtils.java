package cn.lxy.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * <p>Title:VerificationCodeUtils</p>
 * <p>Description: ��֤�빤����</p>
 * @author ������
 *		2017��12��10��
 *		����4:52:45
 */
@Component(value="verificationCodeUtils")
public class VerificationCodeUtils {
	public String getCode() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		StringBuffer temp = new StringBuffer();
		for(int i = 0;i < 4 ;i++) {
			temp.append(chars.charAt((int)(Math.random() * 61))+",");
		}
		return temp.toString();
	}
	
}
