package Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener{

	public void onTestFailure(ITestResult result, Object {
		String testName=result.getMethod().getMethodName();
		
		
		
		EventfiringWebDriver
		
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
		 String testName=result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
				File src=edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("./ScreenShot/"+testName+".png"));
		}
		
		
		{
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		
		
	}
}
