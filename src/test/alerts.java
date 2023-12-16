package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");


		WebDriver dr3 = new FirefoxDriver(); 
		dr3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		dr3.manage().window().maximize();


		dr3.get("https://rahulshettyacademy.com/AutomationPractice/");

		dr3.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Satya");
		dr3.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		System.out.println(dr3.switchTo().alert().getText());
		dr3.switchTo().alert().accept();

		dr3.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Satya");
		dr3.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		System.out.println(dr3.switchTo().alert().getText());
		dr3.switchTo().alert().dismiss();

	}

}
