package test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

public class autosuggest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");


		WebDriver dr3 = new FirefoxDriver(); 
		dr3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		dr3.manage().window().maximize();
		

		dr3.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		dr3.findElement(By.cssSelector("input[id=\"autosuggest\"]")).sendKeys("ind");
		
		List<WebElement> options = dr3.findElements(By.cssSelector("li[class=\"ui-menu-item\"] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
		dr3.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		System.out.println(dr3.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		List<WebElement> boxes = dr3.findElements(By.cssSelector("input[type=\"checkbox\"]"));
		System.out.println("Size of checkboxes is " + boxes.size());
		for (WebElement box:boxes) {
			System.out.println("Webelement name - " + box.getAttribute("id"));
		}
		
		//Calendar Selection
		Thread.sleep(5000);
		
		dr3.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();		
		dr3.findElement(By.xpath("//a[@value=\"ATQ\"]")).click();
		
		dr3.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		dr3.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();
		
		dr3.findElement(By.id("ctl00_mainContent_view_date1")).click();
		dr3.findElement(By.cssSelector(".ui-datepicker-week-end.ui-datepicker-days-cell-over.ui-datepicker-today")).click();
		
		System.out.println(dr3.findElement(By.id("Div1")).getAttribute("style"));
		dr3.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println("Round trip enabled?? "+dr3.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isEnabled());
		System.out.println(dr3.findElement(By.id("Div1")).getAttribute("style"));
		if (dr3.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			System.out.println("Round trip enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

}
