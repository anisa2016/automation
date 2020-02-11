package com.akmal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Auto {

	public static void main(String[] args) {

	    
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String weburl="https://dice.com";
		driver.get(weburl);
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Find Jobs in Tech | Dice.com | Find Jobs in Tech";
		//System.out.println(title);
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			
		System.out.println("Successfully launched");
		driver.findElement(By.xpath("//input[@placeholder=\"Job title, skills or company\"]")).sendKeys("java developer");
		driver.findElement(By.id("google-location-search")).clear();
		driver.findElement(By.id("google-location-search")).sendKeys("Chicago");
		driver.findElement(By.id("submitSearch-button")).click();
		}
		else {
			System.out.println("Our code failed");
		}
		
		String countJobs=driver.findElement(By.id("totalJobCount")).getText();
		System.out.println(countJobs);
		int countResult=Integer.parseInt(countJobs);
		
		if(countResult>0) {
			System.out.println("Step PASS -->>"+"there are "+countResult +" java developer openings in this location");
		}
		else {
			System.out.println("Step FAIL -->>"+"there are no java developer openings in this location");
		}
		
		
		driver.close();
	}

}
