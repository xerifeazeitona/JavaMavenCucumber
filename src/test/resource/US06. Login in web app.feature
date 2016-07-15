Feature: Test login functionality in web app
  
  The conditions are broken down into THREE scenarios that already cover negative/exception conditions.
  
  The expected conditions are:
  1. Users may navigate without login (unregistered users).
  2. All pages must have a link to the login page except when user is already in.
  3. To login, users must go the login page.
  4. To login, registered users inform just their email and password.
  5. Unregistered users who try to login are redirect to the enroll page.
  6. Users who forgot their password request a new one through pop-up form.

  Scenario Outline: Test unregistered users can navigate as per conditions 1 and 2.
    Given I am in the web app
    When The sign in option is <enabled or disabled> 
    Then I click on menu <Link>
    And I check if I am on that <Title> page confirming my expectations according to my login status

    Examples: 
      | Link           | Title     | enabled or disabled |
      | index_link     | Home      | enabled             |
      | about_link     | About     | enabled             |
      | contact_link   | Contact   | enabled             |
      | index_link     | Home      | disabled             |
      | about_link     | About     | disabled            |
      | contact_link   | Contact   | disabled            |


#  Scenario Outline: Test login page functionality as per conditions 3, 4 and 5.
#	Given I am not logged in the web app
#	When I navigate to the login page
#	Then I check if I can inform <Email>
#	And I check if I can inform encrypted <Password>
#	And click on login button to be redirected to the <Title> page
#
#	Examples:
#	  | Email                 | Password | Title     |
#	  | admin@webapp.ca       | admin    | Home      |
#	  | johnsmith@email.com   | 12345    | Home      |
#	  | janedoe@something.com | 999      | Operation |
#
#
#
# Scenario: Test forgot password functionality as per condition 6.
#    Given I am in the login page and I dont know my password
#	When I click the fogot buttom
#	Then I should see a pop-up to reset my password