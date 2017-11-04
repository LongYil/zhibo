package cn.lxy.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component(value="countAllPage")
public class CountAllPage {
	
	private List<Integer> pages = new ArrayList<Integer>();
	
	public int getAllPage(int items) {
		int temp = items;
		if(temp%11==0) {
			return temp/11;
		}else {
			return (temp/11)+1;
		}
	}
	
	public List<Integer> getStartPages(int all) {
		pages.clear();
		int j=0;
		if(all>5) {
			for(int i=1;i<6;i++) {
				pages.add(i);
			}
		}else {
			for(int i=1;i<all+1;i++) {
				pages.add(i);
			}
		}
		return pages;
	}	
	
	public List<Integer> getPages(int start,int all) {
		pages.clear();
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
