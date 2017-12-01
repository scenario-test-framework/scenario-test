package scenario.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwaggerEditorSteps {

	SwaggerEditorPage editor;

	@Given("^\"([^\"]*)\" URLを開く$")
	public void URLを開く(String arg1) throws Throwable {
		editor = new SwaggerEditorPage(arg1);
	}

	@When("^\"([^\"]*)\" スクリーンショットをとる$")
	public void スクリーンショットをとる(String arg1) throws Throwable {
	    editor.screenshot(arg1);
	}

	@When("^\"([^\"]*)\" をクリックする$")
	public void をクリックする(String arg1) throws Throwable {
		editor.click(arg1);
	}

	@Then("^\"([^\"]*)\" ダイアログが表示される$")
	public void ダイアログが表示される(String arg1) throws Throwable {
		editor.checkDialog(arg1);
	}

	@When("^\"([^\"]*)\" に \"([^\"]*)\" を入力する$")
	public void に_を入力する(String arg1, String arg2) throws Throwable {
		editor.input(arg1,arg2);
	}


}
