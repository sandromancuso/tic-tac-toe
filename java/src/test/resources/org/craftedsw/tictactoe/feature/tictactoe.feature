Feature: Tic Tac Toe

  Scenario: Placing marks

    Given a new Tic Tac Toe game starts
    When I place a mark on cell 3
    Then my mark is displayed on the board

  Scenario: Player One wins

    Given a new Tic Tac Toe game starts
    When players place marks on the following cells:
      | 1 | 4 | 2 | 5 | 3 |
    Then Player One wins
