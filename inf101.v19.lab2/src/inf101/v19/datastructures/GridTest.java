package inf101.v19.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import inf101.v19.cell.CellState;

public class GridTest {
	Random random = new Random();

	@Test
	public void constructTest1() {
		IGrid grid = new MyGrid(11, 17, CellState.DEAD);
		
		// TODO: sjekk at bredde og høyde faktisk er 11 og 17
		if (( grid.getWidth() > 11) || (grid.getWidth() < 11)) {
			fail("WIDTH: Should throw exception");
		}
		
		if ( grid.getHeight() != 17) {
			fail("HEIGHT: Should throw exception");
		}
	}
	/**
	 * Tests that trying to access outside of the dimensions of the grid throws
	 * an IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsTest() {
		IGrid grid = new MyGrid(10, 10, CellState.DEAD);

		try {
			grid.set(11, 0, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.set(0, 11, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
	}

	@Test
	public void setGetTest1() {
		IGrid grid = new MyGrid(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
				assertEquals(cs, grid.get(x, y));
			}
	}

	@Test
	public void setGetTest2() {
		IGrid grid = new MyGrid(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, CellState.random(random));
			}
		}

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
				assertEquals(cs, grid.get(x, y));
			}
	}

	@Test
	public void copyTest() {
		IGrid grid = new MyGrid(100, 100, CellState.DEAD);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				CellState cs = CellState.random(random);
				grid.set(x, y, cs);
			}
		}

		IGrid newGrid = grid.copy();
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				assertEquals(grid.get(x, y), newGrid.get(x, y));
			}
		}
	}
}
