package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.*;


public class basePage {
// sua moi ne
    protected WebDriver driver;
    protected WebDriverWait wait;

    public basePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(20));
        PageFactory.initElements(driver,this);
    }
}
