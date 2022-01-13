package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketObjects {
    public BasketObjects(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="add-to-cart-button")
    WebElement addToBasket;

    public void addingItemToBasket()
    {
        addToBasket.click();
    }
}

