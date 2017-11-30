package scenario.test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public class selenideTest {

    @BeforeClass
    public static void beforeClass() {
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void googleru() {
        open("http://google.co.jp/");
        $("body").shouldHave(text("Google"));
    }
}
