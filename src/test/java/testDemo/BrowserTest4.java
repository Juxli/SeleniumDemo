package testDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserTest4 {
    WebDriver dr;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeTest(String browser, String url){
        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            dr = new ChromeDriver();

        }
        else if (browser.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            dr = new FirefoxDriver();
        }

        dr.get(url);
        dr.manage().window().maximize();
    }

    // 默认执行顺序为：Test方法名按字符对比，小的先执行，所以无论test1写在哪里都会先执行 test1，后执行test2
    // 更改顺序：1. 用priority指定 执行顺序 2. 在testng.xml方法中指定方法的执行顺序, priority的优先级高于setting 里面指定的优先级
    @Test
    public void test1(){
        dr.findElement(By.id("kw")).clear();
        dr.findElement(By.id("kw")).sendKeys("selenium");
        dr.findElement(By.id("su")).click();
    }
    @Test
    public void test2(){
        dr.findElement(By.id("kw")).clear();
        dr.findElement(By.id("kw")).sendKeys("java");
        dr.findElement(By.id("su")).click();
    }

    @AfterTest
    public void afterTest(){
        dr.quit();
    }
}
