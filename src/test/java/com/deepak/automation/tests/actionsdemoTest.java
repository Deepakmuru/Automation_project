package com.deepak.automation.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class actionsdemoTest {
    WebDriver driver;
    Actions a;

    void actions()
    {
        driver = new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(2)));
        a = new Actions(driver);
    }
    
    @Test
    void testActionsDemo()
    {
        actions();
        WebElement move = driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));

        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(move).contextClick().build().perform();
   }
}
