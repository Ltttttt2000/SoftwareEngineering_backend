package com.iot.g89;

import java.util.ArrayList;

public class test {
	
	public static void main(String[] args) {
		
		String[] headers = {"ID", "Sex", "condition","weight"};
		
		ArrayList<String[]> arrayList = new ArrayList<String[]>();
		String[] s1 = {"0001", "Male", "Good", "34"};
		String[] s2 = {"0002", "FeMale", "Meduim", };
		String[] s3 = {"0003", "Male", "Bad", "35", "rabbit"};
		
 		arrayList.add(s1);
 		arrayList.add(s2);
 		arrayList.add(s3);
 		
 		test t = new test();
 		
		System.out.println(t.getClass().getSimpleName());
		FileUtils.createCSV("./1002.csv",headers);
		FileUtils.insertCSV("./1002.csv", arrayList);
		FileUtils.insertCSV("./1002.csv", arrayList);
	}
}
