package scenario.test.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import scenario.test.page.GitlabProjectDetailPage;

public class GitlabProjectPage extends PageObj {

    public GitlabProjectPage() {
    }
    /**
     * @param url
     */
    public GitlabProjectPage(String url) {
        open(url);
    }

    /**
     * @param label
     */
    public PageObj click(String label) {
        PageObj page = this;
        String elementCss = null;
        if ("Create a project".equals(label)) {
            elementCss = "#content-body > div > div > div > div > div > div.blank-state-row > a:nth-child(1)";
        } else if ("Create project".equals(label)) {
            elementCss = "#new_project > input.btn.btn-create.project-submit";
            page = new GitlabProjectDetailPage();
        } else if ("Private".equals(label)) {
            elementCss = "#new_project > div.form-group.visibility-level-setting > div > div > div:nth-child(1) > label > div.option-title";
        } else if ("Internal".equals(label)) {
            elementCss = "#new_project > div.form-group.visibility-level-setting > div > div > div:nth-child(2) > label > div.option-title";
        } else if ("Public".equals(label)) {
            elementCss = "#new_project > div.form-group.visibility-level-setting > div > div > div:nth-child(3) > label > div.option-title";
        } else {
            throw new RuntimeException("No Such Label");
        }
        $(By.cssSelector(elementCss)).click();
        return page;
    }

    /**
     * @param label
     */
    public PageObj searchAndClick(String label) {
        PageObj page = this;
        SelenideElement elm = $(By.linkText(label));
        String attr =elm.getAttribute("class");
        elm.click();
        if ("project".equals(attr)) {
            page = new GitlabProjectDetailPage();
        }
        return page;
    }

    /**
     * @param label
     * @param value
     */
    public void input(String label, String value) {
        if ("Project name".equals(label)) {
            $(By.cssSelector("#project_path")).setValue(value);
        } else if ("Project description".equals(label)) {
            $(By.cssSelector("#project_description")).setValue(value);
        } else {
            throw new RuntimeException("No Such Label");
        }
    }

}
