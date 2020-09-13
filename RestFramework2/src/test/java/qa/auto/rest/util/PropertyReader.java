package qa.auto.rest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Singleton design Pattern

//make constructor private
//create static member variable
//create a static method to get the instance

public class PropertyReader {

	//create static member variable
	//to avoid multiple threading issue
	private static  volatile PropertyReader propInstance;
	
	//make constructor private
	private  PropertyReader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//create a static method to get the instance
	//everytime this method is going to be called hence we check if it is null then only 
	//create a new instance
	//if this method is accessible my multiple threads we can run into problems
	//hence we add synchrozied keyword
	public static synchronized PropertyReader getInstance() {
		
		if (propInstance == null) {
			propInstance = new PropertyReader();
		}
		return propInstance;
	}

	
	 /**
	 * @param propertyName
	 * @return
	 */
	public String getPropertyDetails(String  propertyName) {
		 
		 Properties p = new Properties();
		
	       try {
	    	   InputStream inputStream =  getClass().getClassLoader().getResourceAsStream("config.properties");
			p.load(inputStream);
			
			if(p.getProperty(propertyName) !=null){
			return 	(p.getProperty(propertyName));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	 }
}
