package scenario.test.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

public class GitlabLoginPage extends PageObj {

    /**
     * @param url
     */
    public GitlabLoginPage(String url) {
        open(url);
    }

    /**
     * @param label
     */
    public PageObj click(String label) {
        PageObj page = this;
        String elementCss = null;
        if ("Sign in".equals(label)) {
            elementCss = "#new_user > div.submit-container.move-submit-down > input";
            page = new GitlabProjectPage();
        } else if ("Sign in tab".equals(label)) {
            elementCss = "body > div > div.container.navless-container > div > div.row > div.col-sm-5.pull-right.new-session-forms-container > div > ul > li:nth-child(1) > a";
        } else if ("Register tab".equals(label)) {
            elementCss = "body > div > div.container.navless-container > div > div.row > div.col-sm-5.pull-right.new-session-forms-container > div > ul > li:nth-child(2) > a";
        } else {
            throw new RuntimeException("No Such Element");
        }
        $(By.cssSelector(elementCss)).click();
        return page;
    }

    /**
     * @param label
     * @param value
     */
    public PageObj input(String label, String value) {
        if ("Username or email".equals(label)) {
            $(By.cssSelector("#user_login")).setValue(value);
        } else if ("Password".equals(label)) {
            $(By.cssSelector("#user_password")).setValue(value);
        } else {
            throw new RuntimeException("No Such Label");
        }
        return this;
    }

}
