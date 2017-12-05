package cn.lxy.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class MyTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test1() throws ParseException {
//        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
//        Date d1 = new Date();
//        String now = f.format(d1);

//      Date d2 = new Date(f.parse(now));
//      System.out.println(now);
//      Date  d  =  new Date(f.parse("").getTime()+3*24*3600*1000);
//      f.format(d);
//      String temp = f.format(d);
        
        Date d3 = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d3);
	    int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println(w);
		
		
	}
	
	@Test
	public void test2() {
	    File[] roots = File.listRoots();
	    for (int i = 0; i < roots.length; i++) {
	      System.out.println(roots[i]);
	      System.out.println("Free space = " + roots[i].getFreeSpace());
	      System.out.println("Usable space = " + roots[i].getUsableSpace());
	      System.out.println("Total space = " + roots[i].getTotalSpace());
	    }
	}
	
	@Test
	public void test3() throws ParseException {
        List<String> temp = new ArrayList<String>();
		Date d1 = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d1);
	    int w = -(cal.get(Calendar.DAY_OF_WEEK)-1);//w代表的是一周第几天 周日为0
		
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        SimpleDateFormat f1 =  new SimpleDateFormat("MM月dd号");   
        
        Date d2 = new Date();
        String now = f.format(d2);
		for(int j=0;j<7;j++) {
	        Date d3 = new Date(f.parse(now).getTime()+w*24*3600*1000);
	        String late = f1.format(d3);
	        w++;
	        System.out.println(late);
	        temp.add(late);
		}
        
	}
}
