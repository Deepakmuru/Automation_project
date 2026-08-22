
package com.deepak.automation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class WindowTest
{
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));

    }

    @Test
    void Windowhandle()
    {
        driver.findElement(By.xpath("(//a[contains(text(),'Free Access to InterviewQues/ResumeAssistance/Material')])[1]")).click();
        
        Set<String> Windows = driver.getWindowHandles();
        Iterator<String> it = Windows.iterator();
        String parentId = java.util.Objects.requireNonNull(it.next());
        String childId = java.util.Objects.requireNonNull(it.next());

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String emailID = java.util.Objects.requireNonNull(
            driver.findElement(By.cssSelector(".im-para.red"))
                  .getText()
                  .split("at")[1]
                  .trim()
                  .split(" ")[0]
        );
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailID);


    }
}