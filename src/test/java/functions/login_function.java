package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pages.dashboard_page;
import pages.login_page;

public class login_function {
    private ChromeDriver chromeDriver;
    private login_page loginPage;
    private comon comonFun;


    public login_function(ChromeDriver driver){
        this.chromeDriver =driver;
    }

    public boolean verifyLoginPage(){
        loginPage = new login_page(chromeDriver);
        comonFun = new comon(chromeDriver);
        WebElement logo = loginPage.LogoImg();
        String actual = comonFun.getTitleElement(logo);
        String expected = "Magento Admin Panel";
        return  actual.equals(expected) && comonFun.verifyTitlePage("Magento Admin");
    }

    public void selectUserName(String username){
        WebElement userNameTxtBox = loginPage.TxtUserName();
        Select selectUsername = new Select(userNameTxtBox);
        selectUsername.selectByValue(username);
    }
    public void inputPassword(String pass){
        WebElement PassWordTxtBox = loginPage.TxtPassWord();
        PassWordTxtBox.clear();
        PassWordTxtBox.sendKeys(pass);
    }
    public void clickSigInButton(){
        WebElement btnSigin = loginPage.BtnSigIn();
        btnSigin.click();
    }
    public dashboard_page sigIn(String username, String password){
        Assert.assertTrue(verifyLoginPage(),"Verify Login Page Is Fail");
        if(verifyLoginPage()) System.out.println("Verified Login Page");
        selectUserName(username);
        inputPassword(password);
        clickSigInButton();
        return  new dashboard_page(chromeDriver);
    }
}
