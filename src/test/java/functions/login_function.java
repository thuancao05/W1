package functions;

import core.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.dashboard_page;
import pages.login_page;

public class login_function extends basePage {
    private login_page loginPage = new login_page();;
    private comon_function comonFunction = new comon_function(driver);



    public login_function(WebDriver driver){
        super(driver);
    }

    public boolean verifyLoginPage(){
        comonFunction.click(loginPage.logoImg);
        String actual = comonFunction.getTitleElement(loginPage.logoImg);
        String expected = "Magento Admin Panel";
        return  actual.equals(expected);
    }

    public void selectUserName(String username){
        WebElement userNameTxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.txtUserName));

        Select selectUsername = new Select(userNameTxtBox);
        selectUsername.selectByValue(username);
    }
    public void inputPassword(String pass){
        comonFunction.senKeys(loginPage.txtPassWord, pass);
    }
    public void clickSigInButton(){
        comonFunction.click(loginPage.btnSigIn);
    }
    public String getLoginErrorMessage() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.errorMessages));
        return element.getText();
    }
    public String getEmptyErrorMessage() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.emptyPassword));
        return element.getText();
    }

    public dashboard_page sigIn(String username, String password){
        Assert.assertTrue(verifyLoginPage(),"Verify Login Page Is Fail");
        if(verifyLoginPage()) System.out.println("Verified Login Page");
        selectUserName(username);
        inputPassword(password);
        clickSigInButton();
        return  new dashboard_page();
    }
}
