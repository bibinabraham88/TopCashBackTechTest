package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObject.*;

public class SearchSteps extends CommonFunctions {

    HomePage home = new HomePage(driver);
    SignInPage signInObj = new SignInPage(driver);
    BasketPage basket = new BasketPage(driver);
    SignOutPage signOutObj = new SignOutPage(driver);

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() throws  Exception{
        home.goToHomePage();
        home.clickAcceptCookies();
    }

    @When("I Sign in successfully")
    public void i_sign_in_successfully() throws Exception {
        signInObj.signIn();
        waitWithTime(10);
    }

    @When("I click on the burger All menu and navigate to Fire TV Stick with Alexa voice remote")
    public void i_click_on_the_burger_All_menu_and_navigate_to_Fire_TV_Stick_with_Alexa_voice_remote() {
        home.navigateToAllFireTvDevices();
    }

    @When("I add the item to the basket using add to basket button")
    public void i_add_the_item_to_the_basket_using_add_to_basket_button() {
        basket.addingItemToBasket();
        waitWithTime(2);
        basket.clickOnNoThanksBtn();
    }

    @Then("The item should be successfully added to the basket")
    public void the_item_should_be_successfully_added_to_the_basket() throws Exception{
        basket.clickOnBasketIcon();
        waitWithTime(2);
        basket.assertSearchResult();
        waitWithTime(5);
    }

    @Then("I should be able to sign out successfully")
    public void i_should_be_able_to_sign_out_successfully(){
        signOutObj.signOut();
        waitWithTime(3);
    }


}
