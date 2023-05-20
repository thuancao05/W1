package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class comon {
    WebDriver driver;

    public comon(WebDriver driver){
        this.driver = driver;
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

    public String getTitlePage(){
        return driver.getTitle();
    }

    public String getTitleElement(WebElement element){
        return element.getAttribute("title");
    }
    public String getText(WebElement element){
        return element.getText();
    }
    public boolean verifyTitlePage(String titlePage){
        return getTitlePage().contains(titlePage);
    }
    public void refeshPage(){
        driver.navigate().refresh();
    }
}
