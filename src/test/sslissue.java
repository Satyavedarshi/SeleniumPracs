package test;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.asserts.SoftAssert;

import org.apache.commons.io.FileUtils;

public class sslissue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver",  "/Users/saramise/Downloads/geckodriver");
		
		FirefoxOptions opt = new FirefoxOptions();
		opt.setAcceptInsecureCerts(true);
		
		WebDriver dr1 = new FirefoxDriver(opt);
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		dr1.get("https://expired.badssl.com/");
		dr1.manage().window().maximize();
		dr1.manage().deleteAllCookies();
		System.out.println(dr1.getTitle());
		
		dr1.get("https://www.amazon.in/");
		dr1.manage().window().maximize();
		
		File f1 = ((TakesScreenshot)dr1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("/Users/saramise/Downloads/test.png"));
		
		//Broken Link or URl
		dr1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> w1 = dr1.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
		SoftAssert sa = new SoftAssert();
		
		for (WebElement we:w1) {
			String url = we.getAttribute("href");
			if(!url.contains("http"))
				continue;
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int res = conn.getResponseCode();			
			System.out.println("Connection Response for  " +url + " is " +res);
			
			sa.assertTrue(res<400, "This link is broken "+url);
		}
		sa.assertAll();
		
		
		

	}

}
