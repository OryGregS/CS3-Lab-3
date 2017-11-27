/**
 * 
 */
package assignment3;

import java.util.Arrays;

/**
 * @author Greg Smith has 4 different methods for 4 different sorting algorithms
 */
public class ArraySorts {

	/**
	 * holds the name of the user
	 */
	private String name;
	/**
	 * holds the array for characters from the array to sort that are in the name
	 */
	private char[] nameChars;

	/**
	 * constructor that passes data into the private fields
	 * 
	 * @param name
	 *            - name to sort by
	 */
	public ArraySorts(String name) {
		this.name = name;
	}

	/**
	 * takes an unsorted array and returns a sorted array using my implementation of
	 * insertion sort
	 * 
	 * @param arr
	 *            - unsorted array
	 * @return sorted array
	 */
	char[] insert(char[] arr) {

		// Remove chars from name //

		int arrLength = arr.length;
		int counter = 0;
		nameChars = new char[arr.length];

		for (int i = 0; i < name.length(); i++) {
			for (int j = 0; j < arr.length; j++) {

				if (name.charAt(i) == arr[j]) {
					nameChars[counter] = name.charAt(i);
					counter++;
					arr[j] = ' ';
				}
			}
		}

		char[] temp = new char[arrLength - counter];

		counter = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ' ') {
				temp[counter] = arr[i];
				counter++;
			}
		}

		//////////////////////////////
		// Sort letters besides those in name //
		for (int i = 1; i < temp.length; i++) {

			char x = temp[i];
			int j = Math.abs(Arrays.binarySearch(temp, 0, i, x) + 1);
			System.arraycopy(temp, j, temp, j + 1, i - j);
			temp[j] = x;

		}
		////////////////////////////////////////
		// copy letters from name and letters sorted by alphabet into new array //
		char[] newArr = new char[arrLength];

		int stop = 0;
		for (int i = 0; i < nameChars.length; i++) {
			for (int j = 0; j < name.length(); j++) {

				if (nameChars[i] == name.charAt(j)) {
					newArr[i] = nameChars[i];
					stop++;
				}

			}

		}

		for (int i = 0; i < temp.length; i++) {
			if (stop < 99 && temp[i] != ' ') {
				newArr[stop] = temp[i];
				stop++;
			}

		}
		//////////////////////////////////////////////////////////////////////////////

		return newArr;
	}

	/**
	 * takes an unsorted array and returns a sorted array using my implementation of
	 * bubble sort
	 * 
	 * @param arr
	 *            - unsorted array
	 * @return sorted array
	 */
	char[] bubble(char[] arr) {

		// Remove chars from name //

		int arrLength = arr.length;
		int counter = 0;
		nameChars = new char[arr.length];

		for (int i = 0; i < name.length(); i++) {
			for (int j = 0; j < arr.length; j++) {

				if (name.charAt(i) == arr[j]) {
					nameChars[counter] = name.charAt(i);
					counter++;
					arr[j] = ' ';
				}
			}
		}

		char[] temp = new char[arrLength - counter];

		counter = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ' ') {
				temp[counter] = arr[i];
				counter++;
			}
		}

		//////////////////////////////
		// sort temp array //
		int n = temp.length;
		char x = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 1; j < (n - i); j++) {

				if (temp[j - 1] > temp[j]) {

					x = temp[j - 1];
					temp[j - 1] = temp[j];
					temp[j] = x;

				}
			}
		}

		////////////////////////////////////////
		// copy letters from name and letters sorted by alphabet into new array //
		char[] newArr = new char[arrLength];

		int stop = 0;
		for (int i = 0; i < nameChars.length; i++) {
			for (int j = 0; j < name.length(); j++) {

				if (nameChars[i] == name.charAt(j)) {
					newArr[i] = nameChars[i];
					stop++;
				}

			}

		}

		for (int i = 0; i < temp.length; i++) {
			if (stop < 99 && temp[i] != ' ') {
				newArr[stop] = temp[i];
				stop++;
			}

		}
		//////////////////////////////////////////////////////////////////////////////

		return newArr;
	}

	/**
	 * takes an unsorted array and returns a sorted array using my implementation of
	 * selection sort
	 * 
	 * @param arr
	 *            - unsorted array
	 * @return sorted array
	 */
	char[] select(char[] arr) {

		// Remove chars from name //

		int arrLength = arr.length;
		int counter = 0;
		nameChars = new char[arr.length];

		for (int i = 0; i < name.length(); i++) {
			for (int j = 0; j < arr.length; j++) {

				if (name.charAt(i) == arr[j]) {
					nameChars[counter] = name.charAt(i);
					counter++;
					arr[j] = ' ';
				}
			}
		}

		char[] temp = new char[arrLength - counter];

		counter = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ' ') {
				temp[counter] = arr[i];
				counter++;
			}
		}

		//////////////////////////////
		// sort temp array //
		for (int i = 0; i < temp.length - 1; i++) {

			int index = i;
			for (int j = i + 1; j < temp.length; j++) {

				if (temp[j] < temp[index]) {
					index = j;
				}

			}

			char lowerLetter = temp[index];
			temp[index] = temp[i];
			temp[i] = lowerLetter;

		}
		////////////////////////////////////////
		// copy letters from name and letters sorted by alphabet into new array //
		char[] newArr = new char[arrLength];

		int stop = 0;
		for (int i = 0; i < nameChars.length; i++) {
			for (int j = 0; j < name.length(); j++) {

				if (nameChars[i] == name.charAt(j)) {
					newArr[i] = nameChars[i];
					stop++;
				}

			}

		}

		for (int i = 0; i < temp.length; i++) {
			if (stop < 99 && temp[i] != ' ') {
				newArr[stop] = temp[i];
				stop++;
			}

		}
		//////////////////////////////////////////////////////////////////////////////

		return newArr;

	}

	/**
	 * merges the small subarrays
	 * 
	 * @param arr
	 *            - unsorted array
	 * @param l
	 *            - left side of array
	 * @param m
	 *            - middle of array
	 * @param r
	 *            - right side of array
	 */
	private void merge(char arr[], int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		char L[] = new char[n1];
		char R[] = new char[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];

		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	/**
	 * breaks the array down into small sub arrays
	 * 
	 * @param arr
	 *            - unsorted array
	 * @param l
	 *            - left side of array
	 * @param r
	 *            - right side of array
	 */
	private void mergeSort(char arr[], int l, int r) {

		if (l < r) {

			int m = (l + r) / 2;

			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);

		}
	}

	/**
	 * takes an unsorted array and returns a sorted array using my implementation of
	 * merge sort
	 * 
	 * @param arr
	 *            - unsorted array
	 * @return sorted array
	 */
	char[] callMerge(char arr[]) {

		// Remove chars from name //

		int arrLength = arr.length;
		int counter = 0;
		nameChars = new char[arr.length];

		for (int i = 0; i < name.length(); i++) {
			for (int j = 0; j < arr.length; j++) {

				if (name.charAt(i) == arr[j]) {
					nameChars[counter] = name.charAt(i);
					counter++;
					arr[j] = ' ';
				}
			}
		}

		char[] temp = new char[arrLength - counter];

		counter = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ' ') {
				temp[counter] = arr[i];
				counter++;
			}
		}

		//////////////////////////////
		// sort temp array //

		mergeSort(temp, 0, temp.length - 1);

		////////////////////////////////////////
		// copy letters from name and letters sorted by alphabet into new array //
		char[] newArr = new char[arrLength];

		int stop = 0;
		for (int i = 0; i < nameChars.length; i++) {
			for (int j = 0; j < name.length(); j++) {

				if (nameChars[i] == name.charAt(j)) {
					newArr[i] = nameChars[i];
					stop++;
				}

			}

		}

		for (int i = 0; i < temp.length; i++) {
			if (stop < 99 && temp[i] != ' ') {
				newArr[stop] = temp[i];
				stop++;
			}

		}
		//////////////////////////////////////////////////////////////////////////////

		return newArr;
	}
	
}
