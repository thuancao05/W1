package functions;

import core.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class comon_function extends basePage {
    WebDriver driver;

    public comon_function(WebDriver driver){
        super(driver);
    }

    public void printDataFromExcel(Object[][] data){
        for (int i = 0; i < data.length; i++){
            for(int j = 0; j < 2; j++){
                System.out.println(data[i][j].toString());
            }
        }
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void click(By by){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
    public void senKeys(By by, String value){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(value);
    }

    public String getTitlePage(){
        return driver.getTitle();
    }

    public String getTitleElement(By by){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getAttribute("title");
    }
    public String getText(By by){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }
    public boolean verifyTitlePage(String titlePage){
        return getTitlePage().contains(titlePage);
    }
    public void refeshPage(){
        driver.navigate().refresh();
    }
}
