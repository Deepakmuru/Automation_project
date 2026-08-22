package com.deepak.automation.tests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class webpagesortageTest {
    
    WebDriver driver;
    @BeforeMethod

    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");


    }
    @Test
    public void sorted()
    {
        driver.findElement(By.cssSelector("th[aria-sort='descending']")).click();
        List <WebElement> getList = driver.findElements(By.xpath("//tr/td[1]"));
        List <String> actualList = getList.stream().map(s->s.getText()).collect(Collectors.toList());
        List <String> sortedList = actualList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(actualList.equals(sortedList));

        // scan the name column and getText -> Rice -> Print the price of the Rice
        List<String> beanPrices = getList.stream()
                .filter(s -> s.getText().contains("Beans"))
                .map(webpagesortageTest::getPriceVeggie)
                .collect(Collectors.toList());

    }

    private static String getPriceVeggie(WebElement veggie) {
        return veggie.findElement(By.xpath("./following-sibling::td[1]")).getText();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
        
    
}
