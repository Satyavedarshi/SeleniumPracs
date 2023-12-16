package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class staticdropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub



		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");


		WebDriver dr3 = new FirefoxDriver(); 
		dr3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		dr3.manage().window().maximize();
		

		dr3.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement statdrop = dr3.findElement(By.xpath("//select[@id=\"ctl00_mainContent_DropDownListCurrency\"]"));
		Select s1 = new Select(statdrop);
		//Thread.sleep(5000);
		s1.selectByVisibleText("AED");
		System.out.println(s1.getFirstSelectedOption().getText() + " is the selected");
		
		//Thread.sleep(5000);
		s1.selectByIndex(3);
		System.out.println(s1.getFirstSelectedOption().getText() + " is the selected");
		
		//Thread.sleep(5000);
		s1.selectByValue("AED");
		System.out.println(s1.getFirstSelectedOption().getText() + " is the selected");
		
		dr3.findElement(By.id("divpaxinfo")).click();
		for (int i = 0;i<5;i++) {
			dr3.findElement(By.id("hrefIncAdt")).click();
		}
			
		dr3.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(dr3.findElement(By.id("divpaxinfo")).getText());
		
		Thread.sleep(5000);
		
		dr3.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();		
		dr3.findElement(By.xpath("//a[@value=\"ATQ\"]")).click();
		
		dr3.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		dr3.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();
		
		// Parent child XPATH in dropdowns, use this instead of indexing
		dr3.navigate().refresh();
		dr3.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();		
		dr3.findElement(By.xpath("//a[@value=\"MAA\"]")).click();
		dr3.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"DED\"]")).click();
		


	}

}
