package week6;

import java.util.*;

public class UserMenu {

	private static PixelGrid pg;
	private static int counter = 0;

	public static void printMenu() {
		System.out.println("Please make a selection");
		System.out.println("B: remove bluest column");
		System.out.println("R: remove randomly selected column");
		System.out.println("U: undo most recent deletion");
		System.out.println("Q: Quit");
	}

	public static void printResponse(String selection, PixelGrid pg) {
		switch (selection) {
		case "B":
			int col = pg.findBluest();
			pg.changeColor(col, true);
			counter++;
			pg.save(counter, false);
			pg.remove(col);
			counter++;
			pg.save(counter, false);
			System.out.println("blue column saved and removed");
			break;
		case "R":
			int colRemove = pg.random();
			pg.changeColor(colRemove, false);
			counter++;
			pg.save(counter, false);
			pg.remove(colRemove);
			counter++;
			pg.save(counter, false);
			System.out.println("random column saved and removed");
			break;
		case "U":
			pg.undoDelete();
			counter++;
			pg.save(counter, false);
			System.out.println("undid last deletion");
			break;
		case "Q":
			pg.save(counter, true);
			System.out.println("Thanks for playing.");
			break;
		default:
			System.out.println("That is not a valid option. Please select an uppercase letter.");
			break;

		}
	}

	public static void main(String[] args) {

		boolean shouldQuit = false;

		String filename = "images/ponyo.png";

		Scanner scan = new Scanner(System.in);
		String choice = "";
		while (!shouldQuit) {
			printMenu();
			pg = new PixelGrid(filename);
			try {
				choice = scan.next();
			}

			catch (InputMismatchException e) {
				System.out.println("Input should be an uppercase letter");
				choice = "Q";
			}

			printResponse(choice, pg);
			if (choice.equals("Q")) {
				shouldQuit = true;
			}

		}

		scan.close();

	}

}
