package cn.lxy.utils;

public class MyTest4 {

	public static void main(String[] args) {// 1 2 3 4 5 6 7
		int[] temp = new int[2];
		CountAllPage c = new CountAllPage();
		temp = c.getDirectionNumber(4, 7);
		System.out.println(temp[0]+"*"+temp[1]);		
		
		
	}

}
