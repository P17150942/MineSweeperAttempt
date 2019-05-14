package view.mainmenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class MainMenuRootPane extends VBox {
	private GridSizeSelector gridSizeSelector;

	public MainMenuRootPane() {
		this.gridSizeSelector = new GridSizeSelector();

		this.getChildren().add(gridSizeSelector);
	}
	
	public GridSizeSelector getGridSelector(){
		return this.gridSizeSelector;
	}
}
