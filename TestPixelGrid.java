package week6;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPixelGrid {

	PixelGrid grid;
	PixelGrid importedIMG;
	PixelGrid smallpng;
	
	@BeforeEach
	public void initializeGridData() {
		ArrayList<ArrayList<Color>> pg = new ArrayList<ArrayList<Color>>();
		ArrayList<Color> inner1 = new ArrayList<Color>();
		inner1.add(Color.BLUE);
		inner1.add(Color.GREEN);
		inner1.add(Color.GREEN);
		ArrayList<Color> inner2 = new ArrayList<Color>();
		inner2.add(Color.BLUE);
		inner2.add(Color.RED);
		inner2.add(Color.BLUE);
		ArrayList<Color> inner3 = new ArrayList<Color>();
		inner3.add(Color.GREEN);
		inner3.add(Color.RED);
		inner3.add(Color.GREEN);
		
		pg.add(inner1);
		pg.add(inner2);
		pg.add(inner3);
		
		grid = new PixelGrid(pg, 12345);
		
		importedIMG = new PixelGrid("images/pixilart-drawing.png", 12345);
		smallpng = new PixelGrid("images/pixil-frame-0.png", 12345);
	}

	@Test
	void testFindBluest() {
		assertEquals(0, grid.findBluest());
		assertEquals(34, importedIMG.findBluest());
	}

	@Test
	void testRandom() {

		assertEquals(0, grid.random());
		assertEquals(0, smallpng.random());
		assertEquals(5, importedIMG.random());
		
	}

	@Test
	void testChangeColor() {

		grid.changeColor(0, true);
		StringBuilder colors1 = new StringBuilder(
				"[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=0,g=255,b=0], java.awt.Color[r=0,g=255,b=0]]"
						+ "[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=255,g=0,b=0], java.awt.Color[r=0,g=0,b=255]]"
						+ "[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=255,g=0,b=0], java.awt.Color[r=0,g=255,b=0]]");

		assertEquals(colors1.toString(), grid.toString());
		
		smallpng.changeColor(0, true);
		StringBuilder colors2 = new StringBuilder(
				"[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=112,g=154,b=209], java.awt.Color[r=153,g=217,b=234]]"
				+ "[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=0,g=183,b=239], java.awt.Color[r=112,g=154,b=209]]"
				+ "[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=47,g=54,b=153], java.awt.Color[r=0,g=183,b=239]]");

		assertEquals(colors2.toString(), smallpng.toString());

	}
	
	@Test
	void testRemove() {

		grid.remove(1);
		StringBuilder colors1 = new StringBuilder("[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=0,g=255,b=0]]"
				+ "[java.awt.Color[r=0,g=0,b=255], java.awt.Color[r=0,g=0,b=255]]"
				+ "[java.awt.Color[r=0,g=255,b=0], java.awt.Color[r=0,g=255,b=0]]");

		assertEquals(colors1.toString(), grid.toString());
		
		smallpng.remove(1);
		StringBuilder colors2 = new StringBuilder("[java.awt.Color[r=0,g=183,b=239], java.awt.Color[r=153,g=217,b=234]]"
				+ "[java.awt.Color[r=47,g=54,b=153], java.awt.Color[r=112,g=154,b=209]]"
				+ "[java.awt.Color[r=47,g=54,b=153], java.awt.Color[r=0,g=183,b=239]]");

		assertEquals(colors2.toString(), smallpng.toString());

	}

}
