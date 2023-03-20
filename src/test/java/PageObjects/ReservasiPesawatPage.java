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
    By tanggalBerangkat = By.xpath("//input[@tabindex='3']");
    By tanggalPulang = By.xpath("//input[@tabindex='4']");
    By months = By.xpath("//strong[.='Mei 2023']");
    By nextBtnDate = By.xpath("//div[@class='widget-date-prev-next']//i[@class='tix tix-chevron-right']");
    By days = By.xpath("//div[@class='CalendarMonthGrid CalendarMonthGrid_1 CalendarMonthGrid__horizontal CalendarMonthGrid__horizontal_2']/div[3]//tr/td");



    public void pesawatPage() throws InterruptedException{
        driver.findElement(tiketPesawat).click();
        Thread.sleep(1000);
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
        driver.findElement(By.xpath("//div[@class='row checkbox-flightform']//input[1]")).click();
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

    public void selectPenumpang() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='SearchForm_verticalIcons__7QwNj']//li[.='Pesawat']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@tabindex='3']")).click();
        Thread.sleep(1000);

        String month = "Mei 2023";
        String exp_date = "23";

        while (true){
            String text = driver.findElement(By.xpath("//strong[.='Mei 2023']")).getText();
            if(text.equals(month)){
                break;
            }else{
                driver.findElement(By.xpath("//div[@class='widget-date-prev-next']//i[@class='tix tix-chevron-right']")).click();
                Thread.sleep(1000);
            }
        }

        List<WebElement> allDates = driver.findElements
                (By.xpath("//div[@class='CalendarMonthGrid CalendarMonthGrid_1 CalendarMonthGrid__horizontal CalendarMonthGrid__horizontal_2']/div[3]//tr/td"));
        for (WebElement all:allDates){
            String dateText = all.getText();
            if (dateText.equals(exp_date)){
                all.click();
                break;
            }
        }

        String kelasKabin = "Bisnis";
        while (true){
            String text = driver.findElement(By.xpath("//label[.='Bisnis']")).getText();
            if (text.equals(kelasKabin)){
                driver.findElement(By.xpath("//label[.='Bisnis']")).click();
            }else{
                System.out.println("Text Ga sesuai");
                break;
            }
        }

        driver.findElement(By.xpath("//button[@class='v3-btn btn-done']")).click();

        driver.quit();
        System.out.println("Test Excecution complete");
    }
}

