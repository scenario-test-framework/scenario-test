package scenario.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import scenario.test.page.GitlabCurrentPageControl;

/**
 * cucumber steps
 */
public class GitlabSteps {

    GitlabCurrentPageControl currentPage = new GitlabCurrentPageControl();

    @Given("^\"([^\"]*)\" URLを開く$")
    public void URLを開く(String arg1) throws Throwable {
        currentPage.openURL(arg1);
    }

    @Then("^\"([^\"]*)\" ページであること$")
    public void ページであること(String arg1) throws Throwable {
        currentPage.is(arg1);
    }

    @When("^\"([^\"]*)\" スクリーンショットをとる$")
    public void スクリーンショットをとる(String arg1) throws Throwable {
        currentPage.screenshot(arg1);
    }

    @When("^\"([^\"]*)\" 部品 \"([^\"]*)\" のスクリーンショットをとる$")
    public void 部品_のスクリーンショットをとる(String arg1, String arg2) throws Throwable {
        currentPage.elementScreenshot(arg1,arg2);
    }

    @When("^\"([^\"]*)\" をクリックする$")
    public void をクリックする(String arg1) throws Throwable {
        currentPage.click(arg1);
    }

    @Then("^\"([^\"]*)\" ダイアログが表示される$")
    public void ダイアログが表示される(String arg1) throws Throwable {
        currentPage.checkDialog(arg1);
    }

    @When("^\"([^\"]*)\" に \"([^\"]*)\" を入力する$")
    public void に_を入力する(String arg1, String arg2) throws Throwable {
        currentPage.input(arg1,arg2);
    }
    @When("^\"([^\"]*)\" に以下を入力する:$")
    public void に以下を入力する(String arg1, String arg2) throws Throwable {
        currentPage.input(arg1,arg2);
    }

    @When("^\"([^\"]*)\" リンクをクリックする$")
    public void リンクをクリックする(String arg1) throws Throwable {
        currentPage.searchAndClick(arg1);
    }


}
