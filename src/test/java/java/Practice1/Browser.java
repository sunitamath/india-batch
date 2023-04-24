package Practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static void main(String[] orgs) throws InterruptedException  {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		System.setProperty("webdriver.chrome.driver","D:/Sunita/Selenium Advance/chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
Thread.sleep(3000);
		driver.close();
		
	}


}