package functions;

import core.basePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.dashboard_page;

public class dashboard_function  extends basePage {

    private dashboard_page dashboardPage;
    private comon_function comonFunctionFun = new comon_function(driver);;

    public dashboard_function(WebDriver driver){
        super(driver);
    }

    public String getDashBoardPageTitle(){
        return super.driver.getTitle();
    }

    public boolean verifyLogoDashBoard(){
        String actual =  comonFunctionFun.getTitleElement(dashboardPage.logo);
        String expected = "Magento Admin Panel";

        return actual.equals(expected);
    }
    public boolean verifyLabelDashBoard(){
        dashboardPage = new dashboard_page();
        String actual = comonFunctionFun.getText(dashboardPage.lblWarning);
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

            comonFunctionFun.click(dashboardPage.btnUser);
            comonFunctionFun.sleep(1000);
            comonFunctionFun.click(dashboardPage.btnSigOut);
            comonFunctionFun.sleep(1000);


        }catch (Exception e){
            e.printStackTrace();
            comonFunctionFun.refeshPage();  //bat loi load trang
            SignOut();
        }

    }
}
