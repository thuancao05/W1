package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
/**
 * Hello world!
 *
 */
public class App 
{
    ChromeDriver chormeDriver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chormeDriver = new ChromeDriver();

    }

    @Test
    public void run(){
        System.out.println("Hello Test");
        chormeDriver.get("http://google.com/");
        sleep(5000);

    }

    @AfterMethod
    public void cleanUp(){
        chormeDriver.quit();
    }

    private void sleep(int time){
        try {
            Thread.sleep(time);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
