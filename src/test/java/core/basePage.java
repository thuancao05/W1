package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public basePage(){
        this.driver = new ChromeDriver();
    }
}
