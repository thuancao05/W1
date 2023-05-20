package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login_page {
    private WebDriver driver;
    private By logoImg = By.xpath("//header/a[1]/img[1]");
    private By txtUserName = By.xpath("//select[@id='username']");
    private By txtPassWord = By.xpath("//input[@id='login']");
    private By btnSigIn = By.xpath("//span[contains(text(),'Sign in')]");

    public login_page(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement LogoImg() {
        return driver.findElement(logoImg);
    }

    public WebElement TxtUserName() {
        return driver.findElement(txtUserName);
    }

    public WebElement TxtPassWord() {
        return driver.findElement(txtPassWord);
    }

    public WebElement BtnSigIn() {
        return driver.findElement(btnSigIn);
    }
}
