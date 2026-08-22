package com.deepak.automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorssTest 
{
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));
    }

    @Test
    void titleTest() throws InterruptedException {
        String name = "deepak";
        String password = getPassword(driver);
        System.out.println(driver.getCurrentUrl());
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.tagName("p")).getText());
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello " + name + ",");

        driver.findElement(By.className("logout-btn")).click();
    }

   public static String getPassword(WebDriver driver) throws InterruptedException
{
    driver.findElement(By.linkText("Forgot your password?")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
    String infoMessage = driver.findElement(By.cssSelector("form p")).getText();

    String[] passwordArray = infoMessage.split("'");
    String password = passwordArray[1].split("'")[0];

    // Dismiss modal without needing the exact close-button selector
    driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
    Thread.sleep(1000);

    return password;
}

    @AfterMethod
    void teardown() {
        driver.close();
    }
}