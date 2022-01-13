Feature: Verify adding Fire TV 4k stick to basket
  As a user
  I should be able to add Fire TV 4K stick to basket

  @search
  Scenario: Verify adding Fire TV 4K stick to basket
    Given I am on the homepage
    When I Sign in successfully
    When I click the Burger All Menu button
    When I navigate to and click on All Fire TV devices
    When I click on the item with the name Fire TV Stick with Alexa voice remote
    When I add the item to the basket using add to basket button
    Then The item should be successfully added to the basket
