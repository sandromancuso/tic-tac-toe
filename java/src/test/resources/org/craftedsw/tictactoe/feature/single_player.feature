Feature: Single player game

  Scenario: Game places mark automatically after player

    Given I start a single player Tic Tac Toe game
    When I place my marks on cells:
      | 1 | 2 | 3 |
    And the game places its marks on cells:
      | 4 | 5 |
    Then I win