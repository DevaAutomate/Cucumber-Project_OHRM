package nit.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropFile {
	
	//This class will have common methods to read data from property file
	
	//Method to read test data from property file (Example : Config/Cinfig.properties)
	public static Properties readProperties(String filename) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Config\\"+filename);			
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return prop;		
	}

}
