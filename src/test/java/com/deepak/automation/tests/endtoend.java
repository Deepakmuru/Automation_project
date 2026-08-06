

package com.deepak.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class endtoend {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));
    }

    @Test
    public void testEndToEnd() throws InterruptedException 
    {
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[text='Chennai (MAA)']")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@text='Bengaluru (BLR)'])[2]")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click(); 
        Thread.sleep(2000);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("hrefIncAdt")).click();
        for(int i=0; i<2; i++)
        {
            driver.findElement(By.id("hrefIncChd")).click();
        }
        driver.findElement(By.id("hrefIncChd")).click();
        Thread.sleep(2000);
        for(int i=0; i<2; i++)
        {
            driver.findElement(By.id("hrefIncInf")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
        driver.findElement(By.cssSelector("option[value='INR']")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }



    }

