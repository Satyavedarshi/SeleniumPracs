package test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		dr1.findElement(By.cssSelector("[id=\"start\"] button")).click();
		
		
		//FluentWait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(dr1).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement test = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver dr1) {
				if(dr1.findElement(By.cssSelector("[id=\"finish\"] h4")).isDisplayed()) {
					return dr1.findElement(By.cssSelector("[id=\"finish\"] h4"));
				}
				else
					return null;
				
			}
		}
				);
		System.out.println(test.isDisplayed());
		System.out.print("Found hello World - "+ test.getText());
		

	}

}
