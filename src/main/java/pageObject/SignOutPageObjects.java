package pageObject;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignOutPageObjects extends CommonFunctions {

    public SignOutPageObjects(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[normalize-space()='Account & Lists']")
    WebElement accountsAndListsElement;

    @FindBy(linkText = "Sign Out")
    WebElement signOutBtn;

    public void signOut()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountsAndListsElement).build().perform();
        waitWithTime(3);
        signOutBtn.click();
        System.out.println("Signed Out Successfully");
    }
}
