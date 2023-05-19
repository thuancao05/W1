package test;

import core.ExcelUtils;
import core.baseTest;
import functions.dashboard_function;
import functions.login_function;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.dashboard_page;
import pages.login_page;

import java.io.IOException;

public class login_test extends baseTest {
    private ChromeDriver chormeDriver;
    private ExcelUtils excel;

    public login_page loginPage;
    public dashboard_page dashBoardPage;
    public login_function loginFunction;
    public dashboard_function dashboardFunction;
    @BeforeClass
    public void setUp(){
        chormeDriver = getChormeDriver();
        excel = new ExcelUtils();
    }


    @Test
    public void SignIn(){

        loginFunction = new login_function(chormeDriver);

        Object[][] dataFromExcel = excel.getTableArray("F:\\ThucTap\\W1\\src\\login.xlsx", "login_sheet", 0, 2 );
//        comon_fun.printDataFrom(dataFromExcel); //check data read from excel
        try {
            excel.writeHeadingExcelFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < dataFromExcel.length; i++){
            String username = dataFromExcel[i][0].toString();
            String password = dataFromExcel[i][1].toString();
            String testCase = (i+1) + "- username: '" + username + "'- password: '" +password + "'";
            try{
                loginFunction.sigIn(username,password);
                dashboardFunction = new dashboard_function(chormeDriver);
                excel.writeAppendExcelFile(testCase, "Pass");
                dashboardFunction.SignOut();
            }catch (Exception e){
                try {
                    excel.writeAppendExcelFile(testCase, "Fail");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

}