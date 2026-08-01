package com.deepak.automation;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators2 
{
    WebDriver driver;

    @BeforeEach
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

        Assertions.assertEquals("You are successfully logged in.", driver.findElement(By.tagName("p")).getText());
        Assertions.assertEquals("Hello " + name + ",", driver.findElement(By.tagName("h2")).getText());

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

    @AfterEach
    void teardown() {
        driver.close();
    }
}