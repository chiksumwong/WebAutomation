package DictionaryCrawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.LinkedList;

import static java.lang.Thread.sleep;

public class DictionaryCrawlerTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDriver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/WebDriver/geckodriver.exe");
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @Test
    public void testDictionaryCrawler() throws IOException {
        FileReader fr = new FileReader("src/main/resources/InputFiles/InputFile1.txt");
        BufferedReader br = new BufferedReader(fr);

        LinkedList<String> words = new LinkedList<String>();
        String line;
        while((line = br.readLine()) != null)
        {
            line = line.trim();
            if (!line.equals("")) // don't write out blank lines
            {
                words.add(line);
            }
        }
        fr.close();

        System.out.println(words);

            for (int i=0; i<words.size(); i++){
                System.out.print(words.get(i));
                try {
                    driver.get("https://dictionary.cambridge.org/zht/%E8%A9%9E%E5%85%B8/");
                    //Search
                    driver.findElement(By.id("searchword")).sendKeys(words.get(i));
                    driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/form/div[1]/div[3]/span/button[2]")).click();
                    sleep(1000);

                    String type = driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/div[4]/div/div/div/div[2]/div[2]/span")).getText();
                    String engMean = driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/div[4]/div/div/div/div[3]/div[1]/div[2]/div[1]/div[2]/div")).getText();
                    String chinMean = driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[2]/div[4]/div/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/span")).getText();

    //            System.out.println(words.get(i));
    //            System.out.println(type);
    //            System.out.println(engMean);
    //            System.out.println(chinMean);

                    System.out.println(": [" + type + "] " + engMean + ", " + chinMean);

                    driver.navigate().back();
                }catch (Exception e){
                    System.out.println("");
                }
            }


    }

}
