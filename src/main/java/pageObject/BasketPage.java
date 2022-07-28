package pageObject;

import com.google.common.base.Verify;
import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class BasketPage extends CommonFunctions {
    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-button")
    WebElement addToBasket;
    @FindBy(xpath = "//*[@id=\"a-autoid-3\"]/span/input")
    WebElement suggestionWindowNoThanksBtn;
    @FindBy(id = "nav-cart-text-container")
    WebElement basketIconBtn;
    @FindBy(xpath = "//span[@class='a-truncate-cut'][contains(text(),'Fire TV Stick 4K with Alexa Voice Remote (includes')]")
    WebElement resultForFireStick4K;

    public void addingItemToBasket() {
        addToBasket.click();
    }

    public void clickOnNoThanksBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(suggestionWindowNoThanksBtn)).click();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void clickOnBasketIcon() {
        basketIconBtn.click();
    }

    public void assertSearchResult(String expectedResult) throws Exception {
        String actualResult = resultForFireStick4K.getText();
        //Assert.assertTrue(actualResult.contains(expectedResult));
        Verify.verify(actualResult.contains(expectedResult));

    }
}

