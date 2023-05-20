package functions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.dashboard_page;

public class dashboard_function {

    private WebDriver driver;
    private dashboard_page dashboardPage;
    private comon comonFun;

    public dashboard_function(WebDriver driver){
        this.driver =driver;
    }

    public String getSigInPageTitle(){
        return driver.getTitle();
    }

    public boolean verifyLogoDashBoard(){
        String actual = comonFun.getTitleElement(dashboardPage.LogoImg());
        String expected = "Magento Admin Panel";

        return actual.equals(expected);
    }
    public boolean verifyLabelDashBoard(){
        dashboardPage = new dashboard_page(driver);
        comonFun = new comon(driver);
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
