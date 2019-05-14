package main;

import control.Controller;
import control.MainMenuController;
//import controller.GameController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.mainmenu.MainMenu;
import model.minesweeper.MineSweeperGame;
import view.mainmenu.MainMenuRootPane;
import main.SceneBuilder;


public class ApplicationLoader extends Application {
//private Parent view;
	private Controller controller;
	@Override
	public void init() throws Exception {
		MainMenuRootPane view = new MainMenuRootPane();
		MainMenu model = new MainMenu();
	
		this.controller = new MainMenuController(view, model);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		SceneBuilder.getInstance(stage).setScene(this.controller);
		

		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	

}
