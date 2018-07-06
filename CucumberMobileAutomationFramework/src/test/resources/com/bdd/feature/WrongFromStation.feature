
@LaunchApp
Feature: Wrong From Station
  I want to enter wrong staion and check it is in unavailable

  Scenario Outline: Enter wrong Station
    Given Enter "<FromStation>" Station
    And "<FromStation>" is unavailable
    
    Examples: From Station
    |FromStation|
    |TestStation|
    
    
    
    
