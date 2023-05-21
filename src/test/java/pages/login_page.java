package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login_page {
//    private WebDriver driver;
    public By logoImg = By.xpath("//header/a[1]/img[1]");
    public By txtUserName = By.xpath("//select[@id='username']");
    public By txtPassWord = By.xpath("//input[@id='login']");
    public By btnSigIn = By.xpath("//span[contains(text(),'Sign in')]");
    public By errorMessages = By.xpath("//div[@data-ui-id='messages-message-error']");
    public By emptyPassword = By.xpath("//label[@id='login-error']");


//
//    public login_page(WebDriver driver) {
//        this.driver = driver;
//    }
//    public WebElement LogoImg() {
//        return driver.findElement(logoImg);
//    }
//
//    public WebElement TxtUserName() {
//        return driver.findElement(txtUserName);
//    }
//
//    public WebElement TxtPassWord() {
//        return driver.findElement(txtPassWord);
//    }
//
//    public WebElement BtnSigIn() {
//        return driver.findElement(btnSigIn);
//    }
//    public WebElement ErrorLabel() {return  driver.findElement(errorMessages);}
//    public WebElement EmptyPassWord() {return  driver.findElement(emptyPassword);}
}
