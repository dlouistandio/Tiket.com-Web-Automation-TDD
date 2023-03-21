package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ReservasiPesawatPage {
    WebDriver driver;

    public ReservasiPesawatPage(WebDriver driver){
        this.driver = driver;
    }

    By tiketPesawat = By.xpath("//div[@class='SearchForm_verticalIcons__7QwNj']//li[.='Pesawat']");
    By flightFrom = By.xpath("//input[@tabindex='1']");
    By flightTo = By.xpath("//input[@tabindex='2']");
    By tanggalBerangkat = By.xpath("//input[@tabindex='3']");
    By tanggalPulang = By.xpath("//input[@tabindex='4']");
    By months = By.xpath("//strong[.='Mei 2023']");
    By nextBtnDate = By.xpath("//div[@class='widget-date-prev-next']//i[@class='tix tix-chevron-right']");
    By days = By.xpath("//div[@class='CalendarMonthGrid CalendarMonthGrid_1 CalendarMonthGrid__horizontal CalendarMonthGrid__horizontal_2']/div[3]//tr/td");
    By pulangBtn = By.xpath("//div[@class='row checkbox-flightform']//input[1]");
    By pilihKelas = By.xpath("//ul[.='EkonomiPremium EkonomiBisnisFirst']/li/label");


    public void pesawatPage() throws InterruptedException{
        driver.findElement(tiketPesawat).click();
        Thread.sleep(1000);
    }

    public void flightFrom(){
        driver.findElement(flightFrom).click();
        driver.findElement(flightFrom).sendKeys("jakarta");

        List<WebElement> airportCode = driver.findElements();
    }

    public void flightTo(){

    }

    public void departureDate() throws InterruptedException{
        driver.findElement(tanggalBerangkat).click();
        Thread.sleep(1000);

        String month = "Mei 2023";
        String exp_date = "23";

        while (true){
            String text = driver.findElement(months).getText();
            if(text.equals(month)){
                break;
            }else{
                driver.findElement(nextBtnDate).click();
                Thread.sleep(1000);
            }
        }

        List<WebElement> allDates = driver.findElements(days);
        for (WebElement all:allDates){
            String dateText = all.getText();
            if (dateText.equals(exp_date)){
                all.click();
                break;
            }
        }
    }

    public void returnDate() throws InterruptedException{
        driver.findElement(pulangBtn).click();
        driver.findElement(tanggalPulang).click();

        Thread.sleep(1000);

        String month = "Mei 2023";
        String exp_date = "23";

        while (true){
            String text = driver.findElement(months).getText();
            if(text.equals(month)){
                break;
            }else{
                driver.findElement(nextBtnDate).click();
                Thread.sleep(1000);
            }
        }

        List<WebElement> allDates = driver.findElements(days);
        for (WebElement all:allDates){
            String dateText = all.getText();
            if (dateText.equals(exp_date)){
                all.click();
                break;
            }
        }
    }

    public void selectPenumpang() throws InterruptedException{
        List<WebElement> allClass = driver.findElements(pilihKelas);
        for (WebElement penumpang:allClass){
            if (penumpang.getText().equals("Premium Ekonomi")){
                penumpang.click();
                break;
            }
        }
    }
}

