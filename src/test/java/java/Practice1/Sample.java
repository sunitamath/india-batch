package Practice1;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver=WebDriverManager.edgedriver().create();
		driver.get("http://localhost:8888/");
		// TODO Auto-generated method stub
Thread.sleep(5000);
	}

}
