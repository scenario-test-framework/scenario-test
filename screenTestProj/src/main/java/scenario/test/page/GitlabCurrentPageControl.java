package scenario.test.page;

/**
 * current page control
 */
public class GitlabCurrentPageControl {

    PageObj currentPage;

    public void openURL(String arg1) throws Throwable {
        if (arg1.endsWith("/users/sign_in")) {
            currentPage = new GitlabLoginPage(arg1);
        } else {
            currentPage = new GitlabProjectPage(arg1);
         }
    }

    public void screenshot(String arg1) throws Throwable {
        currentPage.screenshot(arg1);
    }

    public void elementScreenshot(String arg1, String arg2) throws Throwable {
        currentPage.elementScreenshot(arg1,arg2);
    }

    public void is(String arg1) throws Throwable {
        currentPage = currentPage.is(arg1);
    }

    public void click(String arg1) throws Throwable {
        // window タイトル or urlをもとに現在ページを決定すべきか...
        currentPage = currentPage.click(arg1);
    }

    public void checkDialog(String arg1) throws Throwable {
        currentPage = currentPage.checkDialog(arg1);
    }

    public void input(String arg1, String arg2) throws Throwable {
        currentPage = currentPage.input(arg1,arg2);
    }

    public void searchAndClick(String arg1) throws Throwable {
        currentPage = currentPage.searchAndClick(arg1);
    }

}
