package com.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        try{
            //        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.tiket.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }catch (Exception e){
            e.printStackTrace();
        }
}

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

//    public void waitForVisibilty(WebElement e){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(e));
//    }

    public void click(WebElement e){
//        waitForVisibilty(e);
        e.click();
    }

    public void sendKeys(WebElement e, String text,Keys send){
//        waitForVisibilty(e);
        e.sendKeys(text,send);
    }

    public String getText(WebElement e){
        return getText(e);
    }
}
