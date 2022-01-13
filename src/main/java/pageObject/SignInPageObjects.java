package pageObject;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageObjects extends CommonFunctions {

    public SignInPageObjects(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement navigatingToSignInPage;

    @FindBy(id = "ap_email")
    WebElement signInTextFld;

    @FindBy(id="continue")
    WebElement continueBtn;

    @FindBy(id = "ap_password")
    WebElement passwordTextFld;

    @FindBy(id = "signInSubmit")
    WebElement sinInBtn;

    public void signIn(String email, String password)
    {
        navigatingToSignInPage.click();
        signInTextFld.sendKeys(email);
        continueBtn.click();
        passwordTextFld.sendKeys(password);
        sinInBtn.click();
    }


}
