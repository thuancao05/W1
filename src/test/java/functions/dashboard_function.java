package functions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.dashboard_page;
import pages.login_page;

public class dashboard_function {

    private ChromeDriver chromeDriver;
    private dashboard_page dashboardPage;
    private comon comonFun;

    public dashboard_function(ChromeDriver driver){
        this.chromeDriver =driver;
    }

    public String getSigInPageTitle(){
        return chromeDriver.getTitle();
    }

    public boolean verifyLogoDashBoard(){
        String actual = comonFun.getTitleElement(dashboardPage.LogoImg());
        String expected = "Magento Admin Panel";

        return actual.equals(expected);
    }
    public boolean verifyLabelDashBoard(){
        dashboardPage = new dashboard_page(chromeDriver);
        comonFun = new comon(chromeDriver);
        String actual = comonFun.getText(dashboardPage.WarningLabel());
        String expected = "This is only a demo store. You can browse and place orders, but nothing will be processed.";
        return actual.equals(expected)  ;
    }

    public boolean verifyDashBoardPage(){
        return verifyLabelDashBoard() && verifyLogoDashBoard();
    }
    public void SignOut(){
        try {
            Assert.assertTrue(verifyDashBoardPage(),"Verify Dashboard Page is Fail");
            if(verifyDashBoardPage()) System.out.println("Verified DashBoard Page");

            dashboardPage.UserButton().click();
            comonFun.sleep(1000);
            dashboardPage.SigOutButton().click();
            comonFun.sleep(1000);


        }catch (Exception e){
            e.printStackTrace();
            comonFun.refeshPage();
            SignOut();
        }

    }
}
