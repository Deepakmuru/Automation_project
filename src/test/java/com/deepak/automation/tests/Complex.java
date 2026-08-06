package com.deepak.automation.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Arrays;

public class Complex
{
    WebDriver driver;
    WebDriverWait w;
    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(2)));


        w = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));


    }

    @Test
    public void addtocart() throws InterruptedException
    {
        int j = 0;
        String [] itemslist = {"Tomato", "Beans", "Carrot"};
        List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i = 0; i < products.size(); i++)
        {
            String [] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            List <String> itemsNeeded = Arrays.asList(itemslist);

            if(itemsNeeded.contains(formattedName))
            {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j == itemsNeeded.size())
                    break;
            }
        }

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='promoBtn']")));
        driver.findElement(By.cssSelector("button[class='promoBtn']")).click();

        //explicitly tells your code for wait few minutes and it doesn't affect others
       
        
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
        System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());

    }





   
}
