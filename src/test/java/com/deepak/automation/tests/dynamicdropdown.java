package com.deepak.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class dynamicdropdown {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));
    }

    @Test
    public void testDynamicDropdown() throws InterruptedException { 
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[text='Chennai (MAA)']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@text='Bengaluru (BLR)'])[2]")).click();
        Thread.sleep(2000);
        

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("its enabled");
            assert true;
        } 
        else 
            assert false;
        
       
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
