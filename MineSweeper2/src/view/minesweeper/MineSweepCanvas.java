package view.minesweeper;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.minesweeper.MineField;
import model.minesweeper.MineState;
import model.minesweeper.SafeMine;

public class MineSweepCanvas extends HBox  {
	private Canvas canvas;
	private GraphicsContext gc;

	public MineSweepCanvas() {
		this.canvas = new Canvas(128*4,128*4);
		this.gc = canvas.getGraphicsContext2D();
	
		

	}
	public void setCanvasClick(EventHandler<MouseEvent> click) {
		this.setOnMouseClicked(click);
		//this.canvas.setOnMouseClicked(click);
		
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	public void updateMineSweepCanvas(MineField minefield) {
		this.canvas = new Canvas(128*4,128*4);
		this.gc = this.canvas.getGraphicsContext2D();
		
		double width = this.canvas.getWidth()/ minefield.getXSize();
		double height = this.canvas.getHeight()/minefield.getYSize();
		
		for (int x = 0; x < minefield.getXSize(); x++) {
			for (int y = 0; y < minefield.getXSize(); y++) {
				if (minefield.getAt(x, y).getState() == MineState.UNCHECKED || minefield.getAt(x, y).getState() == MineState.UNEXPLODED) {
					this.gc.setFill(Color.BLUE);
					this.gc.fillRect(x *width, y*height, width, height);

					
				}else if (minefield.getAt(x, y).getState() == MineState.NEARBY){
					this.gc.setFill(Color.GRAY);
					this.gc.fillRect(x *width, y*height, width, height);
					this.gc.setFill(Color.GREEN);
					String bombs =  String.valueOf(((SafeMine) minefield.getAt(x, y)).getBombs());
					this.gc.setTextAlign(TextAlignment.CENTER);
					this.gc.setTextBaseline(VPos.CENTER);
					this.gc.setFont(Font.font(32));
					this.gc.fillText(bombs , x* width + width/2, y*height + height/2);

				}else if (minefield.getAt(x, y).getState() == MineState.EXPLODED) {
					this.gc.setFill(Color.BLACK);
					this.gc.fillRect(x *width, y*height, width, height);
				}
				this.gc.setStroke(Color.BLACK);
				this.gc.strokeRect(x *width, y*height, width, height);

			}

		}
		
		
		this.getChildren().clear();
		this.getChildren().add(canvas);
		
	}
	

}



	

	

	

