# language: en
Feature: Rock, Paper, Scissors

  Scenario: Play Player vs. Computer
    Given: I start the program
    When: I choose the mode "Player vs. Computer"
    Then: I can execute step choosing <choice>
    | choice   |
    | ROCK     |
    | SCISSORS |
    | ROCK     |
    | ROCK     |
    | PAPER    |
    | SCISSORS |
    | SCISSORS |

