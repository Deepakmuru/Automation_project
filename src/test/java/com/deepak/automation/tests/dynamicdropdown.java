package com.deepak.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class dynamicdropdown {
    WebDriver driver;
    @BeforeEach
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
    }

}
