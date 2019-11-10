package WebAutomation.Scenario;

import WebAutomation.TestCase;
import org.testng.annotations.BeforeMethod;

public class Case_001 extends TestCase {
    @BeforeMethod
    public void setUp(){
        driver.get("");
    }
}
