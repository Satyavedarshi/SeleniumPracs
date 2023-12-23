package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dr1.get("https://www.path2usa.com/travel-companion/");
		dr1.manage().window().maximize();
		
		WebDriverWait w1 = new WebDriverWait(dr1, Duration.ofSeconds(15));
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".elementor-field.elementor-size-sm.elementor-field-textual.elementor-date-field.flatpickr-input")));
		dr1.findElement(By.cssSelector(".elementor-field.elementor-size-sm.elementor-field-textual.elementor-date-field.flatpickr-input")).click();
		

	}

}
