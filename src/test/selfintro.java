package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selfintro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/saramise/Downloads/chromedriver-mac-arm64/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
	
		
		WebDriver dr3 = new ChromeDriver(); 
		  dr3.get("http://phoenix67143.ad1.fusionappsdphx1.oraclevcn.com:35344/fabs/");
		  System.out.println(dr3.getCurrentUrl());
		  
		  dr3.close();
	}

}
