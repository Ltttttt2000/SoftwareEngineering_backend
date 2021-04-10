package Iteration1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class FileUtils {
	/**
	 * 
	 * Create a CSV file, that is, add the header
	 * @param filePath
	 * 			The path and name of the file to create
	 * @param headers
	 * 			The header of the CSV file that was created
	 */
	public static void createCSV(String filePath, String[] headers) {
		try {
			CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("GBK"));
			csvWriter.writeRecord(headers);
			
			csvWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Appends a data entry to an existing CSV file. The data entry can be multiple
	 * 
	 * @param filePath
	 * 			The path and name of the file to which the data entry was added
	 * @param csvList
	 * 			The data entry to insert
	 */
	public static void insertCSV(String filePath,  ArrayList<String[]> csvList) {
		try {
            
            BufferedWriter out = new BufferedWriter(new 

                    OutputStreamWriter(new FileOutputStream(filePath,true),"GBK"),1024);
            
         // Create a CSV write object
            CsvWriter csvWriter = new CsvWriter(out,',');
 
            int row = 0;
            String[] content = {""};
            
            for(row = 0; row < csvList.size(); row++) {
            	content = csvList.get(row);
            	csvWriter.writeRecord(content);
            }
            
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Read data from a CSV file
	 * 
	 * @param filePath
	 * 			The path and name of the file to read the data from
	 * @param cloum
	 * 			For which columns of data to read, "*" represents all reads
	 * @return
	 * 		The data entry read from the CSV file
	 */
	public static ArrayList<String[]> readCSV(String filePath, String[] cloum) {
		ArrayList<String[]> csvList = new ArrayList<String[]>();
		
        try {
            // Create a CSV read object
            CsvReader csvReader = new CsvReader(filePath, ',' , Charset.forName("GBK"));

            // Read the header
            csvReader.readHeaders();
            
            //Read all the data for each row
            if(cloum[0].equals("*")) {
            	while(csvReader.readRecord()) {
            		csvList.add(csvReader.getValues());
            	}
            }
            else {
            	String[] item = {""};
            	int i;
            	while(csvReader.readRecord()) {
            		for(i = 0; i < cloum.length; i++) {
            			//Read a column of data in this row
            			item[i] = csvReader.get(cloum[i]);
            		}
            		csvList.add(item);
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return csvList;
	}
	
	
	/**
	 * Delete files or folders
	 * 
	 * @param fileName
	 * 			The name of the file or folder that was deleted
	 * @return
	 * 		Whether the file or folder was deleted successfully
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
//			System.out.println("ɾ���ļ�ʧ�ܣ�" + fileName + "�ļ�������");
			return false;
		} else {
			if (file.isFile()) {
				return deleteFile(fileName);
			} 
			else {
				return deleteDirectory(fileName);
			}
		}
	}
	
	public static boolean deleteDirectory(String dir) {
		// If dir does not end with a file delimiter, the file delimiter is automatically added
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		
		File dirFile = new File(dir);
		
		// If the file corresponding to dir does not exist or is not a directory, exit
		if (!dirFile.exists() || !dirFile.isDirectory()) {
//			System.out.println("ɾ��Ŀ¼ʧ��" + dir + "Ŀ¼�����ڣ�");
			return false;
		}
		
		boolean flag = true;
		
		// Delete all files in the folder (including subdirectories)
		File[] files = dirFile.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			// Delete subfile
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// Delete subdirectories
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}
 
		if (!flag) {
//			System.out.println("ɾ��Ŀ¼ʧ��");
			return false;
		}
 
		// Delete current directory
		if (dirFile.delete()) {
//			System.out.println("ɾ��Ŀ¼" + dir + "�ɹ���");
			return true;
		} 
		else {
//			System.out.println("ɾ��Ŀ¼" + dir + "ʧ�ܣ�");
			return false;
		}
	}
	
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
//			System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
			return true;
		} else {
//			System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
			return false;
		}
	}
	
}
