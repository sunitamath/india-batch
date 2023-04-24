package Practice1;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;  

public class First {  
  
    public static void main(String[] args) {

    // declaration and instantiation of objects/variables  
    	System.setProperty("webdriver.http.factory", "jdk-http-client");
    System.setProperty("webdriver.chrome.driver", "D:/Sunita/Selenium Advance/chromedriver/chromedriver.exe");  
    WebDriver driver = new ChromeDriver();  

    // Launch website
    driver.navigate().to("http://www.google.com/");  

    // Click on the search text box and send value  
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");  
 
    // Click on the search button  
    driver.findElement(By.id("nav-search-submit-button")).click();  

    }
}