package com.deepak.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
//TestNG is one of the Testing framework.

public class Locators3
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));
    }

    @Test
    public void testLocators()
    {
        String text = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println(text);
       System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
    
}