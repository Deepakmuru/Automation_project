package com.deepak.automation.tests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class filterTest
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }

    @Test
    public void filters()
    {
       driver.findElement(By.id("search-field")).sendKeys("Rice");
       List <WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
       List <WebElement> sortedList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
       Assert.assertEquals(veggies.size(), sortedList.size());

    }
}