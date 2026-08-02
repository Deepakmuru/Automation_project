package com.deepak.automation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class staticdropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));
    }

    @Test
    public void dropdownTest() throws InterruptedException
    {
       WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
       Select dropdown = new Select(staticDropdown);
       dropdown.selectByIndex(3);
      System.out.println( dropdown.getFirstSelectedOption().getText());
      dropdown.selectByVisibleText("USD");
      System.out.println( dropdown.getFirstSelectedOption().getText());
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());


    driver.findElement(By.id("divpaxinfo")).click();
      Thread.sleep(3000);
      for(int i = 0; i < 4; i++)
      {
          driver.findElement(By.id("hrefIncAdt")).click();
          Thread.sleep(1000);
      }
      driver.findElement(By.id("btnclosepaxoption")).click(); 
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());





        
    }
}
