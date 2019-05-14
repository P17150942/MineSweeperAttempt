package model.minesweeper;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.beans.InvalidationListener;


public class MineField{
	private Grid<Mine> grid;
	private Random rand;
	private ArrayList<SafeMine> safeMines;
	private ArrayList<ExplodingMine> explodingMines;
	public MineField(int sizeX, int sizeY) {
		this.grid = new Grid<Mine>(sizeX, sizeY);
		this.safeMines = new ArrayList<SafeMine>();
		this.explodingMines = new ArrayList<ExplodingMine>();
		for (int x = 0; x < this.grid.getXSize(); x++) {
			for (int y = 0; y < this.grid.getYSize(); y++) {
				int n = new Random().nextInt(64);
				
				if (n < 12) {
					ExplodingMine explodingMine = new ExplodingMine(x, y, grid, MineState.UNEXPLODED);
					this.explodingMines.add(explodingMine);
					this.grid.setAt(x, y,explodingMine);
				
				
				}else {
					SafeMine safeMine = new SafeMine(x, y, this.grid, MineState.UNCHECKED);
					this.safeMines.add(safeMine);
					this.grid.setAt(x, y,safeMine);
				}
				
			}
		}
		
	}
	
	public void activateAt(int x, int y) {
		this.grid.getAt(x, y).activate();
		
	}
	
	public int getXSize() {
		return this.grid.getXSize();
	}
	
	public int getYSize() {
		return this.grid.getYSize();
	}
	
	public Mine getAt(int x, int y) {
		return this.grid.getAt(x, y);
	}
	
	public boolean tileExists(int x, int y) {
		return this.grid.indexExists(x, y);
	}
	
	@Override
	public String toString() {
		
		return "MineField:[grid: " + this.grid + "]";  
	}

	public void reset() {
		for (int x = 0; x < this.grid.getXSize(); x++) {
			for (int y = 0; y < this.grid.getYSize(); y++) {
				int n = new Random().nextInt(64);
				
				if (n < 12) {
					ExplodingMine explodingMine = new ExplodingMine(x, y, grid, MineState.UNEXPLODED);
					this.explodingMines.add(explodingMine);
					this.grid.setAt(x, y,explodingMine);
				
				
				}else {
					SafeMine safeMine = new SafeMine(x, y, this.grid, MineState.UNCHECKED);
					this.safeMines.add(safeMine);
					this.grid.setAt(x, y,safeMine);
				}
			}
		}

		
	}

	




}
