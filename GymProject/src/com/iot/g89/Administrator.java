package com.iot.g89;

import java.io.File;
import java.util.ArrayList;


public class Administrator extends User{
	
	public Administrator(String userid) {
		super(userid);
	}
	/**
	 * List all the clients information.
	 * 
	 * @return 
	 * 		All client objects in arraylist
	 */
	public ArrayList<Client> listAllClient(){
		ArrayList<Client> allClients = new ArrayList<Client>();
		String fileName = "client.csv";
		String path = "./clients/";      
		File file = new File(path);		
		File[] fs = file.listFiles();	
		for(File f:fs){					
			if(!f.isDirectory()) {
				//String[] fileHeaders = {"userid"};
				ArrayList<String[]> thisUser = FileUtils.readCSV(f.getPath(), fileHeaders);
				String userID = thisUser.get(0)[0]; //get the userid
				Client aClient = new Client(userID);
				allClients.add(aClient);
			}
		}
		return allClients;
	}

	/**
	 * List all the clients information.
	 * 
	 * @return 
	 * 		All client objects in arraylist
	 */
	public ArrayList<Instructor> listAllInstructor(){
		ArrayList<Instructor> allInstructor = new ArrayList<Instructor>();
		String path = "./instructors/";      
		File file = new File(path);		
		File[] fs = file.listFiles();	
		for(File f:fs){					
			if(!f.isDirectory()) {
				//String[] fileHeaders = {"userid"};
				ArrayList<String[]> thisInstructor = FileUtils.readCSV(f.getPath(), fileHeaders);
				String userID = thisInstructor.get(0)[0]; //get the userid
				Instructor aInstructor = new Instructor(userID);
				allInstructor.add(aInstructor);
			}
		}
		return allInstructor;
	}
	
	/**
	 * List all the users information.
	 * 
	 * @return 
	 * 		All user objects in arraylist
	 */
	public ArrayList<User> listAllUser(){
		ArrayList<User> allUser = new ArrayList<User>();
		String clientPath = "./clients/";
		String instructorPath = "./instructors/";
		String administratorPath = "./administrators/";
		
		File fileClient = new File(clientPath);		
		File[] fs = fileClient.listFiles();	
		for(File f:fs){					
			if(!f.isDirectory()) {
				//String[] fileHeaders = {"userid"};
				ArrayList<String[]> thisUser = FileUtils.readCSV(f.getPath(), fileHeaders);
				String userID = thisUser.get(0)[0]; //get the userid
				Client aClient = new Client(userID);
				allUser.add(aClient);
			}
		}
		
		File fileInstructor = new File(instructorPath);		
		File[] fs1 = fileInstructor.listFiles();	
		for(File f:fs1){					
			if(!f.isDirectory()) {
				//String[] fileHeaders = {"userid"};
				ArrayList<String[]> thisUser = FileUtils.readCSV(f.getPath(), fileHeaders);
				String userID = thisUser.get(0)[0]; //get the userid
				Instructor aInstructor = new Instructor(userID);
				allUser.add(aInstructor);
			}
		}
		
		File fileAdmini = new File(administratorPath);		
		File[] fs2 = fileAdmini.listFiles();	
		for(File f:fs2){					
			if(!f.isDirectory()) {
				//String[] fileHeaders = {"userid"};
				ArrayList<String[]> thisUser = FileUtils.readCSV(f.getPath(), fileHeaders);
				String userID = thisUser.get(0)[0]; //get the userid
				Administrator aAdmini = new Administrator(userID);
				allUser.add(aAdmini);
			}
		}
		return allUser;
	}
	
	/**
	 * List all the videos information.
	 * 
	 * @return 
	 * 		All videos objects in arraylist.
	 */
	public ArrayList<Video> listAllVideo(){
		ArrayList<Video> allVideo = new ArrayList<Video>();
		String path = "./videoCSVs/";      
		File file = new File(path);		
		File[] fs = file.listFiles();	
		for(File f:fs){					
			if(!f.isDirectory()) {
				String[] videoHeaders = {"videoid"};
				ArrayList<String[]> thisVideo = FileUtils.readCSV(f.getPath(), videoHeaders);
				String videoID = thisVideo.get(0)[0]; 
				Video aVideo = new Video(videoID);
				allVideo.add(aVideo);
			}
		}
		return allVideo;
	}
	
	/**
	 * Delete a user.
	 * @param userDel
	 * 		The user need to be deleted.
	 */
	//´«µÝID»¹ÊÇobject??
	public void deleteUser(User userDel) {
		String userid = userDel.userid;
		
		String typeOfUser = userDel.getClass().getName();
		
		String path = "./" + typeOfUser + "/" + userid + "/csv";
		File check = new File(path);
		if(!check.exists()) {
			System.out.println("Operation fail! The user didn't exist!");
		}
		else {
			FileUtils.delete(userid+".csv");
		}
	}
	
	/**
	 * Ban a user so that the user cannot do any operations.
	 * @param userBan
	 * 		The User need to be banned.
	 */
	public void banUser(User userBan) {
		userBan.banThisAccount();
	}
	
	/**
	 * Delete the particular video.
	 * @param videoDel
	 * 		The video need to be deleted.
	 */
	public void deleteVideo(Video videoDel) {
		String deletedVideoID = videoDel.videoid;
		File check = new File("./video/"+ deletedVideoID +".csv");
		if(!check.exists()) {
			System.out.println("The video didn't exist!");
		}
		else {
			FileUtils.delete(deletedVideoID + ".csv");
			FileUtils.delete(deletedVideoID + ".mp4");    //???
		}
	}
}
