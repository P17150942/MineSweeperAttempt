package control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import model.mainmenu.MainMenu;
import model.minesweeper.MineField;
import model.minesweeper.MineState;
import model.minesweeper.MineSweeperGame;
import view.mainmenu.MainMenuRootPane;
import view.minesweeper.MineSweepCanvas;
import view.minesweeper.MineSweeperRootPane;

public class MineSweepController implements Controller {

	private MineSweeperRootPane view;
	private MineSweepCanvas mineSweepCanvas;
	private MineSweeperGame model;

	public MineSweepController(MineSweeperRootPane view, MineSweeperGame model) {
		
		this.view = view;
		this.model = model;
		this.mineSweepCanvas = view.getMineSweepCanvas();
		
		this.mineSweepCanvas.updateMineSweepCanvas(model.getMineField());
		
		this.mineSweepCanvas.setCanvasClick(new MineFieldHandler());
		this.view.addResetHandler(new ResetHandler());
	}
	
	private class ResetHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			model.setGameOver(false);
			model.setMinefield(new MineField(model.getMineField().getXSize(), model.getMineField().getYSize()));
			view.getMineSweepCanvas().updateMineSweepCanvas(model.getMineField());
			
			
			
		}
		
	}
	private class MineFieldHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
		
			if (!model.getGameOver()) {
				double blockWidth = mineSweepCanvas.getCanvas().getWidth()/model.getMineField().getXSize();
				double blockHeight = mineSweepCanvas.getCanvas().getWidth()/model.getMineField().getYSize();
				int x = (int) (event.getX()/blockWidth);
				int y = (int) (event.getY()/blockHeight);

				if (model.getMineField().tileExists(x, y)) {
					
					model.getMineField().activateAt(x,y);
					mineSweepCanvas.updateMineSweepCanvas(model.getMineField());
					if (model.getMineField().getAt(x, y).getState() == MineState.EXPLODED){
						model.setGameOver(true);
					} 
				}
			}
			


		}
		
	}
	
	@Override
	public Parent getView() {
		return this.view;
	}

}
