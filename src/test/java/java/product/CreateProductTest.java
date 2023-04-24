package product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Generic_Utility.Property_Utility;
import POM.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class CreateProductTest {

	@Test
	public  void CreateProduct() throws Throwable{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		//System.setProperty("webdriver.chrome.driver","D:/Sunita/Selenium Advance/chromedriver/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
	//WebDriver driver;
	//WebDriverManager.chromedriver().setup();
	//driver=new ChromeDriver();
	
		Property_Utility plib=new Property_Utility();
	String BROWSER = plib.getKeyValue("browser");
	
	WebDriver driver;
	//Property_Utility plib=new Property_Utility();
	//String BROWSER = plib.getKeyValue("browser");
	if(BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new EdgeDriver();
	}
	else
	{
		driver=new ChromeDriver();

	}
	
	/*if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new EdgeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();

	}*/
		
	driver.manage().window().maximize();	
	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

    FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
	
	Properties pro=new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");

	driver.get(URL);

	
	//driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	
	
	
	//driver.findElement(By.linkText("Products")).click();
//	driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img"));
	
	
	
		// TODO Auto-generated method stub

	}

	private static ChromeDriver WebDriverManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
