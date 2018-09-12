package com.guru99.first;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {

    @Before
    public void  startWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Projects\\chromedriver.exe");
    }

    @Test
    public void locateTitle(){

        String userId = "mngr152196";
        String password = "Evajeta";

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://www.demo.guru99.com/V4/");
        Assert.assertTrue("Title should be http://www.demo.guru99.com/V4/",
                            driver.getTitle().startsWith("Guru99 Bank Home Page"));

        WebElement uid = driver.findElement(By.name("uid"));
        uid.sendKeys(userId);

        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys(password);

        driver.findElement(By.name("btnLogin")).click();

        Assert.assertTrue("Title should be http://www.demo.guru99.com/V4/",
                driver.getTitle().startsWith("Guru99 Bank Manager HomePage"));

        driver.close();
        driver.quit();
    }

}
