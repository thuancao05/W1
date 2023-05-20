package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboard_page {
    private WebDriver driver;


    private By logo = By.xpath("//body/div[1]/a[1]/img[1]");
    private By btnUser = By.xpath("//header/div[2]/div[1]/a[1]");
    private By btnSigOut = By.xpath("//a[contains(text(),'Sign Out')]");
    private By lblWarning = By.xpath("//div[contains(text(),'This is only a demo store. You can browse and plac')]");


    public dashboard_page(WebDriver driver) {
        this.driver = driver;
    }
    public String getDashBoardPageTitle(){
        return driver.getTitle();
    }


    public WebElement LogoImg() {
        return driver.findElement(logo);
    }

    public WebElement UserButton() {
        return driver.findElement(btnUser);
    }

    public WebElement SigOutButton() {
        return driver.findElement(btnSigOut);
    }

    public WebElement WarningLabel() {
        return driver.findElement(lblWarning);
    }
}
