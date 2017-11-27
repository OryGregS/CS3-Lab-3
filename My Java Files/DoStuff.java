/**
 * 
 */
package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * @author Greg Smith main driver for the program that does stuff
 */
public class DoStuff {

	/**
	 * holds the user's last name
	 */
	private String name;
	/**
	 * holds the value of the original randomly generated characters
	 */
	private String ogList = null;
	/**
	 * holds the list that gets passed to ListSorts
	 */
	private LList rList = new LList();
	/**
	 * holds the user-defined size of the list/array
	 */
	private int n;
	/**
	 * holds the value for the time taken for the 4 different list sorting
	 * algorithms
	 */
	private long listBTime, listITime, listSTime, listMTime;
	/**
	 * holds the value for the time taken for the 4 different array sorting
	 * algorithms
	 */
	private long arrBTime, arrITime, arrSTime, arrMTime;
	/**
	 * object used to format the time into milliseconds
	 */
	private NumberFormat formatter = new DecimalFormat("#.000");
	/**
	 * holds the number of times the user would like to run the program
	 */
	private int runTimes;

	/**
	 * brief description of what the program does
	 */
	void greeting() {
		JOptionPane.showMessageDialog(null, "This program sorts a randomly generated string of letters "
				+ "\n- first by the letters in your last name -" + "\n- then alphabetically -");

	}

	/**
	 * gets the size of the list/array from user
	 */
	void getN() {

		n = 0;
		String input = null;
		do {

			input = JOptionPane.showInputDialog("Please enter the number of letters you would like to generate.");

			if (input.matches("[0-9]+")) {
				n = Integer.parseInt(input);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer value!");
			}
		} while (!input.matches("[0-9]+"));

	}

	/**
	 * gets the name to sort by from user
	 */
	void getName() {

		String input = null;
		do {
			input = JOptionPane.showInputDialog("Please enter your last name to sort by.").toLowerCase().trim();
			if (input.matches("[a-zA-Z]+")) {
				name = input;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a name!");
			}
		} while (!input.matches("[a-zA-Z]+"));
	}

	/**
	 * fills the list with randomly generated characters
	 */
	void generateLetters() {

		Random r = new Random();
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		final int aNum = alphabet.length();

		for (int i = 0; i < n; i++) {
			rList.addFirst(alphabet.charAt(r.nextInt(aNum)));
		}

		ogList = rList.toString();

	}

	/**
	 * resets the list that gets passed into ListSorts
	 */
	void resetList() {
		rList.clear();
		for (int i = 0; i < ogList.length(); i++) {
			rList.addLast(ogList.charAt(i));
		}
	}

	/**
	 * sorts the list using bubble sort and calculates the time taken
	 * 
	 * @return sorted list
	 */
	LList bSort() {
		resetList();
		ListSorts ls = new ListSorts(rList, name);

		final long start = System.nanoTime();
		LList toReturn = ls.bubbleSort();
		final long end = System.nanoTime();
		listBTime = end - start;

		return toReturn;
	}

	/**
	 * sorts the list using selection sort and calculates the time taken
	 * 
	 * @return sorted list
	 */
	LList sSort() {
		resetList();
		ListSorts ls = new ListSorts(rList, name);

		final long start = System.nanoTime();
		LList toReturn = ls.selectSort();
		final long end = System.nanoTime();
		listSTime = end - start;

		return toReturn;
	}

	/**
	 * sorts the list using merge sort and calculates the time taken
	 * 
	 * @return sorted list
	 */
	LList mSort() {
		resetList();
		ListSorts ls = new ListSorts(rList, name);

		final long start = System.nanoTime();
		LList toReturn = ls.mergeSort();
		final long end = System.nanoTime();
		listMTime = end - start;

		return toReturn;
	}

	/**
	 * sorts the list using insertion sort and calculates the time taken
	 * 
	 * @return sorted list
	 */
	LList iSort() {
		resetList();
		ListSorts ls = new ListSorts(rList, name);

		final long start = System.nanoTime();
		LList toReturn = ls.insertSort();
		final long end = System.nanoTime();
		listITime = end - start;

		return toReturn;
	}

	/**
	 * sorts the array using insertion sort and calculates the time taken
	 * 
	 * @return sorted array
	 */
	char[] arrInsert() {

		ArraySorts as = new ArraySorts(name);
		final char[] ogCharsArr = ogList.toCharArray();

		final long start = System.nanoTime();
		char[] toReturn = as.insert(ogCharsArr);
		final long end = System.nanoTime();

		arrITime = end - start;

		return toReturn;

	}

	/**
	 * sorts the array using bubble sort and calculates the time taken
	 * 
	 * @return sorted array
	 */
	char[] arrBubble() {

		ArraySorts as = new ArraySorts(name);
		final char[] ogCharsArr = ogList.toCharArray();

		final long start = System.nanoTime();
		char[] toReturn = as.bubble(ogCharsArr);
		final long end = System.nanoTime();

		arrBTime = end - start;

		return toReturn;
	}

	/**
	 * sorts the array using selection sort and calculates the time taken
	 * 
	 * @return sorted array
	 */
	char[] arrSelect() {

		ArraySorts as = new ArraySorts(name);
		final char[] ogCharsArr = ogList.toCharArray();

		final long start = System.nanoTime();
		char[] toReturn = as.select(ogCharsArr);
		final long end = System.nanoTime();

		arrSTime = end - start;

		return toReturn;
	}

	/**
	 * sorts the array using insertion sort and calculates the time taken
	 * 
	 * @return sorted array
	 */
	char[] arrMerge() {

		ArraySorts as = new ArraySorts(name);
		final char[] ogCharsArr = ogList.toCharArray();

		final long start = System.nanoTime();
		char[] toReturn = as.callMerge(ogCharsArr);
		final long end = System.nanoTime();

		arrMTime = end - start;

		return toReturn;
	}

	/**
	 * prints the results from the list sorting algorithms to the console
	 */
	void printListResults() {

		////////////////////////////////////// Insert////////////////////////////////////////////

		LList insertList = iSort();

		System.out.println("Insertion:");
		System.out.println();
		System.out.print("\t");
		Node iCurr = insertList.head;

		while (iCurr != null) {
			System.out.print(iCurr.data);
			iCurr = iCurr.next;
		}

		System.out.println("\n\tTime spent: " + formatter.format(listITime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(m*n^2 + n^2 + n)");
		System.out.println("\tObserved Space complexity - O(n)");
		System.out.println();

		////////////////////////////////////// Bubble////////////////////////////////////////////

		LList bubbleList = bSort();

		System.out.println("Bubble:");
		System.out.println();
		System.out.print("\t");
		Node bCurr = bubbleList.head;

		while (bCurr != null) {
			System.out.print(bCurr.data);
			bCurr = bCurr.next;
		}

		System.out.println("\n\tTime spent: " + formatter.format(listBTime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(m*n^2 + n^2 + n)");
		System.out.println("\tObserved Space complexity - O(n)");
		System.out.println();

		////////////////////////////////////// Select////////////////////////////////////////////

		LList selectList = sSort();

		Node sCurr = selectList.head;

		System.out.println("Select:");
		System.out.println();
		System.out.print("\t");
		while (sCurr != null) {
			System.out.print(sCurr.data);
			sCurr = sCurr.next;
		}

		System.out.println("\n\tTime spent: " + formatter.format(listSTime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(m*n^2 + n^2 + n)");
		System.out.println("\tObserved Space complexity - O(n)");
		System.out.println();

		////////////////////////////////////// Merge////////////////////////////////////////////

		LList mergeList = mSort();

		Node mCurr = mergeList.head;

		System.out.println("Merge:");
		System.out.println();
		System.out.print("\t");
		while (mCurr != null) {
			System.out.print(mCurr.data);
			mCurr = mCurr.next;
		}

		System.out.println("\n\tTime spent: " + formatter.format(listMTime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(m*n^2 + n + nlogn)");
		System.out.println("\tObserved Space complexity - O(n)");
		System.out.println();
	}

	/**
	 * prints the results from the array sorting algorithms to the console
	 */
	void printArrResults() {

		StringBuilder sb = new StringBuilder();

		////////////////////////////////////// Insert////////////////////////////////////////////

		char[] iSorted = arrInsert();

		System.out.println("Insertion:");
		System.out.println();

		for (int i = 0; i < iSorted.length; i++) {
			sb.append(iSorted[i]);
		}

		String iString = sb.toString();

		System.out.println("\t" + iString);
		System.out.println("\tTime spent: " + formatter.format(arrITime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(n^2 + 2mn + 2n)");
		System.out.println("\tObserved Space complexity - O(n^2 + 3n)");
		System.out.println();

		////////////////////////////////////// Bubble////////////////////////////////////////////

		sb = new StringBuilder();
		char[] bSorted = arrBubble();

		System.out.println("Bubble:");
		System.out.println();

		for (int i = 0; i < bSorted.length; i++) {
			sb.append(bSorted[i]);
		}

		String bString = sb.toString();

		System.out.println("\t" + bString);
		System.out.println("\tTime spent: " + formatter.format(arrBTime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(n^2 + 2mn + 2n)");
		System.out.println("\tObserved Space complexity - O(3n)");
		System.out.println();

		////////////////////////////////////// Select////////////////////////////////////////////

		sb = new StringBuilder();
		char[] sSorted = arrSelect();

		System.out.println("Select:");
		System.out.println();

		for (int i = 0; i < sSorted.length; i++) {
			sb.append(sSorted[i]);
		}

		String sString = sb.toString();

		System.out.println("\t" + sString);
		System.out.println("\tTime spent: " + formatter.format(arrSTime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(n^2 + 2mn + 2n)");
		System.out.println("\tObserved Space complexity - O(3n)");
		System.out.println();

		////////////////////////////////////// Merge////////////////////////////////////////////

		sb = new StringBuilder();
		char[] mSorted = arrMerge();

		System.out.println("Merge:");
		System.out.println();

		for (int i = 0; i < mSorted.length; i++) {
			sb.append(mSorted[i]);
		}

		String mString = sb.toString();

		System.out.println("\t" + mString);
		System.out.println("\tTime spent: " + formatter.format(arrMTime / 1000000d) + " ms");
		System.out.println();
		System.out.println("\tObserved Time Complexity - O(2mn + 2n + nlogn)");
		System.out.println("\tObserved Space complexity - O(3n)");
		System.out.println();

	}

	/**
	 * prints a neat table-thing of comparisons between array and list sorts
	 */
	void printCompare() {
		System.out.println();
		System.out.printf("%88s", "(Observed)");
		System.out.println();
		System.out.println("*** Time Comparisons ***");
		System.out.println();
		System.out.printf("%70s %30s", "List", "Array");
		System.out.println();
		System.out.printf("%70s %30s", "----", "-----");
		System.out.println();
		System.out.println();
		System.out.printf("%10s %60s %30s", "Insertion:", formatter.format(listITime / 1000000d) + " ms",
				formatter.format(arrITime / 1000000d) + " ms");
		System.out.println();
		System.out.printf("%10s %60s %30s", "Bubble:", formatter.format(listBTime / 1000000d) + " ms",
				formatter.format(arrBTime / 1000000d) + " ms");
		System.out.println();
		System.out.printf("%10s %60s %30s", "Selection:", formatter.format(listSTime / 1000000d) + " ms",
				formatter.format(arrSTime / 1000000d) + " ms");
		System.out.println();
		System.out.printf("%10s %60s %30s", "Merge:", formatter.format(listMTime / 1000000d) + " ms",
				formatter.format(arrMTime / 1000000d) + " ms");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("*** Time Complexity Comparison ***");
		System.out.println();
		System.out.printf("%30s %39s %30s", "Theoretical", "List", "Array");
		System.out.println();
		System.out.printf("%30s %39s %30s", "-----------", "----", "-----");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.printf("%10s %17s %49s %28s", "Insertion:", "O(n^2)", "O(m*n^2 + n^2 + n)", "O(n^2 + 2mn + 2n)");
		System.out.println();
		System.out.printf("%10s %17s %49s %28s", "Bubble:", "O(n^2)", "O(m*n^2 + n^2 + n)", "O(n^2 + 2mn + 2n)");
		System.out.println();
		System.out.printf("%10s %17s %49s %28s", "Selection:", "O(n^2)", "O(m*n^2 + n^2 + n)", "O(n^2 + 2mn + 2n)");
		System.out.println();
		System.out.printf("%10s %19s %49s %28s", "Merge:", "O(nlogn)", "O(m*n^2 + n + nlogn)", "O(2mn + 2n + nlogn)");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("*** Space Complexity Comparison ***");
		System.out.println();
		System.out.printf("%70s %30s", "List", "Array");
		System.out.println();
		System.out.printf("%70s %30s", "----", "-----");
		System.out.println();
		System.out.println();
		System.out.printf("%10s %59s %36s", "Insertion:", "O(n)", "O(n^2 + 3n)");
		System.out.println();
		System.out.printf("%10s %59s %30s", "Bubble:", "O(n)", "O(3n)");
		System.out.println();
		System.out.printf("%10s %59s %30s", "Selection:", "O(n)", "O(3n)");
		System.out.println();
		System.out.printf("%10s %59s %30s", "Merge:", "O(n)", "O(3n)");
		System.out.println();
		System.out.println();

	}

	/**
	 * prints everything to console
	 */
	void printAll() {

		JOptionPane.showMessageDialog(null, "Results have been printed to the console");
		System.out.println("N: " + n);
		System.out.println();
		System.out.println("Last Name: " + name);
		System.out.println();
		System.out.println("Original Random String: \n\n\t" + ogList);
		System.out.println();

		String div = "-----------------------------------------------------------------------------------------------------------------";

		System.out.println();
		System.out.println(div);
		System.out.println("*** List Results ***");
		System.out.println(div);
		System.out.println();
		printListResults();
		System.out.println(div);
		System.out.println("*** Array Results ***");
		System.out.println(div);
		System.out.println();
		printArrResults();
		System.out.println(div);
		System.out.println("*** Comparisons ***");
		System.out.println(div);
		System.out.println();
		printCompare();
		System.out.println(div);

	}

	/**
	 * runs everything for the program
	 * 
	 * @throws FileNotFoundException
	 */
	void run() throws FileNotFoundException {

		boolean cont = false;
		boolean valid = false;
		String input = null;

		do {

			greeting();
			getN();
			generateLetters();
			getName();
			printAll();
			getRunTimes();
			outputCSV();

			do {

				input = JOptionPane.showInputDialog("Would you like to run the program again?\n"
						+ "\nEnter \"YES\" to continue" + "\nEnter \"NO\" to exit");

				if (input.equalsIgnoreCase("yes")) {

					valid = true;
					cont = true;

				}

				else if (input.equalsIgnoreCase("no")) {

					valid = true;
					cont = false;

				}

				else {

					valid = false;
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter \"Yes\" or \"No\"");

				}

			} while (valid == false);

		} while (cont);

	}

	/**
	 * asks the user if they would like to collect data into a CSV file
	 */
	void getRunTimes() {
		runTimes = 0;
		String input = null;
		do {

			input = JOptionPane.showInputDialog(
					"If desired, this program will generate a CSV file of search times.\nHow many times would you like to run the program to gather data?"
							+ "\n(enter 0 if CSV file is not desired)");

			if (input.matches("[0-9]+")) {
				runTimes = Integer.parseInt(input);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a integer value!");
			}
		} while (!input.matches("[0-9]+"));
	}

	/**
	 * prints a CSV file of search times for each sorting method and the type of
	 * data structure
	 * 
	 * @throws FileNotFoundException
	 */
	void printCSV() throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(new File("searchTimes" + runTimes + ".csv"));
		StringBuilder sb = new StringBuilder();

		sb.append("obs");
		sb.append(", ");
		sb.append("insertion");
		sb.append(", ");
		sb.append("bubble");
		sb.append(", ");
		sb.append("selection");
		sb.append(", ");
		sb.append("merge");
		sb.append(", ");
		sb.append("type");
		sb.append("\n");

		for (int runs = 1; runs <= runTimes; runs++) {

			sb.append(runs);
			sb.append(", ");
			sb.append(formatter.format(listITime / 1000000d));
			sb.append(", ");
			sb.append(formatter.format(listBTime / 1000000d));
			sb.append(", ");
			sb.append(formatter.format(listSTime / 1000000d));
			sb.append(", ");
			sb.append(formatter.format(listMTime / 1000000d));
			sb.append(", ");
			sb.append("List");
			sb.append("\n");

			sb.append(runs);
			sb.append(", ");
			sb.append(formatter.format(arrITime / 1000000d));
			sb.append(", ");
			sb.append(formatter.format(arrBTime / 1000000d));
			sb.append(", ");
			sb.append(formatter.format(arrSTime / 1000000d));
			sb.append(", ");
			sb.append(formatter.format(arrMTime / 1000000d));
			sb.append(", ");
			sb.append("Array");
			sb.append("\n");

			generateLetters();
			iSort();
			bSort();
			sSort();
			mSort();
			arrInsert();
			arrBubble();
			arrSelect();
			arrMerge();
			
			System.out.println(runs);
			

		}

		pw.write(sb.toString());
		pw.close();

	}

	/**
	 * calls output CSV with UI functions
	 * 
	 * @throws FileNotFoundException
	 */
	void outputCSV() throws FileNotFoundException {

		if (runTimes != 0) {
			JOptionPane.showMessageDialog(null, "Writing CSV file... This could take a very long time...");
			printCSV();
			JOptionPane.showMessageDialog(null, "CSV file completed!");
		}

	}

}
