package test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class windowactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
	
		
		WebDriver dr3 = new FirefoxDriver(); 
		dr3.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
		dr3.manage().window().maximize();
		
		dr3.get("https://www.oracle.com/");
		dr3.navigate().to("https://www.linkedin.com/login");
		dr3.navigate().back();
		dr3.navigate().forward();
	}

}
