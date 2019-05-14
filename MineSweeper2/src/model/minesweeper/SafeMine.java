package model.minesweeper;

import java.util.ArrayList;

public class SafeMine implements Mine{
	private int x, y;
	private Grid<Mine> grid;
	private Boolean activated;
	private MineState state;
	private int bombs;
	
	public SafeMine(int x, int y, Grid<Mine> grid, MineState state) {
		this.grid = grid;
		this.x = x;
		this.y = y;
		this.state = state;
		this.activated = false;
		this.bombs = 0;
	}
	
	public int getBombs() {
		return this.bombs;
	}
	@Override
	public void activate() {
		if (this.state == MineState.UNCHECKED) {
			this.bombs = 0;
			int[][] adj = new int[][] {
				{-1 ,0},
				{-1, 1},
				{0, 1},
				{1, 1},
				{1, 0},
				{1, -1},
				{0, -1},
				{-1, -1}
			};
			
			for(int[] coord : adj) {
				if (this.grid.indexExists(coord[0] + x, coord[1] + y)) {
					Mine mine = this.grid.getAt(coord[0] + x, coord[1] + y);
					if (mine.getState() == MineState.UNEXPLODED) {
						this.bombs += 1;
					}
				}
			}
			
			if (this.bombs < 1) {
				for(int[] coord : adj) {
					if (this.grid.indexExists(coord[0] + x, coord[1] + y)) {
						Mine mine = this.grid.getAt(coord[0] + x, coord[1] + y);
						if (mine.getState() == MineState.UNCHECKED) {
							this.state = MineState.SAFE;
							mine.activate();
						}
					}
				
				}
			}else {
				this.state = MineState.NEARBY;
			}

			
			
			
			

		}
		
	}
	
	public MineState getState() {
		return this.state;
	}
	
	
	
	@Override
	public String toString() {
		
		return state.toString();
	}


}
