package clubSimulation;

import java.util.concurrent.atomic.AtomicBoolean;

public class GridBlock {
	private int isOccupied;
	private final boolean isExit;  // Is this the exit door?
	private final boolean isBar;   // Is it a bar block?
	private final boolean isDance; // Is it the dance area?
	private int[] coords; // The coordinates of the block.
	private AtomicBoolean occupiedByPatrons;

	GridBlock(boolean exitBlock, boolean barBlock, boolean danceBlock) throws InterruptedException {
		isExit = exitBlock;
		isBar = barBlock;
		isDance = danceBlock;
		isOccupied = -1;
		this.occupiedByPatrons = new AtomicBoolean(false);
	}

	GridBlock(int x, int y, boolean exitBlock, boolean barBlock, boolean danceBlock) throws InterruptedException {
		this(exitBlock, barBlock, danceBlock);
		coords = new int[]{x, y};
	}

	public int getX() {
		return coords[0];
	}

	public int getY() {
		return coords[1];
	}

	public boolean get(int threadID) throws InterruptedException {
		if (isOccupied == threadID) return true; // Thread already in this block
		if (isOccupied >= 0) return false; // Space is occupied
		isOccupied = threadID;  // Set ID to thread that had the block
		return true;
	}

	public void release() {
		isOccupied = -1;
	}

	public boolean occupied() {
		return isOccupied >= 0;
	}

	public boolean isExit() {
		return isExit;
	}

	public boolean isBar() {
		return isBar;
	}

	public boolean isDanceFloor() {
		return isDance;
	}


	public synchronized void releaseByPatrons() {
		occupiedByPatrons.set(false);
	}

	public boolean isOccupiedByPatrons() {
		return occupiedByPatrons.get();
	}

	public void occupyByPatrons() {
		occupiedByPatrons.set(true);
	}
}
