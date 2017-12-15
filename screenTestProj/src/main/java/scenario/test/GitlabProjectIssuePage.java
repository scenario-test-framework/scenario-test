package scenario.test;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

public class GitlabProjectIssuePage extends PageObj {

    public GitlabProjectIssuePage() {
    }

    /**
     * @param label
     */
    public PageObj click(String label) {
        PageObj page = this;
        String elementCss = null;

        if ("Create Issue".equals(label)) {
            elementCss = "#new_issue_link";
        } else if ("Submit issue".equals(label)) {
                elementCss = "#new_issue > div.footer-block.row-content-block > span";
        } else {
            throw new RuntimeException("No Such Label");
        }
        $(By.cssSelector(elementCss)).click();
        return page;
    }

    /**
     * @param label
     * @param value
     */
    public void input(String label, String value) {
        if ("Title".equals(label)) {
            $(By.cssSelector("#issue_title")).setValue(value);
        } else if ("Description".equals(label)) {
            $(By.cssSelector("#issue_description")).setValue(value);
        } else {
            throw new RuntimeException("No Such Label");
        }
    }

}
