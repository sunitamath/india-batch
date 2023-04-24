package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public static WebDriver sdriver;
	 public WebDriver driver;
	 public Property_Utility plib=new Property_Utility();
	 
	
	@BeforeSuite(groups={"smoketest","regressiontest","sanitytest"})
	public void BS()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest(groups= {"smoketest","regressiontest","sanitytest"})
	
	public void BT()
	
	{
		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.out.println("Parallel execution");

	}
	//@Parameters({"BROWSER"})
	@BeforeClass(groups= {"smoketest","regressiontest","sanitytest"})
	//public void BC(String BROWSER ) throws Throwable
	public void BC() throws Throwable
	{
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		
		//System.out.println(BROWSER);
	
	
	if(BROWSER.equalsIgnoreCase("chrome"))
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
	}
		System.out.println("Launching browser");
		sdriver=driver;

	}

	@Parameters({"url","un","pwd"})
	@BeforeMethod(groups= {"smoketest","regressiontest","sanitytest"})
	public void BM(String URL,String USERNAME,String PASSWORD)
	//public void BM() throws Throwable
	{
		//driver.manage().window().maximize();
		//String URL = plib.getKeyValue("url");
	   // String USERNAME = plib.getKeyValue("username");
	  // String PASSWORD = plib.getKeyValue("password");
	   driver.get(URL);
	   LoginPage loginPage=new LoginPage (driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login application");

	}
	
	@AfterMethod(groups= {"smoketest","regressiontest","sanitytest"})
	public void AM()
	{
		HomePage home=new HomePage(driver);
		home.signoutLink(driver);
		System.out.println("Logout application");

	}
	@AfterClass(groups= {"smoketest","regressiontest","sanitytest"})
	public void AC()
	{
		//driver.quit();
		System.out.println(" Browser closed");

	}
	@AfterTest(groups= {"smoketest","regressiontest","sanitytest"})
	public void AT() 
	{
		System.out.println("Parallelexecution done");

	}
	@AfterSuite(groups= {"smoketest","regressiontest","sanitytest"})
	public void AS()
	{
		System.out.println("DataBase connection done");

	}

}

