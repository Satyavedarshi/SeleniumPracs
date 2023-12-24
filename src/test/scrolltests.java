package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class scrolltests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dr1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) dr1;
		
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
		List<WebElement> w1 = dr1.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum1 = 0;
		for (int i=0;i< w1.size();i++) {
			sum1 += Integer.parseInt(w1.get(i).getText());
		}
		
		System.out.println("Sum of 4th column vals from table - " + sum1);
		
		int sumfromsummary = Integer.parseInt(dr1.findElement(By.cssSelector("div[class=\"totalAmount\"]")).getText().split(" ")[3].trim());
		
		System.out.println("Sum of 4th column vals from Summary - " + sumfromsummary);
		Assert.assertEquals(sum1, sumfromsummary);

	}

}
