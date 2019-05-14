package view.minesweeper;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.minesweeper.MineField;

public class MineSweeperRootPane extends VBox {
	

	private MineSweepCanvas mineSweepCanvas;
	private Button reset;

	public MineSweeperRootPane()  {
		this.mineSweepCanvas = new MineSweepCanvas();
		this.mineSweepCanvas.setAlignment(Pos.CENTER);
		this.reset = new Button("Reset");
		this.reset.setAlignment(Pos.CENTER);
		this.getChildren().addAll(this.mineSweepCanvas, this.reset);
		
	}
	
	public MineSweepCanvas getMineSweepCanvas(){
		return this.mineSweepCanvas;
	}

	public void addResetHandler(EventHandler<ActionEvent> resetHandler) {
		this.reset.setOnAction(resetHandler);
		
	}


}
