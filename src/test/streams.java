package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/saramise/Downloads/geckodriver");
		
		WebDriver dr1 = new FirefoxDriver();
		dr1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alex");
		names.add("satya");
		names.add("Adam");
		names.add("Test");
		names.add("Ram");
		names.add("Joya");
		names.add("Arun");
		
		Long c1 = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("Names starting wiht A is - "+ c1);
		
		Stream.of("Alex","Arun","Satya","Testname","Rama","Dinner","Bro").filter(s->s.endsWith("a")).limit(1).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String> a1 = Arrays.asList("Alex","Arun","Satya","Testname","Rama","Dinner","Bro");
		a1.stream().filter(s->s.contains("a")).sorted().forEach(s->System.out.println(s));
		
		System.out.println("\n Concatednated Stream");
		Stream.concat(names.stream(), a1.stream()).forEach(s->System.out.println(s));
		
		
		boolean namecheck = names.stream().anyMatch(s->s.equalsIgnoreCase("adam"));
		System.out.println(namecheck);
		Assert.assertTrue(namecheck);
		
		
		List<String> newnames = names.stream().filter(s->s.startsWith("A")).map(s->s.toLowerCase()).collect(Collectors.toList());
		System.out.print(newnames.get(0));
		
		List<String> uniqnamestest = Arrays.asList("Alex","Arun","Alex","Arun","Alex","Arun","Alex");
		System.out.println("\n\n New names UNique");
		uniqnamestest.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("\n\n");
		
		
		dr1.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		dr1.manage().window().maximize();
		
		dr1.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> firstcol = dr1.findElements(By.xpath("//tr/td[1]"));
		
		List<String> vegnames = firstcol.stream().map(w->w.getText()).collect(Collectors.toList());
		
		List<String> sortedveggies = vegnames.stream().sorted().collect(Collectors.toList());
		
		sortedveggies.stream().forEach(s->System.out.println(s));
		Assert.assertTrue(vegnames.equals(sortedveggies));
		
		
		//Get price of the RICE
		List<String> strs;
		do {
			firstcol = dr1.findElements(By.xpath("//tr/td[1]"));
			strs = firstcol.stream().filter(w->w.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
			if(strs.size()<1) {
				dr1.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			strs.stream().forEach(s->System.out.println(s));
		}while(strs.size()<1);
		
		
		//Filter the table data
		dr1.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> filteredrows = dr1.findElements(By.xpath("//tr/td[1]"));
		System.out.println("Size of filtered rice is "+filteredrows.size());
		
		List<WebElement> expectedlist = filteredrows.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		System.out.println("Size of expected rice is "+expectedlist.size());
		
		Assert.assertEquals(filteredrows.size(), expectedlist.size());
		
		
		
				
	}
	
	private static String getVeggiePrice(WebElement web1){
		String price = web1.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;
		
	}

}
