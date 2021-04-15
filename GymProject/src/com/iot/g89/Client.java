package com.iot.g89;

import java.util.ArrayList;

public class Client extends User{
              // Normal, Member, SupremeMember
	public Client(String userid) {
		super(userid);
	}
	
	//getter, setter 
	public void setRechargeAmount(int rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
		this.userInfo[6] = String.valueOf(rechargeAmount);//�޸�csv�ĺ���
	}
	public int getRechargeAmount() {
		return this.rechargeAmount;
	}
	
	/**
	 * Recharge money into user's account. Decide whether the user can have a upgrade based on the amount of money recharged.
	 * 
	 * @param money
	 * 			The money the user recharge
	 */
	public void recharge(int money) {	
		if(money < 0) {
			System.out.println("error");
		}else {
			setRechargeAmount(this.rechargeAmount + money);    //change csv file in setter function
			if(this.userType == "Normal") {                    // panduan ma hai???
				if(money > 500)
					this.accountUpgradeToMember();
			}
			if(this.userType == "Member") {
				if(money > 1000)
					this.accountUpgradeToSupreme();
			}
			//change rechargeAmount in csv???
		}
	}
	/**
	 * Consume money from user's account.
	 * 
	 * @param money
	 * 			The money the user need to pay
	 */
	public void consume(int money) {
		
		int balance = this.rechargeAmount - money;
		if(balance < 0) {
			System.out.println("Sorry, your credit is running low, please recharge.");
			
		}else {
			setRechargeAmount(this.rechargeAmount - money);
			// change in csv
			System.out.println("buy successfully");
		}
		
	}
	
	/**
	 * This method is only for normal client to upgrade to member client.
	 */	
	public void accountUpgradeToMember() {
		if(this.userType == "Normal") {
			this.userType = "Member";
			//�޸�csv
			FileUtils.delete("./user/"+ this.userid +".csv");
			userInfoList.add(userInfo);
			FileUtils.createCSV("./user/"+ this.userid+".csv", fileHeaders);
			FileUtils.insertCSV("./user/"+ this.userid+".csv", userInfoList);
		}else {
			System.out.println("Wrong clientType");
		}
	}
	/**
	 * This method is only for member client to upgrade to supreme client.
	 */
	public void accountUpgradeToSupreme() {
		if(this.userType == "Member") {
			setUserType("SupreMember");
			
		}
		
	}
	
	
	//related to video class
	/**
	 * This method is for every user to list all public videos.
	 * 
	 * @return ArrayList<Video>
	 * 			all the Videos
	 */
	public ArrayList<Video> listPublicVideo(){
		return new ArrayList<Video>();
		//����videocsv
	}
	/**
	 * This method is for every user to play a particular video.
	 * 
	 * @param video
	 * 			the video want to play
	 */
	public void playVideo(Video video) { //��video��
		
	}

	/**
	 * This method is only for member client to buy a particular video.
	 * 
	 * @param videoBuy
	 * 			the video want to buy
	 */
	public void buyVideo(Video VideoBuy) {
		if(this.userType == "Member") {
			int money = 100;      //check money from scv
			consume(money);
		}else {
			System.out.println("Wrong clientType");
		}
	}
	
	/**
	 * This method is only for member client to list all paid videos.
	 * 
	 * @return ArrayList<Video>
	 * 			all the Videos need to be paid
	 */
	public ArrayList<Video> listPaidVideo(){
		
		ArrayList<Video> paidVideo = new ArrayList<Video>();
		
		return paidVideo;
			
	}
	/**
	 * This method is only for member client to list all purchased videos.
	 * 
	 * @return ArrayList<Video>
	 * 			all the Videos the client purchased
	 */
	public ArrayList<Video> listPurchasedVideo(){
		//clientVideo.csv
		//purchaseVideoListID, userid, videoid
		//return videoid String[]
		if(this.userType == "Member") {
			return new ArrayList<Video>();
		}else {
			System.out.println("Wrong clientType");
			return null;
		}
		
	}
	/**
	 * This method is only for SupremeMember to list all private videos provided by instructor.
	 * 
	 * @return ArrayList<Video>
	 * 			all the Videos private
	 */
	public ArrayList<Video> listPrivateVideo(){
		//AssignVideo.csv
		if(this.userType == "SupremeMember") {
			
			return new ArrayList<Video>();
		}else {
			System.out.println("wrong type");
			return null;
		}
	}

	
	//related to instructor
	
	/**
	 * This method is only for SupremeMember client to list all instructors.
	 * 
	 * @return ArrayList<Instructor>
	 * 			all the instructor
	 */
	public ArrayList<Instructor> listAllInstructor(){
		if(this.userType == "SupremeMember") {
			
			return new ArrayList<Instructor>();
		}else {
			System.out.println("You can not see all instructors");
			return null;
		}
	}
	
	/**
	 * This method is only for SupremeMember client to list personal instructors.
	 * 
	 * @return ArrayList<Instructor>
	 * 			all the instructor
	 */
	public ArrayList<Instructor> listMyInstructor(){
		//clientInstructor.csv
		ArrayList<Instructor> myInstructor = new ArrayList<Instructor>();

		return myInstructor;
	}
	
	/**
	 * This method is only for SupremeMember client to buy a instructor.
	 * 
	 * @param instructor
	 * 			the instructor want to buy
	 */
	public void buyInstructor(Instructor instructor) {
		//instructor.instructor.money;
		this.consume(1000);
	}
	
	/**
	 * This method is only for SupremeMember client to check a particular instructor.
	 * 
	 * @param instructor
	 * 			the instructor want to check
	 */
	public void checkInstructor(Instructor instructor) {
		
	}
	
}

