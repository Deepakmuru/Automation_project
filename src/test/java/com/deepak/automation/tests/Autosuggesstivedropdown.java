package com.deepak.automation.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Autosuggesstivedropdown
{
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));

    }

    @Test
    public void testAutosuggestiveDropdown() throws InterruptedException {
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option : options) {
            if(option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
         driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
         Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
        driver.findElements(By.cssSelector("input[type='checkbox']")).size();
         Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),6);

         











       
    }

    
}