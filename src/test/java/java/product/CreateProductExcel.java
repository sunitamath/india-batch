package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.HomePage;
import POM.LoginPage;

public class CreateProductExcel {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
				
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
			   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

				
				FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
				
		// TODO Auto-generated method stub
				Properties pro=new Properties();
				pro.load(fis);
				String URL = pro.getProperty("url");
				String USERNAME = pro.getProperty("username");
				String PASSWORD = pro.getProperty("password");

				driver.get(URL);
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				LoginPage LoginPage = new LoginPage(driver);
				LoginPage.loginToApp(USERNAME, PASSWORD);
				//LoginPage.getSubmitBtn().click();
				
				
				
				
				
				//driver.findElement(By.linkText("Products")).click();
				
				
				driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
				
				Random ran=new Random();
				int RanNum = ran.nextInt(1000);
				
				FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
				Workbook book = WorkbookFactory.create(fes);
				 Sheet sheet = book.getSheet("Product");
				Row row = sheet.getRow(1);
				Cell cell = row.getCell(3);
				String exceldata = cell.getStringCellValue();
				
				driver.findElement(By.name("productname")).sendKeys(exceldata);
				driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[31]/td/div/input[1]")).click();
				String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
				if(actdata.contains(exceldata))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
					
				
				driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
				driver.findElement(By.linkText("Sign Out")).click();

				// TODO Auto-generated method stub/*

			}

		

				
				
				
				
				
	}


