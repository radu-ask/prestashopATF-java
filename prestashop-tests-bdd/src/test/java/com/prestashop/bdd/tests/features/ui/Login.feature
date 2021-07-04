Feature: Application login

 Scenario: User can access login page
   Given User is on HomePage
   When User clicks on Sign In button
   Then LoginPage is displayed