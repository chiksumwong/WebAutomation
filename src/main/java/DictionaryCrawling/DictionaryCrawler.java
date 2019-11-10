package DictionaryCrawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DictionaryCrawler {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testDictionaryTestCase() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/zht/%E8%A9%9E%E5%85%B8/");
        //Search
        driver.findElement(By.id("searchword")).sendKeys("apple");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/form/div[1]/div[3]/span/button[2]")).click();

        String type = driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/div[4]/div/div/div/div[2]/div[2]/span")).getText();
        String engMean = driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/div[4]/div/div/div/div[3]/div[1]/div[2]/div[1]/div[2]/div")).getText();
        String chinMean = driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/div[4]/div/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/span")).getText();

        System.out.println(type);
        System.out.println(engMean);
        System.out.println(chinMean);

        driver.navigate().back();
//        Thread.sleep(24000);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        System.exit(0);
    }
}
