package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.BasketObjects;
import pageObject.SignInPageObjects;
import pageObject.SignOutPageObjects;

import java.util.Set;

public class SearchSteps extends CommonFunctions {

    SignInPageObjects signInObj = new SignInPageObjects(driver);
    BasketObjects basket = new BasketObjects(driver);
    SignOutPageObjects signOutObj = new SignOutPageObjects(driver);

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() throws Exception{
        String homepage = readFromPropertyFile("url");
        driver.get(homepage);
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();
    }
    @When("I Sign in successfully")
    public void i_sign_in_successfully() throws Exception {
        String username = readFromPropertyFile("userName");
        String password = readFromPropertyFile("password");
        signInObj.signIn(username, password);
        waitWithTime(10);

    }
    @When("I click the Burger All Menu button")
    public void i_click_the_burger_all_menu_button() {
        driver.findElement(By.xpath("//span[@class='hm-icon-label']")).click();
    }

    @When("I navigate to and click on All Fire TV devices")
    public void i_navigate_to_and_click_on_all_fire_tv_devices() {
        driver.findElement(By.linkText("Fire TV")).click();
        driver.findElement(By.linkText("All Fire TV devices")).click();
    }
    @When("I click on the item with the name Fire TV Stick with Alexa voice remote")
    public void i_click_on_the_item_with_the_name_fire_tv_stick_with_alexa_voice_remote() {
        driver.findElement(By.linkText("Fire TV Stick 4K with Alexa Voice Remote (in…")).click();

    }
    @When("I add the item to the basket using add to basket button")
    public void i_add_the_item_to_the_basket_using_add_to_basket_button() {
        basket.addingItemToBasket();
        waitWithTime(2);
        WebDriverWait waiting = new WebDriverWait(driver,10);
        waiting.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"a-autoid-3\"]/span/input")))).click();


        //driver.switchTo().window(driver.getWindowHandles(1));
        //driver.switchTo().alert().dismiss();
    }
    @Then("The item should be successfully added to the basket")
    public void the_item_should_be_successfully_added_to_the_basket() throws Exception{
        driver.findElement(By.id("nav-cart-text-container")).click();
        waitWithTime(5);
        String expectedResult = readFromPropertyFile("expectedResult");
        String actualResult = driver.findElement(By.xpath("//span[@class='a-truncate-cut'][contains(text(),'Fire TV Stick 4K with Alexa Voice Remote (includes')]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println(actualResult);
        waitWithTime(5);
        signOutObj.signOut();
    }
}
