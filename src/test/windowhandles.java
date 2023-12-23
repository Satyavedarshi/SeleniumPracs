package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class windowhandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dr1.get("https://rahulshettyacademy.com/loginpagePractise/");
		dr1.manage().window().maximize();
		
		dr1.findElement(By.xpath("//a[@class=\"blinkingText\"]")).click();
		
		Set<String> windows = dr1.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent1 = it.next();
		String child1 = it.next();
		
		dr1.switchTo().window(child1);
		String emailid = dr1.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailid);
		
		dr1.switchTo().window(parent1);
		
		dr1.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(emailid);
		
		
		
		

	}

}
