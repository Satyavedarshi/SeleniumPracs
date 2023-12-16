package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2eflightsearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");


		WebDriver dr3 = new FirefoxDriver(); 
		dr3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		dr3.manage().window().maximize();


		dr3.get("https://rahulshettyacademy.com/dropdownsPractise/");

		dr3.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		dr3.findElement(By.cssSelector("a[value=\"BLR\"")).click();

		dr3.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		dr3.findElement(By.xpath("//div[@class=\"dropdownDiv\"] //a[@value=\"MAA\"]")).click();
		//dr3.findElement(By.cssSelector("a[value=\"MAA\"")).click();

		dr3.findElement(By.xpath("//input[@id=\"ctl00_mainContent_view_date1\"]")).click();
		dr3.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		if (!dr3.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			System.out.println("return Date is disabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}

		Thread.sleep(2000);
		dr3.findElement(By.id("divpaxinfo")).click();
		for(int i=0;i<4;i++) {
			dr3.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println("Number of passengers --> "+ dr3.findElement(By.id("divpaxinfo")).getText());

		WebElement currency = dr3.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s1 = new Select(currency);

		s1.selectByValue("USD");

		dr3.findElement(By.xpath("//input[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();

	}

}
