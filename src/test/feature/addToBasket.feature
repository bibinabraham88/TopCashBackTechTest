Feature: Verify adding Fire TV 4k stick to basket
  As a user
  I should be able to add Fire TV 4K stick to basket

  @search
  Scenario: Verify adding Fire TV 4K stick to basket
    Given I am on the homepage
    When I Sign in successfully using username "project.task@yahoo.com" and password "Project@123"
    When I click on the burger All menu and navigate to Fire TV Stick with Alexa voice remote
    When I add the item to the basket using add to basket button
    Then The "Fire TV Stick 4K with Alexa Voice Remote" item should be successfully added to the basket
    Then I should be able to sign out successfully
