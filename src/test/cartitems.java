package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartitems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");


		WebDriver dr1 = new FirefoxDriver(); 
		
		//Implicitly Wait
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		dr1.manage().window().maximize();
		
		dr1.get("https://rahulshettyacademy.com/seleniumPractise/");
		ArrayList<String> itemnamelist = new ArrayList<String>(Arrays.asList("Cucumber", "Brocolli", "Beetroot"));
		
		cartitems cartitems = new cartitems();
		cartitems.addItems(dr1, itemnamelist);
		
		dr1.findElement(By.cssSelector("a[class=\"cart-icon\"]")).click();
		dr1.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		dr1.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		dr1.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();
		
		//Explicitly Wait
		WebDriverWait w = new WebDriverWait(dr1,Duration.ofSeconds(15));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"promoInfo\"]")));
		System.out.println("Promo validity message - "+ dr1.findElement(By.xpath("//span[@class=\"promoInfo\"]")).getText());
		
	}
	
	public void addItems(WebDriver dr2, ArrayList<String> itemslist) {
		
   List <WebElement> products = dr2.findElements(By.cssSelector("h4[class=\"product-name\"]"));
		
		//expected array
		
		//String[] itemnames = {"Cucumber", "Brocolli", "Beetroot"};
		//List itemnamelist = Arrays.asList(itemnames);
		
		int addedcount = 0;
		
		for (int i=0; i< products.size(); i++) {
			if (itemslist.contains(products.get(i).getText().split(" ")[0])) {
				dr2.findElements(By.xpath("//div[@class=\"product-action\"]")).get(i).click();
				addedcount += 1;
				if (addedcount==itemslist.size()) {
					System.out.println("All 3 items added");
					break;
					
				}
			}
			
		}
		
	}

}
