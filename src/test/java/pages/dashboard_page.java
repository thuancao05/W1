package pages;

import functions.comon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dashboard_page {
    private ChromeDriver chormeDriver;


    private By logo = By.xpath("//body/div[1]/a[1]/img[1]");
    private By btnUser = By.xpath("//header/div[2]/div[1]/a[1]");
    private By btnSigOut = By.xpath("//a[contains(text(),'Sign Out')]");
    private By lblWarning = By.xpath("//div[contains(text(),'This is only a demo store. You can browse and plac')]");


    public dashboard_page(ChromeDriver chormeDriver) {
        this.chormeDriver = chormeDriver;
    }
    public String getDashBoardPageTitle(){
        return chormeDriver.getTitle();
    }


    public WebElement LogoImg() {
        return chormeDriver.findElement(logo);
    }

    public WebElement UserButton() {
        return chormeDriver.findElement(btnUser);
    }

    public WebElement SigOutButton() {
        return chormeDriver.findElement(btnSigOut);
    }

    public WebElement WarningLabel() {
        return chormeDriver.findElement(lblWarning);
    }
}
