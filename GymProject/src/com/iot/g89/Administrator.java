package com.iot.g89;

import java.util.ArrayList;

public class Administrator extends User{
	
	public Administrator(String userid) {
		super(userid);
	}
	
	/**
	 * List all the clients information.
	 * 
	 * @return 
	 * 		All client objects in Arraylist
	 */
	public ArrayList<Client> listAllClient(){
		ArrayList<Client> allClients = new ArrayList<Client>();
		String filePath = "./Client.csv";
		String[] attributes = {"userid"};
		
		ArrayList<String[]> clientsInfo = new ArrayList<String[]>();
		clientsInfo = FileUtils.readCSV(filePath, attributes);
		int i = 0;
		while(clientsInfo.get(i) != null) {
			Client client = new Client(clientsInfo.get(i)[0]);    //get userid, build Client
			allClients.add(client);		
			i++;
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
		String filePath = "./Instructor.csv";
		String[] attributes = {"userid"};
		
		ArrayList<String[]> instructorsInfo = new ArrayList<String[]>();
		instructorsInfo = FileUtils.readCSV(filePath, attributes);
		int i = 0;
		while(instructorsInfo.get(i) != null) {
			Instructor instructor = new Instructor(instructorsInfo.get(i)[0]);
			allInstructor.add(instructor);		
			i++;
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
		String[] usersID = {"userid"};
		//all Clients
		String clientPath = "./Client.csv";
		ArrayList<String[]> clientsInfo = new ArrayList<String[]>();
		clientsInfo = FileUtils.readCSV(clientPath, usersID);
		int i = 0;
		while(clientsInfo.get(i) != null) {
			Client client = new Client(clientsInfo.get(i)[0]);
			allUser.add(client);	
			i++;
		}
		
		String instruPath = "./Instructor.csv";
		ArrayList<String[]> instructorsInfo = new ArrayList<String[]>();
		instructorsInfo = FileUtils.readCSV(instruPath, usersID);
		int j = 0;
		while(instructorsInfo.get(j) != null) {
			Instructor instructor = new Instructor(instructorsInfo.get(i)[0]);
			allUser.add(instructor);	
			j++;
		}
		
		String adminPath = "./Administrator.csv";
		ArrayList<String[]> adminInfo = new ArrayList<String[]>();
		adminInfo = FileUtils.readCSV(adminPath, usersID);
		int k = 0;
		while(adminInfo.get(k) != null) {
			Administrator admin = new Administrator(adminInfo.get(i)[0]);
			allUser.add(admin);	
			k++;
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
		String filePath = "./videos.csv";
		String[] videoid = {"videoId"};
		ArrayList<String[]> videoInfo = new ArrayList<String[]>();
		videoInfo = FileUtils.readCSV(filePath, videoid);

		int i = 0;
		while(videoInfo.get(i) != null) {
			Video video = new Video(videoInfo.get(i)[0]);
			allVideo.add(video);	
			i++;
		}
		return allVideo;
	}
	
	/**
	 * Delete a user.
	 * @param userDel
	 * 		The user need to be deleted.
	 */
	public void deleteUser(User userDel) {
		String userid = userDel.userid;
		String typeOfUser = userDel.getClass().getSimpleName();
		String path = "./" + typeOfUser + ".csv";
		FileUtils.deleteCSV(userid, path);
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
		String videoid = videoDel.videoId;
		//delete from videoSCV
		String path = "./videoCSVs.csv";
		FileUtils.deleteCSV(videoid, path);
		//delete video
		FileUtils.delete(videoid+".mp4");
	}
}
