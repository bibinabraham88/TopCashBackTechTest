package pageObject;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends CommonFunctions {

    public SignInPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    HomePage homePage = new HomePage(driver);

    @FindBy(id = "ap_email")
    WebElement signInTextFld;

    @FindBy(id="continue")
    WebElement continueBtn;

    @FindBy(id = "ap_password")
    WebElement passwordTextFld;

    @FindBy(id = "signInSubmit")
    WebElement sinInBtn;

    public void signIn(String username, String password) throws Exception
    {
        homePage.navigatingToSignInPage.click();
        signInTextFld.sendKeys(username);
        continueBtn.click();
        passwordTextFld.sendKeys(password);
        sinInBtn.click();
    }


}
