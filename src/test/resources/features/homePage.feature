Feature: HomePage Feature

  @user7 @Homepage
  Scenario: Verify google homepage is working
    Given open ais homepage
    Then verify ais homepage


  @user8 @Homepage @test
  Scenario: Verify ais homepage title
    Given open ais homepage
    Then Verify title is "Google"

