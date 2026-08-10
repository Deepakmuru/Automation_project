


package com.deepak.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class Scope
{
   WebDriver driver;
   @BeforeMethod
   public void setup()
   {
      driver = new ChromeDriver();
      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
      driver.getTitle();
      driver.manage().window().maximize();
   }

   @Test
   void Urlauto() throws InterruptedException
   {
      System.out.println(driver.findElements(By.tagName("a")).size());
      WebElement footer = driver.findElement(By.id("gf-BIG"));
      System.out.println(footer.findElements(By.tagName("a")).size());

      WebElement firstfourfooter = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
      System.out.println(firstfourfooter.findElements(By.tagName("a")).size());

      for(int i = 1; i < firstfourfooter.findElements(By.tagName("a")).size(); i++)
      {
         String clickon = Keys.chord(Keys.CONTROL, Keys.ENTER);
         firstfourfooter.findElements(By.tagName("a")).get(i).sendKeys(clickon);
         Thread.sleep(5000);
      }

         Set<String> abc = driver.getWindowHandles();
         Iterator<String> it = abc.iterator();

         while(it.hasNext())
         {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
         }
      }


      
   }
