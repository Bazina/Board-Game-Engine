package GameEngines.Engines

import GameEngines.Drawers.Drawer
import GameEngines.GameEngine
import GameEngines.GamesControllers.Controller

class ChessEngine(drawer: Drawer, controller: Controller) extends GameEngine(drawer, controller) {
  override def movementCheck(): Unit = {
    drawer.helper(controller.x)
    if (controller.movementValidation())
      drawer.draw()
  }
}