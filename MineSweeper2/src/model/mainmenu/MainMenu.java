package model.mainmenu;

import model.minesweeper.MineField;

public class MainMenu {
	private MineField minefield;
	
	public MainMenu() {
		this.minefield = new MineField(1, 1);
	}
	
	public void setMineField(MineField minefield) {
		this.minefield = minefield;
	}
	
	public MineField getMineField() {
		return this.minefield;
	}
}
