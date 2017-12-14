package scenario.test;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public abstract class PageObj {

    public PageObj() {
        super();
    }

    /**
     * @param label
     * @throws Exception
     */
    public void screenshot(String label) throws Exception {
        Screenshot shot = new AShot()
                          .shootingStrategy(ShootingStrategies.viewportPasting(100))
                          .takeScreenshot(WebDriverRunner.getWebDriver());
        File f = new File("build/reports/tests/scenario/test/" + label + "_" + this.getClass().getSimpleName() + ".png") ;
        f.mkdirs();
        ImageIO.write(shot.getImage(), "png",f);
    }

    public void _elementScreenshot(String elementCss, String label) throws Exception {
        // FIXED AShotだと、以下エラー。デフォルトjqueryを使うようなので、CoordsProviderの指定が必要
        // 指定しても、windows版 chromeではちゃんと取れない。docker上ではok
        // また、全体スクリーンショットの場合、指定すると全画面のスクリーンショットが取れない
        // org.openqa.selenium.WebDriverException: unknown error: $ is not defined
        // => https://github.com/yandex-qatools/ashot/issues/68
        // use aShot.coordsProvider(new WebDriverCoordsProvider()) if you don't have jQuery on your page.
        // WebDriverCoordsProvider not uses jQuery for position calculating.
        Screenshot shot = new AShot().coordsProvider(new WebDriverCoordsProvider())
                                      .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(WebDriverRunner.getWebDriver(),
                                By.cssSelector(elementCss).findElement(WebDriverRunner.getWebDriver()));
        BufferedImage image = shot.getImage();

        File file = new File("build/reports/tests/scenario/test/" + label + "_" + this.getClass().getSimpleName()  + ".png") ;
        file.mkdirs();
        ImageIO.write(image, "png",file);
    }

    public void is(String title) {
        if (!Selenide.title().equals(title)) {
            throw new RuntimeException("No Such Title");
        }
    }

    public PageObj click(String label) {
//        PageObj page = this;
//        String elementCss = null;
//        if ("Sign in".equals(label)) {
//            elementCss = "#new_user > div.submit-container.move-submit-down > input";
//            page = new GitlabProjectPage();
//        } else if ("Sign in tab".equals(label)) {
//            elementCss = "body > div > div.container.navless-container > div > div.row > div.col-sm-5.pull-right.new-session-forms-container > div > ul > li:nth-child(1) > a";
//        } else if ("Register tab".equals(label)) {
//            elementCss = "body > div > div.container.navless-container > div > div.row > div.col-sm-5.pull-right.new-session-forms-container > div > ul > li:nth-child(2) > a";
//        } else {
//            throw new RuntimeException("No Such Element");
//        }
//        $(By.cssSelector(elementCss)).click();
//        return page;
        throw new RuntimeException("No Such Label");
    }

    public void input(String label, String value) {
//        if ("Username or email".equals(label)) {
//            $(By.cssSelector("#user_login")).setValue(value);
//        } else if ("Password".equals(label)) {
//            $(By.cssSelector("#user_password")).setValue(value);
//        } else {
//            throw new RuntimeException("No Such Label");
//        }
        throw new RuntimeException("No Such Label");
    }

    public void checkDialog(String title) {
// example
//        if ("Add User".equals(title)) {
//            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > span:nth-child(5) > div.swagger-ui > div > div > div > div > div > div.modal-ux-header > h3")).shouldHave(new Text(title));
//        } else {
//            throw new RuntimeException("No Such Title");
//        }
        throw new RuntimeException("No Such Title");
    }

    public void elementScreenshot(String elementName, String label) throws Exception{
// example
//        String elementCss = null;
//        if ("pane1".equals(elementName)) {
//            elementCss = "#swagger-editor > div > div:nth-child(2) > section > div > div.Pane.vertical.Pane1";
//        } else if ("pane2".equals(elementName)) {
//            elementCss = "#swagger-editor > div > div:nth-child(2) > section > div > div.Pane.vertical.Pane2";
//        } else {
//            throw new RuntimeException("No Such Element");
//        }
//        _elementScreenshot(elementCss, label);
        throw new RuntimeException("No Such Element");
    }


    /**
     * @param label
     */
    public PageObj searchAndClick(String label) {
        throw new RuntimeException("No Such Label");
    }

}