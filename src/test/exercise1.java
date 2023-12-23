package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class exercise1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dr1.get("https://rahulshettyacademy.com/AutomationPractice/");
		dr1.manage().window().maximize();
		
		//Find All Elements with a tag
		System.out.println(dr1.findElements(By.tagName("a")).size());
		
		//Limit scope of driver to footer section
		WebElement footdr1 = dr1.findElement(By.cssSelector("div[id=\"gf-BIG\"]"));
		System.out.println(footdr1.findElements(By.tagName("a")).size());
		
		
		//Limit to 1st column in footerdriver
		WebElement firstcolfooter = footdr1.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		int nooflinks = firstcolfooter.findElements(By.tagName("a")).size();
		System.out.println(nooflinks);
		
		// Check links in first column footer are opening
		for (int i=0;i<nooflinks;i++) {
			String clickonlink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			firstcolfooter.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			
		}
		//Thread.sleep(5000);
		
		Set<String> windows = dr1.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()){
			dr1.switchTo().window(it.next());
			System.out.println("Window Title is - "+ dr1.getTitle());
		}
		
		

	}

}
