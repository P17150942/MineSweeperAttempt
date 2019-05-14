package control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import main.SceneBuilder;
import model.mainmenu.MainMenu;
import model.minesweeper.MineField;
import model.minesweeper.MineSweeperGame;
import view.mainmenu.GridSizeSelector;
import view.mainmenu.MainMenuRootPane;
import view.minesweeper.MineSweeperRootPane;

public class MainMenuController implements Controller {
	private GridSizeSelector gridSelector;
	private MainMenuRootPane view;
	

	public MainMenuController(MainMenuRootPane view, MainMenu model) {
		this.gridSelector = view.getGridSelector();
		this.view = view;
		setHandlers();
	}

	
	private void setHandlers() {
		this.gridSelector.setPlayButtonHandler(new PlayHandler());
	}

	public Parent getView() {
		return this.view;
	}
	
	private class PlayHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			MineField minefield = new MineField(gridSelector.getXSize(), gridSelector.getYSize());
			MineSweeperGame model = new MineSweeperGame(minefield);
			MineSweeperRootPane view = new MineSweeperRootPane();
	
			SceneBuilder.getInstance().setSceneRoot(new MineSweepController(view, model));
			
		}
		
	}
}
