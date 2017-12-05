package cn.lxy.test;

import cn.lxy.utils.CountAllPage11;

public class MyTest4 {

	public static void main(String[] args) {// 1 2 3 4 5 6 7
		int[] temp = new int[2];
		CountAllPage11 c = new CountAllPage11();
		temp = c.getDirectionNumber(4, 7);
		System.out.println(temp[0]+"*"+temp[1]);		
		
		
	}

}
