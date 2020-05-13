package testDemo;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest1 {
    @Test
    public void Browser(){
        // Chrome testing
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//        WebDriver dr = new ChromeDriver();

        // Firefox testing
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver dr = new FirefoxDriver();

        dr.manage().window().maximize();
        dr.get("https://www.baidu.com");
        dr.findElement(By.id("kw")).clear();
        dr.findElement(By.id("kw")).sendKeys("selenium");
        dr.findElement(By.id("su")).click();
        dr.quit();
    }
}
