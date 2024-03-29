package Controller

import GameEngines.Engines.{CheckersEngine, ChessEngine, Connect4Engine, XOEngine}
import javafx.scene.control.Button
import javafx.scene.layout.{AnchorPane, HBox, StackPane}
import scalafxml.core.macros.sfxml


@sfxml
class MainController(var gamePane: StackPane,
                     val menuPane: AnchorPane,
                     val returnButton: Button,
                     val promButs: HBox) {
  def XOStart(): Unit = {
    gameMode(true)
    val gameEngine = new XOEngine
    gameEngine.startGame(gamePane)
  }

  def ChessStart(): Unit = {
    gameMode(true)
    val gameEngine = new ChessEngine(promButs)
    gameEngine.startGame(gamePane)
  }

  def gameMode(boolean: Boolean): Unit = {
    promButs.setVisible(false)
    gamePane.getChildren.clear()
    menuPane.setVisible(!boolean)
    returnButton.setVisible(boolean)
    gamePane.setVisible(boolean)
  }

  def Connect4Start(): Unit = {
    gameMode(true)
    val gameEngine = new Connect4Engine
    gameEngine.startGame(gamePane)
  }

  def CheckersStart(): Unit = {
    gameMode(true)
    val gameEngine = new CheckersEngine
    gameEngine.startGame(gamePane)
  }

  def returnMenu(): Unit = {
    gameMode(false)
  }

}
