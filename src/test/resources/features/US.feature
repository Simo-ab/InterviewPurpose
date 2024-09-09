Feature: As a job seeker, I want to search and find the career page of the Infinite Campus web site, and see a list of the current job openings.
@wip
  Scenario:A Google search shows the Infinite Campus career page as the first result
    Given Job seeker is on Google page
    When  Enter Infinite Campus Careers in the search bar and press Enter
    Then The first result should be the official Infinite Campus career page
    And the page should have one or more View Open Positions buttons
    Then Job seeker click on the first View Open Positions button
    Then New tab opens displaying current job openings

