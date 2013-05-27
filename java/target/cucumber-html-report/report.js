$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('org/craftedsw/tictactoe/feature/tictactoe.feature');
formatter.feature({
  "id": "tic-tac-toe",
  "description": "",
  "name": "Tic Tac Toe",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "tic-tac-toe;staring-a-new-tic-tac-toe-game",
  "description": "",
  "name": "Staring a new Tic Tac Toe game",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "a Tic Tac Toe game",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "I start a new game",
  "keyword": "When ",
  "line": 6
});
formatter.step({
  "name": "I\u0027m presented with an empty board",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "TicTacToeSteps.a_Tic_Tac_Toe_game()"
});
formatter.result({
  "duration": 129159000,
  "status": "passed"
});
formatter.match({
  "location": "TicTacToeSteps.I_start_a_new_game()"
});
formatter.result({
  "duration": 81000,
  "status": "passed"
});
formatter.match({
  "location": "TicTacToeSteps.I_m_presented_with_an_empty_board()"
});
formatter.result({
  "duration": 6092000,
  "status": "passed"
});
formatter.scenario({
  "id": "tic-tac-toe;placing-marks",
  "description": "",
  "name": "Placing marks",
  "keyword": "Scenario",
  "line": 9,
  "type": "scenario"
});
formatter.step({
  "name": "I\u0027m informed it is my turn",
  "keyword": "Given ",
  "line": 11
});
formatter.step({
  "name": "I choose where my mark should appear",
  "keyword": "When ",
  "line": 12
});
formatter.step({
  "name": "my mark is displayed on the board",
  "keyword": "Then ",
  "line": 13
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});