/**
 * 
 */
package Iteration1;

import java.io.File;
import java.util.ArrayList;

/**
 * @author DongWanqi
 *
 */
public class PhysicalInfo {
	int age;
	double height; 
	double weight;
	double chest; 
	double waist; 
	double hip;
	String[] physicalInfoHeaders = {"age","height","weight","chest","waist","hip"};
	
	ArrayList<String[]> selectList = new ArrayList<String[]>();
	
    ArrayList<String[]> userPhysicalList = new ArrayList<String[]>();
	String[] userPhysical = new String[10];
	
	String[] readAll = {"*"}; // 为了给readCSV传入一个读全部的 *
	
	public PhysicalInfo(String userid) {
		File check = new File("./"+ this.getClass().getName() + "/"+userid +".csv");
		if(!check.exists()) {
			FileUtils.createCSV("./"+ this.getClass().getName() + "/"+userid +".csv", fileHeaders);
		}
		else {
			selectList = FileUtils.readCSV("./"+ this.getClass().getName() + "/"+userid+".csv", readAll);
			
			this.age = Integer.parseInt(selectList.get(0)[1]);
			userPhysical[1] = Integer.toString(this.age);
			this.height = Double.parseDouble(selectList.get(0)[2]);
			userPhysical[2] = Double.toString(this.height);
			this.weight = Double.parseDouble(selectList.get(0)[3]);
			userPhysical[3] = Double.toString(this.weight);
			this.chest = Double.parseDouble(selectList.get(0)[4]);
			userPhysical[4] = Double.toString(this.chest);
			this.waist = Double.parseDouble(selectList.get(0)[5]);
			userPhysical[5] = Double.toString(this.waist);
			this.hip = Double.parseDouble(selectList.get(0)[5]);
			userPhysical[6] = Double.toString(this.hip);
		}
	}
	int getAge() {
		return this.age;
	}
	 
	double getHeight() {
		return this.height; 
	}
	
	double getWeight() {
		return this.weight;
	}
	
	double getChest() {
		return this.chest;
	}
	
	double getWaist() {
		return this.waist;
	}
	
	double getHip() {
		return this.hip;
	}

	
	void setAge(int age) {
		this.age = age;
		userPhysical[1] = Integer.toString(this.age);
		
	}
	
	 void setHeight(double height) { 
		 this.height = height;
		 userPhysical[2] = Double.toString(this.height);
	 }
	 
	 void setWeight(double weight) { 
		 this.weight = weight;
		 userPhysical[3] = Double.toString(this.weight);
	 }
	 
	 void setChest(double chest) { 
		 this.chest = chest; 
		 userPhysical[4] = Double.toString(this.chest);
			
	 }
	 
	 void setWaist(double waist) { 
		 this.waist = waist;
		 userPhysical[5] = Double.toString(this.waist);
			
	 }
	 
	 void setHip(double hip) {
		 this.hip = hip;
		 userPhysical[6] = Double.toString(this.hip);
	 }
	 
}