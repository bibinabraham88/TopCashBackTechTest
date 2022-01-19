package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class AddToBasket extends CommonFunctions {

    HomePage home = new HomePage(driver);
    SignInPage signInObj = new SignInPage(driver);
    BasketPage basket = new BasketPage(driver);
    SignOutPage signOutObj = new SignOutPage(driver);

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() throws  Exception{
        home.goToHomePage();
        home.clickAcceptCookies();
    }

    @When("I Sign in successfully using username {string} and password {string}")
    public void i_sign_in_successfully(String username, String password) throws Exception {
        signInObj.signIn(username, password);
    }

    @When("I click on the burger All menu and navigate to Fire TV Stick with Alexa voice remote")
    public void i_click_on_the_burger_All_menu_and_navigate_to_Fire_TV_Stick_with_Alexa_voice_remote() {
        home.navigateToAllFireTvDevices();
    }

    @When("I add the item to the basket using add to basket button")
    public void i_add_the_item_to_the_basket_using_add_to_basket_button() {
        basket.addingItemToBasket();
        basket.clickOnNoThanksBtn();
    }

    @Then("The {string} item should be successfully added to the basket")
    public void the_item_should_be_successfully_added_to_the_basket(String expectedResult) throws Exception{
        basket.clickOnBasketIcon();
        waitWithTime(1);
        basket.assertSearchResult(expectedResult);
    }

    @Then("I should be able to sign out successfully")
    public void i_should_be_able_to_sign_out_successfully(){
        signOutObj.signOut();
        waitWithTime(3);
    }
}
