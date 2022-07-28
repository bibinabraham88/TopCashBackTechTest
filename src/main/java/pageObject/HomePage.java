package pageObject;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends CommonFunctions {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "sp-cc-accept")
    WebElement cookiesAcceptBtn;
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement navigatingToSignInPage;
    @FindBy(xpath = "//span[@class='hm-icon-label']")
    WebElement burgerBtnAll;
    @FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[1]/li[11]/a/div")
    WebElement fireTvSubMenuLink;
    @FindBy(linkText = "All Fire TV devices")
    WebElement allFireTvDevicesLink;
    @FindBy(linkText = "Fire TV Stick 4K with Alexa Voice Remote (in…")
    WebElement fireStick4kItemLink;
    @FindBy(xpath = "//div[@id='nav-xshop']/a[3]")
    WebElement giftIdeaBtn;
    @FindBy(xpath = "//div[@class='connections']/div/div/a[2]")
    WebElement menBtnInsideGiftIdeas;

    public void goToHomePage() throws Exception {
        String homepage = readFromPropertyFile("url");
        driver.get(homepage);
        driver.manage().window().maximize();
    }

    public void clickAcceptCookies() {cookiesAcceptBtn.click();}

    public void navigateToAllFireTvDevices(){
        waitWithTime(2);
        burgerBtnAll.click();  //click on burger 'All' button
        waitWithTime(1);
        fireTvSubMenuLink.click();  //click on 'Fire TV' Sub-Menu 'Digital Content and Devices
        allFireTvDevicesLink.click(); //click on 'All Fire Devices' from the sub-menu 'Watch and Play'
        fireStick4kItemLink.click(); //Click on the 'Fire TV Stick 4K with Alexa Voice Remote' the actual product to be selected
    }

    public void navigateToGiftIdeas(){
        giftIdeaBtn.click();
        WebDriverWait wait  = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(menBtnInsideGiftIdeas)).click();
    }



}
