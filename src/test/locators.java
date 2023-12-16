package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/saramise/Downloads/chromedriver-mac-arm64/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
	
		
		WebDriver dr3 = new FirefoxDriver(); 
		dr3.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));  
		dr3.get("http://phoenix67143.ad1.fusionappsdphx1.oraclevcn.com:35344/fabs/");
		  System.out.println(dr3.getCurrentUrl());
		  
		  //By ClassName
		  dr3.findElement(By.className("form-control")).sendKeys("satyavedarshi.ramisetti@oracle.com");
		  System.out.println(dr3.findElement(By.name("internalSSOUserId")).getTagName());
		  System.out.println("end");
		  
		  //By Css tagname.classname
		  dr3.get("http://phoenix67143.ad1.fusionappsdphx1.oraclevcn.com:35344/fabs/");
		  dr3.findElement(By.cssSelector("input.form-control")).sendKeys("by css clasname");
		  
		  //By Css tagname[attribute="value"]
		  dr3.get("http://phoenix67143.ad1.fusionappsdphx1.oraclevcn.com:35344/fabs/");
		  dr3.findElement(By.cssSelector("input[placeholder=\"Internal SSO Email ID\"]")).sendKeys("by cssselect attribute");
		  System.out.println(dr3.findElement(By.cssSelector("input[placeholder=\"Internal SSO Email ID\"]")).getText() + " get text");
		 
		  
		  //By ID
		  dr3.get("https://www.oracle.com/");
		  dr3.findElement(By.id("u10footer1")).click();
		  
		  //By Css tagname#ID
		  dr3.get("https://www.oracle.com/");
		  dr3.findElement(By.cssSelector("a#u10footer2")).click();
		  
		  //By LinkText
		  dr3.get("https://www.oracle.com/");
		  dr3.findElement(By.linkText("Careers")).click();
		  
		  //By XPATH
		  //dr3.findElement(By.xpath("//a[@data-lbl=\"careers-hero-search-jobs\"]")).click();
		  
		  
		  //By Customized XPATH
		  //System.out.println("customized xpath");
		  //dr3.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		  //dr3.findElement(By.xpath("//input[@type=\"text\"][1]")).sendKeys("Satya");
		 
		  Thread.sleep(1000);
		  //By Parent - Child XPATH
		  dr3.get("https://www.linkedin.com/login");
		  System.out.println(dr3.getTitle() + " is the title");
		  dr3.findElement(By.xpath("//div/input[@id=\"username\"]")).sendKeys("testing");
		  //dr3.close();
	}

}
