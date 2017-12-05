package cn.lxy.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component(value="countAllPage11")
public class CountAllPage11 {

	private List<Integer> pages = new ArrayList<Integer>();
	//根据总记录数得到总页数
	public int getAllPage(int items) {
		int temp = items;
		if(temp%11==0) {
			return temp/11;
		}else {
			return (temp/11)+1;
		}
	}
	//得到起始页码组
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
	//根据指定页码返回响应页码组
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
	//根据指定页码和总记录数得到终止索引
	public int getLastIndex(int page,int all) {
		int a = page*11;
		if(a<all) {
			return a;
		}else {
			return all;
		}
	}
	//根据总页数和指定页码数返回 页码左和页码右 的对应值
	public int[] getLeftAndRight(int start,int all) {
		int[] pages = new int[2]; 
		if(start==0) {
			if(all>5) {
				pages[0]=0;
				pages[1]=1;
			}else {
				pages[0]=0;
				pages[1]=0;				
			}
		}else {
			if(start-2-1>0) {
				pages[0]=1;
			}else {
				pages[0]=0;
			}
			if(start+2<all) {
				pages[1]=1;
			}else {
				pages[1]=0;
			}
		}
		return pages;
	}
	//根据总页数和指定页码得到左右箭头页码
	public int[] getDirectionNumber(int start,int all) {
		int[] dir = new int[2];
		
		int[] pages = new int[2];
		pages = getLeftAndRight(start,all);
		
		if(pages[0]==1) {
			dir[0]=start-1;
		}
		if(pages[1]==1) {
			dir[1]=start+1;
		}
		return dir;
	}
	
	
	
	
}
