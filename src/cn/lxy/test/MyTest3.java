package cn.lxy.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyTest3 {
	
	private static List<Integer> pages = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		List<Integer> pagesi = getPages(8,10);
		for(int i=0;i<pagesi.size();i++) {
			System.out.println(pagesi.get(i));
		}
		

	}
	
	public static List<Integer> getPages(int start,int all) {
		int j=0;
		for(int i=start;i>0&&j<3;i--,j++) {
			pages.add(i);
		}
		for(int i=start+1;i<all+1&&j<5;i++,j++) {
			pages.add(i);
		}
		Collections.sort(pages);
		return pages;
	}
	
}
