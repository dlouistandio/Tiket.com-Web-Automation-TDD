package TestScenario;

import PageObjects.ReservasiPesawatPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReservasiPesawat {
     WebDriver driver;

    @BeforeTest
    public void beforeTest() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tiket.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void reservasiTiket() throws InterruptedException{
        ReservasiPesawatPage page = new ReservasiPesawatPage(driver);
        page.pesawatPage();
        page.flightFrom();
        page.flightTo();
        page.departureDate();
        page.returnDate();
        page.selectPenumpang();
        page.searchFlight();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        System.out.println("Test Excecution complete");
    }

}
