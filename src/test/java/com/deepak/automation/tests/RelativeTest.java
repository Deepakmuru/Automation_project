package com.deepak.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeTest
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
    }

    @Test
    public void filter()
    {
        WebElement abovetext = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        System.out.println(driver.findElement(with(By.tagName("Label")).above(abovetext)).getText());
        WebElement leftbox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(leftbox)).click();
        WebElement rightbox = driver.findElement(By.xpath("//label[text()='Employment Status: ']"));
        driver.findElement(with(By.tagName("input")).toRightOf(rightbox)).click();
        WebElement belowtext = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
        driver.findElement(with(By.tagName("input")).below(belowtext)).click();
    }
}