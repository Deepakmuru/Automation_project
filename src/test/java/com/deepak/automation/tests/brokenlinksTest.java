package com.deepak.automation.tests;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class brokenlinksTest {

    WebDriver driver;
    @BeforeMethod

    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }
    
    @Test
    public void brokenurl() throws MalformedURLException, IOException, Exception
    {
       // broken URL
       // List to get all URL's tied up to the links using Selenium
       // Java methods will call URL's and get you the status code
       // if status code > 400 , then the URL is not working - means it is broken;

       List < WebElement> Links = driver.findElements(By.cssSelector("li[class='gf-li']"));
       SoftAssert a = new SoftAssert();

       for(WebElement Link : Links )
       {
            String url = Link.getAttribute("HREF");
            HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responsecode = conn.getResponseCode();

            a.assertTrue(responsecode < 400 , " The following link is broken " + Link.getText() + " " + responsecode);


       }

       a.assertAll();   
      



    }
}
