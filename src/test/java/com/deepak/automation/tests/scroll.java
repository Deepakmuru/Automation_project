package com.deepak.automation.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scroll
{
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

    }

    @Test
    void scrolls()
    {
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List <WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for(int i = 0; i < values.size(); i++)
        {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }

        System.out.println(sum);

       int total = Integer.parseInt (driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
       Assert.assertEquals(sum, total);
    }
}