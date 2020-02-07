package dummy.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import com.opencsv.CSVWriter;


public class Startup implements ApplicationListener<ContextStartedEvent>{
	File file;
	FileWriter outputfile;
	CSVWriter writer;
	
	public Startup() {
		super();
	}


	@PostConstruct
	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		 file = new File("C:\\Users\\sayantan_c01\\Desktop\\trial.csv");
		 System.out.println("file created");
		
			 try {
				outputfile = new FileWriter(file); 
				 writer = new CSVWriter(outputfile); 
				String[] header = { "Name", "Class", "Marks" };
				System.out.println(header);
				writer.writeNext(header);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	   }

}
