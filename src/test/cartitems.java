package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cartitems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");


		WebDriver dr1 = new FirefoxDriver(); 
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		dr1.manage().window().maximize();
		
		dr1.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		List <WebElement> products = dr1.findElements(By.cssSelector("h4[class=\"product-name\"]"));
		
		//expected array
		ArrayList<String> itemnamelist = new ArrayList<String>(Arrays.asList("Cucumber", "Brocolli", "Beetroot"));
		//String[] itemnames = {"Cucumber", "Brocolli", "Beetroot"};
		//List itemnamelist = Arrays.asList(itemnames);
		
		int addedcount = 0;
		
		for (int i=0; i< products.size(); i++) {
			if (itemnamelist.contains(products.get(i).getText().split(" ")[0])) {
				dr1.findElements(By.xpath("//div[@class=\"product-action\"]")).get(i).click();
				addedcount += 1;
				if (addedcount==itemnamelist.size()) {
					System.out.println("All 3 items added");
					break;
					
				}
			}
			
		}
		
	}

}
