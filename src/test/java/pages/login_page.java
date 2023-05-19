package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_page {
    private ChromeDriver chormeDriver;
    private By logoImg = By.xpath("//header/a[1]/img[1]");
    private By txtUserName = By.xpath("//select[@id='username']");
    private By txtPassWord = By.xpath("//input[@id='login']");
    private By btnSigIn = By.xpath("//span[contains(text(),'Sign in')]");

    public login_page(ChromeDriver chormeDriver) {
        this.chormeDriver = chormeDriver;
    }
    public WebElement LogoImg() {
        return chormeDriver.findElement(logoImg);
    }

    public WebElement TxtUserName() {
        return chormeDriver.findElement(txtUserName);
    }

    public WebElement TxtPassWord() {
        return chormeDriver.findElement(txtPassWord);
    }

    public WebElement BtnSigIn() {
        return chormeDriver.findElement(btnSigIn);
    }
}
