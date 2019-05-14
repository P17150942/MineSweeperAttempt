package view.mainmenu;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GridSizeSelector extends GridPane {
	private TextField widthField, heightField;
	private Label widthLabel, heightLabel;
	private Button play;
	
	public GridSizeSelector() {
		this.widthLabel = new Label("Width");
		this.heightLabel = new Label("Height");
		
		this.widthField = new TextField();
		this.heightField = new TextField();
		this.play = new Button("play");
		
		this.add(widthLabel, 0, 0);
		this.add(heightLabel, 0, 1);
		
		this.add(widthField, 1, 0);
		this.add(heightField, 1, 1);
		
		this.add(play, 0, 2);
	}
	
	public TextField getWidthField() {
		return this.widthField;
	}
	
	public TextField getHeightField() {
		return this.heightField;
	}
	
	public Label getWidthLabel() {
		return this.widthLabel;
	}
	
	public Label getHeightLabel() {
		return this.heightLabel;
	}
	
	public Button getPlayButton() {
		return this.play;
	}

	public void setPlayButtonHandler(EventHandler<ActionEvent> play) {
		this.play.setOnAction(play);
		
	}
	
	public int getXSize() {
		return Integer.valueOf(this.widthField.getText());
	}
	
	public int getYSize() {
		return Integer.valueOf(this.heightField.getText());
	}
	
	
	
}
