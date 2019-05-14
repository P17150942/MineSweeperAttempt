package model.minesweeper;

public class MineSweeperGame {
	
	private MineField minefield;
	private boolean gameOver;
	
	public MineSweeperGame(MineField minefield) {
		this.minefield = minefield;
	}
	

	
	public MineField getMineField() {
		return this.minefield;
	}



	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
		
	}
	
	public void setMinefield(MineField mf) {
		this.minefield = mf;
	}
	
	public boolean getGameOver() {
		return this.gameOver;
		
	}





}
