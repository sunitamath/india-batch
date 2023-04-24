package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductDelete {

	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	    FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
		Properties p1=new Properties();
	    p1.load(fis);
	    String URL = p1.getProperty("url");
	    String USERNAME = p1.getProperty("username");
	    String PASSWORD = p1.getProperty("password");
	    
	    driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook wb = WorkbookFactory.create(fes);
		String ExpectedproName = wb.getSheet("product").getRow(2).getCell(1).getStringCellValue();
		
		Random r=new Random();
		int ran = r.nextInt(10000);
		ExpectedproName=ExpectedproName+ran;
		
		driver.findElement(By.name("productname")).sendKeys(ExpectedproName);
		driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[31]/td/div/input[1]")).click();
		
		
		
		

	
	
	
		// TODO Auto-generated method stub

	}

}
