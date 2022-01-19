package pageObject;

import functionLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(linkText = "Fire TV")
    WebElement fireTvSubMenuLink;
    @FindBy(linkText = "All Fire TV devices")
    WebElement allFireTvDevicesLink;
    @FindBy(linkText = "Fire TV Stick 4K with Alexa Voice Remote (in…")
    WebElement fireStick4kItemLink;

    public void goToHomePage() throws Exception {
        String homepage = readFromPropertyFile("url");
        driver.get(homepage);
        driver.manage().window().maximize();
    }

    public void clickAcceptCookies() {cookiesAcceptBtn.click();}

    public void navigateToAllFireTvDevices(){
        burgerBtnAll.click();  //click on burger 'All' button
        fireTvSubMenuLink.click();  //click on 'Fire TV' Sub-Menu 'Digital Content and Devices
        allFireTvDevicesLink.click(); //click on 'All Fire Devices' from the sub-menu 'Watch and Play'
        fireStick4kItemLink.click(); //Click on the 'Fire TV Stick 4K with Alexa Voice Remote' the actual product to be selected
    }




}
