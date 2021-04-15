/*
 * 
 */
package com.iot.g89;

import java.util.ArrayList;

public class Instructor extends User{
	  
	 public Instructor(String userid) {
		super(userid);
		
	}
	 
	 void setResume(String resume) {
		 this.resume = resume;
	 }
	 String getResume() {
		 return this.resume;
	 }

	 void uploadVideo() {
		 
	 }
	 void deleteVideo(Video video) {
		 
	 }
	 void playVideo(Video video) { 
		 
	 }
	 void editVideo(Video video) {
		 
		 
	 }

	 ArrayList<Client> listMySupremeMember(){
		return null;
		 
	 }
	 
	 ArrayList<Video> listMyVideo(){
		return null;
		 
	 }
	 
	 void checkMyMember(Client member) {
		 member.getUserPhysicalInfo().printUserPhisical();
	 }
}
