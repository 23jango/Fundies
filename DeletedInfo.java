package week6;

import java.awt.Color;
import java.util.ArrayList;

/**
 * this class is helpful for creating a stack filled with
 * previous commands that the user inputs
 */
public class DeletedInfo {

	private int prevIndex;
	private ArrayList<Color> column;
	
	public DeletedInfo(int index, ArrayList<Color> col) {
		this.prevIndex = index;
		this.column = new ArrayList<Color>(); //creating space for colors in list
		
		for (int i = 0; i < col.size(); i++) {
			Color copyColor = new Color(col.get(i).getRGB());
			this.column.add(copyColor);
		}
	}
	
	public int getIndex() {
		return this.prevIndex;
	}
	
	public ArrayList<Color> getColumn() {
		return new ArrayList<Color>(this.column); //copies column into new grid
	}
	
}
