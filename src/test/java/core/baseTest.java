package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;


//file nay se khoi tao Browser va dong Driver
public class baseTest {
    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void initDriver(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.navigate().to("https://demo-m2.bird.eu/admin");
        //return chormeDriver;
    }

    @AfterClass
    public void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
