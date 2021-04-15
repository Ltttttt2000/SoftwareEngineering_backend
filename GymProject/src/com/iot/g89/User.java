package com.iot.g89;
/**
 * 
 */

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author DongWanqi
 *
 */
public class User{
	
	String userid; 
	String password; 
	String userType; 
	String sex;
	String phoneNumber;
	Boolean loginLicense = true;
	int rechargeAmount = 0;      //the total money in the account
	String resume;  //for instructor
	
	
	//需不需要new?
	String[] fileHeaders = new String[10];
	
	//注意这里是List!!而FileUtils 里面返回的都是以String[] 为元素的list，读的是文件的行，每一行是一个String[]
	ArrayList<String[]> userInfoList = new ArrayList<String[]>();
	
	String[] userInfo = new String[] {"0","0","0","0","0","0","0","0"};
	
	ArrayList<String[]> selectList = new ArrayList<String[]>();
	String[] readAll = {"*"}; // 为了给readCSV传入一个读全部的 *
 	
	PhysicalInfo physicalInfo;
	
	public User(String userid){
		this.userid = userid;
		userInfo[0] = this.userid;
		
		fileHeaders[0] = "userid";
		fileHeaders[1] = "password";
		fileHeaders[2] = "userType";
		fileHeaders[3] = "sex";
		fileHeaders[4] = "phoneNumber";
		fileHeaders[5] = "loginLicense";
		fileHeaders[6] = "rechargeAmount";
		fileHeaders[7] = "resume";
	
		if(this.getClass().getSimpleName() == "Instructor") {
			fileHeaders[8] = "InstructorMoney";
		}
			
		
		File check = new File("./"+ this.getClass().getSimpleName() + ".csv");
		if(!check.exists()) {
			FileUtils.createCSV("./"+ this.getClass().getSimpleName() + ".csv", fileHeaders);
		}
		else {
			selectList = FileUtils.readCSV("./"+ this.getClass().getSimpleName() + ".csv", readAll);
			
			this.password = selectList.get(0)[1];
			userInfo[1] = this.password;
			this.userType = selectList.get(0)[2];
			userInfo[2] = this.userType;
			this.sex = selectList.get(0)[3];
			userInfo[3] = this.sex;
			this.phoneNumber = selectList.get(0)[4];
			userInfo[4] = this.phoneNumber;
			this.loginLicense = Boolean.valueOf(selectList.get(0)[5]);
			userInfo[5] = String.valueOf(this.loginLicense);
			this.rechargeAmount = Integer.parseInt(selectList.get(0)[6]);
			userInfo[6] = String.valueOf(this.rechargeAmount);
			this.resume = selectList.get(0)[7];
			userInfo[7] = this.resume;
			
		}
	}

	
	 void setPassword(String password) {
		 this.password = password;
		 userInfo[1] = this.password;
		 
	 }
	 
	 void setUserType(String userType) {
		 this.userType = userType;
		 userInfo[2] = this.userType;
	 }
	 
	 //新加，记得要在子类新加一下
	 void setSex(String sex) {
		 this.sex = sex;
		 userInfo[3] = this.sex;
		 
	 }
	 
	 void setPhone(String phone) {
		 this.phoneNumber = phone;
		 userInfo[4] = this.phoneNumber;
		 
	 }
	 
	 void setResume(String resume) {
		 this.resume = resume;
		 userInfo[7] = this.resume; 
	 }
	 
	 
	 //新加method, 最后在GUI里改完所有再统一写回文件
	 void renewUserInfo() {
		 //删文件
		 FileUtils.delete("./"+ this.getClass().getSimpleName() + ".csv");
		 userInfoList.add(userInfo);
		 //重新建一个文件
		 FileUtils.createCSV("./"+ this.getClass().getSimpleName() + ".csv", fileHeaders);
		 FileUtils.insertCSV("./"+ this.getClass().getSimpleName() + ".csv", userInfoList);
		 
	 }
	 
	 //	TODO !!! 感觉应该删掉，直接通过getUserPhysicalInfo new 一个physicalInfo，调用里面的get set 就可以
	 void setPhysicalInfo(PhysicalInfo physicalInfo) {
		 
	 }
	 
	 void banThisAccount() {
		 this.loginLicense = false;
	 }
	 void unbanThisAccount() {
		 this.loginLicense = true;
	 }

	 String getId() {
		return this.userid;
		 
	 }
	 String getPassword() {
		return this.password;
		 
	 }
	 String getUserType(){
		return this.userType; 
		 
	 }
	 String getPhone() {
		return this.phoneNumber;
		 
	 }
     Boolean getLloginLlicence(){
		return this.loginLicense ;
		 
	 }
     
     //TODO !!!
	 PhysicalInfo getUserPhysicalInfo() {
		 physicalInfo = new PhysicalInfo(this.userid);
		 return this.physicalInfo;
	 }
}
