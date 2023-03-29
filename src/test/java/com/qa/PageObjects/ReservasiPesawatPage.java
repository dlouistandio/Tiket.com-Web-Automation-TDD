package com.qa.PageObjects;

import com.qa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;
import java.util.List;


public class ReservasiPesawatPage extends BaseTest {
    @FindBy(xpath = "//div[@class='SearchForm_verticalIcons__7QwNj']//li[.='Pesawat']")
    private WebElement tiketPesawat;

    @FindBy(xpath = "//input[@tabindex='1']")
    private WebElement flightFrom;

    @FindBy(xpath = "//input[@tabindex='2']")
    private WebElement flightTo;

    @FindBy(xpath = "//input[@tabindex='3']")
    private WebElement tanggalBerangkat;

    @FindBy(xpath = "//input[@tabindex='4']")
    private WebElement tanggalPulang;

    @FindBy(xpath = "//strong[.='Mei 2023']")
    private WebElement months;

    @FindBy(xpath = "//div[@class='widget-date-prev-next']//i[@class='tix tix-chevron-right']")
    private WebElement nextBtnDate;

    @FindBy(xpath = "//div[@class='CalendarMonthGrid CalendarMonthGrid_1 CalendarMonthGrid__horizontal CalendarMonthGrid__horizontal_2']/div[3]//tr/td")
    private WebElement days;

    @FindBy(xpath = "//div[@class='row checkbox-flightform']//input[1]")
    private WebElement  pulangBtn;

    @FindBy(xpath = "//ul[.='EkonomiPremium EkonomiBisnisFirst']/li/label")
    private WebElement pilihKelas;


    public ReservasiPesawatPage pesawatPage(){
        click(tiketPesawat);
        return new ReservasiPesawatPage();
    }

    public ReservasiPesawatPage flightFrom(String text) {
        click(flightFrom);
        sendKeys(flightFrom, text, Keys.ENTER);
        return this;
    }

    public ReservasiPesawatPage flightTo(String text){
        click(flightTo);
        sendKeys(flightTo, text, Keys.ENTER);
        return this;
    }

    public ReservasiPesawatPage departureDate(){
        click(tanggalBerangkat);

        String month = "Mei 2023";
        String exp_date = "23";

        while (true){
            String text = getText(months);
            if(text.equals(month)){
                break;
            }else{
                click(nextBtnDate);
            }
        }

        List<WebElement> allDates = (List<WebElement>) days;
        for (WebElement all:allDates){
            String dateText = getText(all);
            if (dateText.equals(exp_date)){
                click(all);
                break;
            }
        }
        return this;
    }

    public ReservasiPesawatPage returnDate() {
        click(pulangBtn);
        click(tanggalPulang);

        String month = "Mei 2023";
        String exp_date = "23";

        while (true){
            String text = getText(months);
            if(text.equals(month)){
                break;
            }else{
                click(nextBtnDate);
            }
        }

        List<WebElement> allDates = (List<WebElement>) days;
        for (WebElement all:allDates){
            String dateText = all.getText();
            if (dateText.equals(exp_date)){
                all.click();
                break;
            }
        }
        return this;
    }

//    public void selectPenumpang(){
//        List<WebElement> allClass = driver.findElements(pilihKelas);
//        for (WebElement penumpang:allClass){
//            if (penumpang.getText().equals("Premium Ekonomi")){
//                penumpang.click();
//                driver.findElement(By.xpath("//button[@class='v3-btn btn-done']")).click();
//            }
//        }
//    }
//
//    public void searchFlight()throws InterruptedException{
//        driver.findElement(By.xpath("//button[@class='v3-btn v3-btn__yellow']")).click();
//        Thread.sleep(5000);
//    }
}

