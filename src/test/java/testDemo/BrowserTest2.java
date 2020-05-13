package testDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserTest2 {
    WebDriver dr;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
    }

    @Test
    public void browser(){
        dr.get("https://www.baidu.com");
        dr.findElement(By.id("kw")).clear();
        dr.findElement(By.id("kw")).sendKeys("selenium");
        dr.findElement(By.id("su")).click();
    }

    @AfterTest
    public void afterTest(){
        dr.quit();
    }

}
