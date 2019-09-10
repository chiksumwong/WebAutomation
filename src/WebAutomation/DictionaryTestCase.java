package WebAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class DictionaryTestCase {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testDictionaryTestCase() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/zht/%E8%A9%9E%E5%85%B8/%E8%8B%B1%E8%AA%9E-%E6%BC%A2%E8%AA%9E-%E7%B9%81%E9%AB%94/");
        driver.findElement(By.id("cdo-search-input")).sendKeys("sky");
        driver.findElement(By.xpath("//*[@id=\"cdo-search-form\"]/div[1]/span/button[1]")).click();
        String type = driver.findElement(By.xpath("//*[@id=\"entryContent\"]/div[2]/div/div[3]/div/div/div/div[1]/div/span[2]/span[1]")).getText();
        String engMean = driver.findElement(By.xpath("//*/div[1]/div[1]/p")).getText();
        String chinMean = driver.findElement(By.xpath("//*[@id=\"english-chinese-traditional-1-1-1\"]/div/div[1]/span/span")).getText();
        System.out.println(type);
        System.out.println(engMean);
        System.out.println(chinMean);
//        Thread.sleep(24000);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        System.exit(0);
    }
}
