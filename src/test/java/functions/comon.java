package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class comon {
    ChromeDriver chromeDriver;

    public comon(ChromeDriver chromeDriver1){
        this.chromeDriver = chromeDriver1;
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
        return chromeDriver.getTitle();
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
        chromeDriver.navigate().refresh();
    }
}
