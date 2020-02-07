package dummy.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;

import dummy.model.User;

@Service
public class CSVFileService {
	
	private int counter = 0;
	private String feedback;
	private String line = "";
	private BufferedReader br = null;
	private String csvFile = "C:\\Users\\sayantan_c01\\Desktop\\trial.csv";
	private String csvSplitBy = ",";
	
	public  String createRow(User user) {
		try {
			CSVWriter writer = new CSVWriter( new FileWriter(new File(csvFile)));
			String[] userDetails = { user.getUsername().toString(), user.getPassword().toString() };
			
			writer.writeNext(userDetails);
			writer.close();
		} catch (IOException e) {
			feedback = "Access issue in CSV file";
			System.out.println(feedback);
			e.printStackTrace();
		}
		feedback = "User record written successfully";
		return feedback;
		
	}
	
	public String printAllUsers() {
		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	counter++;
            	if(counter==1)
            		continue;
            	else {
	                String[] userAttr = line.split(csvSplitBy);
	                System.out.println("["+" name= " + userAttr[0] + " , class=" + userAttr[1] + " , class=" + userAttr[2]+"]");
            	}

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return feedback;
		
	}
	

}
