package scenario.test.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

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
        } else if ("Edit".equals(label)) {
            elementCss = "#content-body > div.clearfix.detail-page-header > div.issuable-actions.js-issuable-actions > a.hidden-xs.hidden-sm.btn.btn-grouped.issuable-edit";
        } else if ("Save changes".equals(label)) {
            elementCss = "#content-body > div.issue-details.issuable-details > div.detail-page-description.content-block > div:nth-child(2) > form > div.prepend-top-default.append-bottom-default.clearfix > button.btn.btn-save.pull-left";
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
    public PageObj input(String label, String value) {
        if ("Title".equals(label)) {
            $(By.cssSelector("#issue_title")).setValue(value);
        } else if ("Description".equals(label)) {
            $(By.cssSelector("#issue_description")).setValue(value);
        } else if ("Due Date".equals(label)) {
            $(By.cssSelector("#issuable-due-date")).setValue(value);
        }
        // edit
        else if ("Edit title".equals(label)) {
            $(By.cssSelector("#issuable-title")).setValue(value);
        } else if ("Edit description".equals(label)) {
            $(By.cssSelector("#issue-description")).setValue(value);
        } else {
            throw new RuntimeException("No Such Label");
        }
        return this;
    }

    public PageObj searchAndClick(String label) {
        PageObj page = this;
        SelenideElement elm = $(By.linkText(label));
        elm.click();
        return page;
    }
}
