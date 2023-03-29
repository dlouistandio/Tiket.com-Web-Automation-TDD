package com.qa.TestScenario;

import com.qa.BaseTest;
import com.qa.PageObjects.ReservasiPesawatPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReservasiPesawat extends BaseTest {
    ReservasiPesawatPage reservasiPesawatPage;
    @Test
    public void reservasiTiket(){
        reservasiPesawatPage = new ReservasiPesawatPage();

        reservasiPesawatPage.pesawatPage();
        reservasiPesawatPage.flightFrom("Jakarta");
        reservasiPesawatPage.flightTo("Banjarmasin");
        reservasiPesawatPage.departureDate();
        reservasiPesawatPage.returnDate();
    }
}