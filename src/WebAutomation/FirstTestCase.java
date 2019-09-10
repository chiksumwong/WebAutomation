package WebAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestCase {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUP(){

    }

    @Test
    public void testLogin(){

    }
}
