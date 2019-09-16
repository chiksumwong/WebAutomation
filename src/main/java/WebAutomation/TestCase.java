package WebAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {

    protected WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

}
