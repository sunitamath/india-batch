package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	/**
	 * This method wait for page to load in GUI
	 * @param driver
	 * @author sunita
	 */
	public void implicitlyWait(WebDriver driver)
	{
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}



	/**
	 * this method is used for switching windows
	 * @param driver
	 * @param PartialWindowTitle
	 * @author sunita
	 */



public void switchwindow(WebDriver driver,String PartialWindowTitle)
{
	Set<String> allId = driver.getWindowHandles();//org //cont //prd
	Iterator<String> id = allId.iterator();
	
	while(id.hasNext())
	{
		String wid=id.next();//org //cont
		driver.switchTo().window(wid);
		String title=driver.getTitle();
		if(title.contains(PartialWindowTitle))
		{
			break;
		}
	}
}



	public Object mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		return act;
		
	}
}