package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


//file nay se khoi tao Browser va dong Driver
public class baseTest {
    private ChromeDriver chormeDriver;

    public ChromeDriver getChormeDriver(){
        return chormeDriver;
    }

    @BeforeClass
    public void initDriver(){
        WebDriverManager.chromedriver().setup();
        chormeDriver = new ChromeDriver();
        chormeDriver.navigate().to("https://demo-m2.bird.eu/admin");
        //return chormeDriver;
    }

    @AfterClass
    public void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        chormeDriver.quit();
    }

}
