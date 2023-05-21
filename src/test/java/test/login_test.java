package test;

import core.ExcelUtils;
import core.baseTest;
import functions.dashboard_function;
import functions.login_function;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.login_page;

import java.io.IOException;

public class login_test extends baseTest {
    public login_function loginFunction;
    public dashboard_function dashboardFunction;


    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        String filePath = "src/login.xlsx";
        String sheetName = "login_sheet";
        int startCol = 0;
        int totalCols = 2;
        return ExcelUtils.getTableArray(filePath, sheetName, startCol, totalCols);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        try {
            loginFunction = new login_function(driver);
            dashboardFunction = new dashboard_function(driver);

            loginFunction.sigIn(username,password);

            Thread.sleep(1000);

            if (dashboardFunction.getDashBoardPageTitle().equals("Dashboard / Magento Admin")) {
                // Write to Excel or perform other actions for successful login
                ExcelUtils.writeAppendExcelFile("Test login with " + username + " and " + password, "Pass");
                dashboardFunction.SignOut();
            } else {
                if(password.equals("")){
                    Assert.assertEquals(loginFunction.getEmptyErrorMessage(), "This is a required field.");
                }
                else{
                    Assert.assertTrue(loginFunction.getLoginErrorMessage().contains("Invalid login or password."));
                }
                ExcelUtils.writeAppendExcelFile("Test login with " + username + " and " + password, "Fail");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    @Test
//    public void SignIn(){
//
//        loginFunction = new login_function(driver);
//
//        Object[][] dataFromExcel = excel.getTableArray("F:\\ThucTap\\W1\\src\\login.xlsx", "login_sheet", 0, 2 );
////        comon_fun.printDataFrom(dataFromExcel); //check data read from excel
//        try {
//            excel.writeHeadingExcelFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        for (int i = 0; i < dataFromExcel.length; i++){
//            String username = dataFromExcel[i][0].toString();
//            String password = dataFromExcel[i][1].toString();
//            String testCase = (i+1) + "- username: '" + username + "'- password: '" +password + "'";
//            try{
//                loginFunction.sigIn(username,password);
//                dashboardFunction = new dashboard_function(driver);
//                excel.writeAppendExcelFile(testCase, "Pass");
//                dashboardFunction.SignOut();
//            }catch (Exception e){
//                try {
//                    excel.writeAppendExcelFile(testCase, "Fail");
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        }
//    }

}
