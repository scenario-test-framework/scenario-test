package scenario.test.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

public class GitlabProjectDetailPage extends PageObj {

    public GitlabProjectDetailPage() {
    }

    /**
     * @param label
     */
    public PageObj click(String label) {
        PageObj page = this;
        String elementCss = null;
        if ("Remove project".equals(label)) {
            elementCss = "#content-body > div.container-fluid.container-limited > div.empty_wrapper > div > fieldset:nth-child(4) > div > a";
            page = new GitlabProjectPage();
        } else if ("Issues".equals(label)) {
            elementCss = "body > div.page-with-contextual-sidebar > div.nav-sidebar > div > ul > li:nth-child(2) > a";
            page = new GitlabProjectIssuePage();
        } else {
            throw new RuntimeException("No Such Label");
        }
        $(By.cssSelector(elementCss)).click();
        if ("Remove project".equals(label)) {
            // alertダイアログの場合、特別な処理が必要
            Selenide.switchTo().alert().accept();
        }

        return page;
    }

    /**
     * @param label
     * @param value
     */
    public PageObj input(String label, String value) {
        if ("Confirm input".equals(label)) {
            $(By.cssSelector("#confirm_name_input")).setValue(value);
        } else {
            throw new RuntimeException("No Such Label");
        }
        return this;
    }

}
