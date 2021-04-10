package Iteration1;
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
	Boolean loginLicense;
	
	//需不需要new?
	String[] fileHeaders = new String[10];
	
	fileHeaders[0] = "userid";
	fileHeaders[1] = "password";
	fileHeaders[2] = "userType";
	fileHeaders[3] = "sex";
	fileHeaders[4] = "phoneNumber";
	fileHeaders[5] = "loginLicense";
	//注意这里是List!!而FileUtils 里面返回的都是以String[] 为元素的list，读的是文件的行，每一行是一个String[]
	ArrayList<String[]> userInfoList = new ArrayList<String[]>();
	
	String[] userInfo = new String[10];
	
	ArrayList<String[]> selectList = new ArrayList<String[]>();
	String[] readAll = {"*"}; // 为了给readCSV传入一个读全部的 *
 	
	PhysicalInfo physicalInfo;
	
	public User(String userid){
		this.userid = userid;
		userInfo[0] = this.userid;
		File check = new File("./"+ this.getClass().getName() + "/"+userid +".csv");
		if(!check.exists()) {
			FileUtils.createCSV("./"+ this.getClass().getName() + "/"+userid +".csv", fileHeaders);
		}
		else {
			selectList = FileUtils.readCSV("./"+ this.getClass().getName() + "/"+userid+".csv", readAll);
			
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
	 
	 //新加method, 最后在GUI里改完所有再统一写回文件
	 void renewUserInfo() {
		 //删文件
		 FileUtils.delete("./"+ this.getClass().getName() + "/"+ this.userid +".csv");
		 userInfoList.add(userInfo);
		 //重新建一个文件
		 FileUtils.createCSV("./"+ this.getClass().getName() + "/"+ this.userid+".csv", fileHeaders);
		 FileUtils.insertCSV("./"+ this.getClass().getName() + "/"+ this.userid+".csv", userInfoList);
		 
	 }
	 
	 //	TODO !!!
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
