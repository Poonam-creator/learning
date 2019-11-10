package utils;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C://Users//hp//Downloads//chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.currys.co.uk");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    public void teardown(){
        driver.quit();
    }

}
