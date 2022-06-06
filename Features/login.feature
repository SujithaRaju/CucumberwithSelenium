Feature:

  Scenario:
    Given login page URL
    And Enter username and password
    When Click on sigh in button
     And It will enter you to Home page
     Then sigh out
    And Close the page browser


  Scenario Outline:
    Given open the browser
    And admin type the login page url "http://tanchan-001-site3.btempurl.com/production/admin/"
    And admin enter the "<adminUsername>" and "<adminPassword>"
    When Click on sigh in button in login page
    And if admin credentials are correct
    Then It should entered into Home Page
    And Close the browser

    Examples:

      | adminUsername | adminPassword |
      | admin         | yesm          |
      | dmin2         | 45            |
