package com.deepak.automation.tests;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autosuggesstivedropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
    driver = new FirefoxDriver();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
    driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));
    }

    @Test
    public void testnew() throws InterruptedException {
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        
        for(WebElement option : options )
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
          System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected()); 
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
    }
      @AfterMethod
    public void teardown() {
        driver.quit();
    }
 
}

    

  



