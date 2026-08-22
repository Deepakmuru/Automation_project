package com.deepak.automation.tests;

import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class newWindowTest
{
    WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");



        driver.switchTo().newWindow(WindowType.TAB);
        Set <String> handles = driver.getWindowHandles();
        Iterator <String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com");
        
    }

    @Test
    public void newwin()
    {

    }
}