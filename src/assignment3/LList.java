/**
 * 
 */
package assignment3;

import java.util.NoSuchElementException;

/**
 * @author Greg Smith
 * Custom list class for the program
 */
public class LList {

	/**
	 * holds the first node in the list
	 */
	public Node head;
	/**
	 * holds the size of the list
	 */
	private int size;

	/**
	 * default constructor that clears the list
	 */
	public LList() {
		head = null;
		size = 0;
	}

	/**
	 * checks if the list is empty
	 * 
	 * @return true or false
	 */
	boolean isEmpty() {
		return head == null;
	}

	/**
	 * adds a node to the front of the list
	 * 
	 * @param item
	 *            - character to be added
	 */
	void addFirst(Character item) {
		head = new Node(item, head);
		size++;
	}

	/**
	 * gets the data from the head of the list
	 * 
	 * @return
	 */
	Character getFirst() {
		if (head == null)
			throw new NoSuchElementException();

		return head.data;
	}

	/**
	 * removes the head of the list
	 * 
	 * @return the head's data
	 */
	Character removeFirst() {
		Character tmp = getFirst();
		head = head.next;
		size--;
		return tmp;
	}

	/**
	 * adds a node to the end of the list
	 * 
	 * @param item
	 *            - character to be added
	 */
	void addLast(Character item) {
		size++;
		if (head == null) {
			addFirst(item);

		} else {
			Node tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;

			tmp.next = new Node(item, null);

		}
	}

	/**
	 * clears the list
	 */
	void clear() {
		head = null;
	}

	/**
	 * gets the data from the node at the specified index
	 * 
	 * @param i
	 *            - position to get data from
	 * @return data from position i
	 */
	Character get(int i) {
		int n = indexOf(head);
		Node current = head;
		while (n > i) {
			--n;
			current = current.next;
		}
		return current.data;
	}

	/**
	 * gets the index of a node
	 * 
	 * @param node-
	 *            node to get the index of
	 * @return -1 or the index of the node
	 */
	private int indexOf(Node node) {
		if (node == null) {
			return -1;
		}
		return 1 + indexOf(node.next);
	}

	/**
	 * custom toString method. takes the list and builds a string using the
	 * character data in the list
	 * @return string of the character data in the list
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
			result.append(curr.data);
		}

		return result.toString();
	}

	/**
	 * removes a node that holds the matching character value
	 * @param key - value to be removed from the list
	 */
	void remove(Character key) {
		if (head == null)
			throw new RuntimeException("cannot delete");

		size--;
		if (head.data.equals(key)) {
			head = head.next;

			return;
		}

		Node cur = head;
		Node prev = null;

		while (cur != null && !cur.data.equals(key)) {
			prev = cur;
			cur = cur.next;
		}

		if (cur == null)
			throw new RuntimeException("cannot delete");

		prev.next = cur.next;
	}

	/**
	 * returns the size of the list
	 * @return the size of the list
	 */
	int size() {
		return size;
	}

	/**
	 * goes to a location in the list
	 * @param index - location to go to
	 * @return the node at the location
	 */
	private Node goTo(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	/**
	 * sets the node data
	 * @param index - location of the node
	 * @param x - data to be set in the node
	 */
	void set(int index, Character x) {
		Node current = goTo(index);
		current.data = x;

	}

	/**
	 * sorts the list alphabetically using my implementation of insertion sort
	 * @param node - head of the list to sort
	 * @return the head of the sorted list
	 */
	Node insertSort(Node node) { // T - n2
		if (node == null)
			return null;

		Node sortedList = node;
		node = node.next;
		sortedList.next = null;

		while (node != null) {

			final Node current = node;
			node = node.next;

			if (current.data < sortedList.data) {

				current.next = sortedList;
				sortedList = current;
			} else {

				Node search = sortedList;
				while (search.next != null && current.data > search.next.data)
					search = search.next;

				current.next = search.next;
				search.next = current;
			}
		}

		return sortedList;
	}

	/**
	 * sorts the list alphabetically using my implementation of bubble sort
	 */
	void bubbleSort() { // T - n2
		if (size > 1) {
			boolean wasChanged;

			do {
				Node current = head;
				Node previous = null;
				Node next = head.next;
				wasChanged = false;

				while (next != null) {
					if (current.data > next.data) {

						wasChanged = true;

						if (previous != null) {
							Node sig = next.next;

							previous.next = next;
							next.next = current;
							current.next = sig;
						} else {
							Node sig = next.next;

							head = next;
							next.next = current;
							current.next = sig;
						}

						previous = next;
						next = current.next;
					} else {
						previous = current;
						current = next;
						next = next.next;
					}
				}
			} while (wasChanged);
		}
	}

	/**
	 * sorts the list alphabetically using my implementation of selection sort
	 */
	void selectionSort() { // T - n2
		for (Node node1 = head; node1 != null; node1 = node1.next) {
			Node min = node1;
			for (Node node2 = node1; node2 != null; node2 = node2.next) {
				if (min.data > node2.data) {
					min = node2;
				}

			}
			Node temp = new Node(node1.data, null);
			node1.setData(min.data);
			min.setData(temp.data);
		}
	}

	/**
	 * sorts the list alphabetically using my implementation of merge sort
	 * @param a - head of the unsorted list
	 * @return head of the sorted list
	 */
	Node mergeSort(Node a) {
		Node oldHead = a;

		int mid = getLength(a) / 2;
		if (a.next == null)
			return a;

		while (mid - 1 > 0) {
			oldHead = oldHead.next;
			mid--;
		}
		Node newHead = oldHead.next;

		oldHead.next = null;
		oldHead = a;

		Node t1 = mergeSort(oldHead);
		Node t2 = mergeSort(newHead);
		return MergeList(t1, t2);
	}

	/**
	 * counts the nodes in the list without using the size method
	 * @param a - head of the list
	 * @return the size of the list
	 */
	public int getLength(Node a) {
		int count = 0;
		Node h = a;
		while (h != null) {
			count++;
			h = h.next;
		}
		return count;
	}

	/**
	 * merges the small sub lists
	 * @param a - head of first sublist
	 * @param b - head of second sublist
	 * @return head of merged sublists
	 */
	Node MergeList(Node a, Node b) {
		Node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data > b.data) {
			result = b;
			result.next = MergeList(a, b.next);
		} else {
			result = a;
			result.next = MergeList(a.next, b);
		}
		return result;
	}
}
