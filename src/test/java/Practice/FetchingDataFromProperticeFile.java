package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromProperticeFile {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\3D Objects\\Insta.Properties");
	Properties prop=new Properties();
	prop.load(fis);
	String URL=prop.getProperty("url");
	System.out.println(URL);
	WebDriver driver=new ChromeDriver();
	driver.get(URL);
}
}
