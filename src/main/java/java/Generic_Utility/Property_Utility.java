package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property_Utility {
	/**
	 * This method is used to launch the application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author sunita
	 */
	
	public String getKeyValue(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String Value = pro.getProperty(Key);
		return Value;
		
	}

}
