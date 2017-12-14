package scenario.test;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

public class GitlabProjectPage extends PageObj {

    /**
     * @param url
     */
    public GitlabProjectPage() {
    }

    public PageObj click(String label) {
        PageObj page = this;
        String elementCss = null;
        if ("Create a project".equals(label)) {
            elementCss = "#content-body > div > div > div > div > div > div.blank-state-row > a:nth-child(1)";
        } else {
            throw new RuntimeException("No Such Label");
        }
        $(By.cssSelector(elementCss)).click();
        return page;
    }

}
