package com.deepak.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class Locators3
{
    WebDriver driver;
    @BeforeEach
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

    @AfterEach
    public void tearDown()
    {
        driver.close();
    }
    
}