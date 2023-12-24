package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.*;


public class relativeloc {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dr1.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement w1 = dr1.findElement(By.cssSelector("[name=\"name\"]"));
		
		System.out.println(dr1.findElement(RelativeLocator.with(By.tagName("label")).above(w1)).getText());
		
		WebElement dat1 = dr1.findElement(By.cssSelector("[for='dateofBirth']"));
		dr1.findElement(RelativeLocator.with(By.tagName(("input"))).below(dat1)).click();
		
		WebElement check1 = dr1.findElement(By.xpath("//label[@class=\"form-check-label\"]"));
		dr1.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(check1)).click();
		
		WebElement radio1 = dr1.findElement(By.cssSelector("label[for=\"exampleFormControlRadio1\"]"));
		dr1.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(radio1)).click();
		
		dr1.switchTo().newWindow(WindowType.TAB).get("https://rahulshettyacademy.com/");
		Set windows = dr1.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		dr1.switchTo().window(childid);
		String n1 = dr1.findElements(By.cssSelector("a[href*=\"https://courses.rahulshettyacademy.com/p\"]")).get(1).getText();
		
		dr1.switchTo().window(parentid);
		
		WebElement nameelem = dr1.findElement(By.cssSelector("[name='name']"));
		nameelem.sendKeys(n1);
		
		File f1 = nameelem.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("/Users/saramise/Downloads/partialwebelement.png"));
		
		//Get textbox width
		System.out.println(nameelem.getRect().getDimension().getHeight());
		System.out.println(nameelem.getRect().getDimension().getWidth());
		
		dr1.manage().window().maximize();
		
		System.out.println(nameelem.getRect().getDimension().getHeight());
		System.out.println(nameelem.getRect().getDimension().getWidth());
		
		

	}

}
