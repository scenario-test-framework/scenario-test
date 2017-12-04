package scenario.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class SwaggerEditorTest {
    @BeforeClass
    public static void beforeClass() {

        Configuration.browser = WebDriverRunner.CHROME;

        //Configuration.browser = WebDriverRunner.GECKO;
        //System.setProperty("webdriver.gecko.driver","d:/geckodriver.exe");
    }

}
