package model.minesweeper;

public class ExplodingMine implements Mine {
	private MineState state;
	
	public ExplodingMine(int x, int y, Grid<Mine> grid, MineState state) {
		this.state = state;
	}
	@Override
	public void activate() {
		this.state = MineState.EXPLODED;
		
	}
	
	public MineState getState() {
		return this.state;
	}
	
	@Override
	public String toString() {
		
		return "e";
	}

}
