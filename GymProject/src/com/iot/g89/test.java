package com.iot.g89;

import java.util.ArrayList;

public class test {
	public test() {
		
	}
	public static void main(String[] args) {
		ArrayList<Video> allPublicVideo = new ArrayList<Video>();
		String filePath = "./video.csv";
		String[] idAndType = {"videoId","videoType"};
		ArrayList<String[]> videoInfo = new ArrayList<String[]>();
		videoInfo = FileUtils.readCSV(filePath, idAndType);

		int i = 0;
		System.out.println(videoInfo.size());
		while(i<videoInfo.size() && videoInfo.get(i)[1] == "public") {  //the second element is videoType = public
			Video video = new Video(videoInfo.get(i)[0]);
			allPublicVideo.add(video);	
			i++;
		}
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
