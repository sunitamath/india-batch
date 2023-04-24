package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import POM.LoginPage;


public class CreateOrganizationTest extends BaseClass {

	@Test
	public void CreateOrganization() throws InterruptedException, IOException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;


		
		FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
		
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		driver.get(URL);
	
		
		//driver.get("http://localhost:8888/");
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		//driver.findElement(By.id("submitButton")).click();
		
		
	LoginPage LoginPage = new LoginPage(driver);
	LoginPage.loginToApp(USERNAME, PASSWORD);
		
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		
		
		
		//driver.findElement(By.name("accountname")).sendKeys("testyentra7");
		//driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[22]/td/div/input[1]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
		//driver.findElement(By.linkText("Sign Out")).click();

		// TODO Auto-generated method stub/*

	}

}
