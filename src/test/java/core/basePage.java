package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public basePage(WebDriver driver){
        this.driver = driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10), 100);
        PageFactory.initElements(driver, this);
    }
}
