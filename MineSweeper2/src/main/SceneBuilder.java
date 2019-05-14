package main;

import control.Controller;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class SceneBuilder {
	private static SceneBuilder instance = null;
	private Stage stage;
	private Controller controller;
	
	private SceneBuilder(Stage stage) {
		this.stage = stage;
		stage.setTitle("MineSweeper");		
		stage.setMinWidth(530); 
		stage.setMinHeight(500);
	}
	public static SceneBuilder getInstance(Stage stage) 
    { 
        if (instance == null) 
        	instance = new SceneBuilder(stage); 
  
        return instance; 
    } 
	
	
	public static SceneBuilder getInstance() 
    { 
        return instance; 
    }
	
	public void setScene(Controller controller) {
		this.controller = controller;
		System.out.println(controller.getView());
		Scene scene = new Scene(controller.getView());
		stage.setScene(scene);
		stage.show();
	}
	
	public void setSceneRoot(Controller controller) {
		this.controller = controller;
		
		stage.getScene().setRoot(controller.getView());
		//stage.setScene(scene);
		
	}
}
