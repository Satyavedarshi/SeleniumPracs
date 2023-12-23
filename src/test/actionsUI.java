package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr1.get("https://www.amazon.in/");
		dr1.manage().window().maximize();
		
		Actions a1 = new Actions(dr1);
		a1.moveToElement(dr1.findElement(By.cssSelector("a[id=\"nav-link-accountList\"]"))).build().perform();
		
		a1.moveToElement(dr1.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		
	}

}
