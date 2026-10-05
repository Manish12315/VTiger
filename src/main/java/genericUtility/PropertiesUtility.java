	package genericUtility;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	/**
	*this is a utility class which deals with properties file 
	*@author Qsp
	*@version 26-08-04
	*/
	public class PropertiesUtility {
	/**
	 * This is generic method to fetch the data from propertues file
	 * @param key
	 * @return
	 * @throws IOException
	 */
		public String getDataFromProperties(String key) throws IOException{
		FileInputStream fis =new FileInputStream(IPathUtility.PropertiesPath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		}
	}

