package scenario.test;

import static com.codeborne.selenide.Selenide.*;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Text;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SwaggerEditorPage {

    public SwaggerEditorPage(String url) {
        open(url);
    }

    public void screenshot(String arg1) throws Exception {
        Screenshot shot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(WebDriverRunner.getWebDriver());
        File f = new File("build/reports/tests/scenario/test/" + SwaggerEditorPage.class.getSimpleName() + "_" + arg1 + ".png") ;
        f.mkdirs();
        ImageIO.write(shot.getImage(), "png",f);
    }

    public void click(String arg1) {
        if ("User:".equals(arg1)) {
            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > div:nth-child(4) > span")).click();
        } else if ("Add User".equals(arg1)) {
            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > div:nth-child(4) > div > ul > li:nth-child(1) > button")).click();
        } else if ("Create".equals(arg1)) {
            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > span:nth-child(5) > div.swagger-ui > div > div > div > div > div > div.modal-ux-content > div.topbar-popup-button-area > button")).click();
        } else if ("Change User".equals(arg1)) {
            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > div:nth-child(4) > div > ul > li:nth-child(3) > button")).click();
        } else {
            throw new RuntimeException("No Such Label");
        }
    }


    public void input(String arg1, String arg2) {
        if ("id:".equals(arg1)) {
            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > span:nth-child(5) > div.swagger-ui > div > div > div > div > div > div.modal-ux-content > div.parameters-col_description > div:nth-child(2) > section > input[type=\"text\"]")).setValue(arg2);
        } else if ("email:".equals(arg1)) {
            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > span:nth-child(5) > div.swagger-ui > div > div > div > div > div > div.modal-ux-content > div.parameters-col_description > div:nth-child(3) > section > input[type=\"text\"]")).setValue(arg2);
        } else {
            throw new RuntimeException("No Such Label");
        }
    }

    public void checkDialog(String arg1) {
        if ("Add User".equals(arg1)) {
            $(By.cssSelector("#swagger-editor > div > div:nth-child(1) > div.topbar > div > div.topbar-specmgr-info > span:nth-child(5) > div.swagger-ui > div > div > div > div > div > div.modal-ux-header > h3")).shouldHave(new Text(arg1));
        } else {
            throw new RuntimeException("No Such Label");
        }
    }

}
