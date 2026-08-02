package com.deepak.automation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));
    }

    @Test
    void titleTest() throws InterruptedException {
         driver.get("https://rahulshettyacademy.com/locatorspractice/");
         System.out.println(driver.getCurrentUrl());   
         String title = driver.getTitle();
         System.out.println(title);
         driver.findElement(By.id("inputUsername")).sendKeys("deepak");
         driver.findElement(By.name("inputPassword")).sendKeys("deepak");
         driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("deepak");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("deepak01@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234567890");
        Thread.sleep(4000);
        String infoMessage = driver.findElement(By.cssSelector(".reset-pwd-btn")).getText();
        System.out.println(infoMessage);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        Thread.sleep(2000); 
        driver.findElement(By.id("inputUsername")).sendKeys("deepak");
         driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
       String loginMessage = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
       System.out.println(loginMessage);
       


        
         




        

         

    
    }

    // @AfterEach
    //     void tearDown() {
    //     driver.close();
    // }
}