package com.deepak.automation.tests;

import org.openqa.selenium.Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ssl
{
    WebDriver driver;
    @BeforeMethod

    public void setup()
    {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        driver = new FirefoxDriver(options);
        driver.get("https://expired.badssl.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void sslcert()
    {
        System.out.println(driver.getTitle());
    }
}