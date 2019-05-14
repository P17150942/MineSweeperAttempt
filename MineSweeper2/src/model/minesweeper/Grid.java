package model.minesweeper;

import java.util.Iterator;

public class Grid<E extends Object> {
	private int currentX = 0, currentY = 0;
	private int sizeX;
	private int sizeY;
	protected Object[][] grid;
	
	public Grid() {
		this.sizeX = 1;
		this.sizeY = 1;
		this.grid = new Object[1][1];
	}
	
	public Grid(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.grid = new Object[sizeX][sizeY];
	}
	
	public int getXSize() {
		return this.sizeX;
	}
	
	public int getYSize() {
		return this.sizeY;
	}
	
	public void setXSize(int sizeX) {
		this.sizeX = sizeX;
	}
	
	public void setYSize(int sizeY) {
		this.sizeY = sizeY;
	}
	
	@SuppressWarnings("unchecked")
	public E getAt(int x, int y) {
		return (E) this.grid[x][y];
	}
	
	public void setAt(int x, int y, E object) {
		this.grid[x][y] = object;
	}
	
	public Boolean indexExists(int x, int y) {
		return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
		
	}
	@Override
	public String toString() {
		
		String gridString = "\n\n";
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				gridString += grid[x][y] + ",";
			}
			gridString += "\n";
		}
		return "Grid:[" + "sizeX: " + this.sizeX + ", sizeY: " + this.sizeY + ", grid:" + gridString+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != this.getClass() || obj == null) {
			return false;
		}
		Grid<E> object = (Grid<E>) obj;
		return this.grid == object.grid && this.sizeX == object.sizeX && this.sizeY == object.sizeY;
		
		
	}

	
}
