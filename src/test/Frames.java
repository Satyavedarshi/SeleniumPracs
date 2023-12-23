package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dr1.get("https://jqueryui.com/droppable/");
		dr1.manage().window().maximize();
		
		dr1.switchTo().frame(dr1.findElement(By.cssSelector("iframe[class=\"demo-frame\"]")));
		System.out.print(dr1.findElement(By.id("draggable")).getText());
		
		Actions a1 = new Actions(dr1);
		
		WebElement source = dr1.findElement(By.id("draggable"));
		WebElement target = dr1.findElement(By.id("droppable"));
		a1.dragAndDrop(source, target).build().perform();
		
		dr1.switchTo().defaultContent();
		

	}

}
