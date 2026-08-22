package com.deepak.automation.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class miscTest
{
    WebDriver driver;
    @BeforeMethod

    public void setup() throws IOException
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://netflix.com");
         java.io.File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

         FileUtils.copyFile(src, new File("C:/Automation/selenium-practice/screenshot.png"));
          
    }

    @Test
    public void ss()
    {
        System.out.println(driver.getTitle());
    }
    
}