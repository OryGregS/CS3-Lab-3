/**
 * 
 */
package assignment3;

/**
 * @author Greg Smith has 4 different methods for 4 different sorting algorithms
 */
public class ListSorts {

	/**
	 * holds the list to sort
	 */
	private LList toSort;
	/**
	 * holds the list for characters from the list to sort that are in the name
	 */
	private LList nameChars;
	/**
	 * holds the name of the user
	 */
	private String name;

	/**
	 * constructor that passes data into the private fields
	 * 
	 * @param list
	 *            - list to sort
	 * @param name
	 *            - name to sort by
	 */
	public ListSorts(LList list, String name) {
		toSort = list;
		this.name = name;
	}

	/**
	 * sorts the list using my implementation of insertion sort
	 * 
	 * @return sorted list
	 */
	LList insertSort() {

		// Remove chars from name //
		nameChars = new LList();
		Node curr = toSort.head;

		for (int j = 0; j < name.length(); j++) {

			while (curr != null) {

				if (curr.data == name.charAt(j)) {

					char toAdd = name.charAt(j);
					nameChars.addFirst(toAdd);
					toSort.remove(curr.data);

				}

				curr = curr.next;
			}

			curr = toSort.head;
		}
		/////////////////////////////
		// sort list besides letters in name //

		toSort.head = toSort.insertSort(toSort.head);

		///////////////////////////////////////
		// place sorted letters in name back into list //
		curr = nameChars.head;

		while (curr != null) {

			toSort.addFirst(curr.data);
			curr = curr.next;
		}
		//////////////////////////////////////////////////

		return toSort;
	}

	/**
	 * sorts the list using my implementation of bubble sort
	 * 
	 * @return sorted list
	 */
	LList bubbleSort() {

		// Remove chars from name //
		nameChars = new LList();
		Node curr = toSort.head;

		for (int j = 0; j < name.length(); j++) {

			while (curr != null) {

				if (curr.data == name.charAt(j)) {

					char toAdd = name.charAt(j);
					nameChars.addFirst(toAdd);
					toSort.remove(curr.data);

				}

				curr = curr.next;
			}

			curr = toSort.head;
		}
		/////////////////////////////
		// sort list besides letters in name //

		toSort.bubbleSort();

		///////////////////////////////////////
		// place sorted letters in name back into list //

		curr = nameChars.head;

		while (curr != null) {

			toSort.addFirst(curr.data);
			curr = curr.next;
		}
		//////////////////////////////////////////////////

		return toSort;
	}

	/**
	 * sorts the list using my implementation of selection sort
	 * 
	 * @return sorted list
	 */
	LList selectSort() {

		// Remove chars from name //
		nameChars = new LList();
		Node curr = toSort.head;

		for (int j = 0; j < name.length(); j++) {

			while (curr != null) {

				if (curr.data == name.charAt(j)) {

					char toAdd = name.charAt(j);
					nameChars.addFirst(toAdd);
					toSort.remove(curr.data);

				}

				curr = curr.next;
			}

			curr = toSort.head;
		}
		/////////////////////////////
		// sort list besides letters in name //

		toSort.selectionSort();

		///////////////////////////////////////
		// place sorted letters in name back into list //

		curr = nameChars.head;

		while (curr != null) {

			toSort.addFirst(curr.data);
			curr = curr.next;
		}
		//////////////////////////////////////////////////

		return toSort;
	}

	/**
	 * sorts the list using my implementation of merge sort
	 * 
	 * @return sorted list
	 */
	LList mergeSort() {

		// Remove chars from name //
		nameChars = new LList();
		Node curr = toSort.head;

		for (int j = 0; j < name.length(); j++) {

			while (curr != null) {

				if (curr.data == name.charAt(j)) {

					char toAdd = name.charAt(j);
					nameChars.addFirst(toAdd);
					toSort.remove(curr.data);

				}

				curr = curr.next;
			}

			curr = toSort.head;
		}
		/////////////////////////////
		// sort list besides letters in name //

		toSort.head = toSort.mergeSort(toSort.head);

		///////////////////////////////////////
		// place sorted letters in name back into list //
		curr = nameChars.head;

		while (curr != null) {

			toSort.addFirst(curr.data);
			curr = curr.next;
		}
		//////////////////////////////////////////////////

		return toSort;
	}

}
