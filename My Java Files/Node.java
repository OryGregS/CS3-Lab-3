/**
 * 
 */
package assignment3;

/**
 * @author Greg Smith
 * Custom node class for the program
 */
public class Node {

	/**
	 * holds the character data for the node
	 */
	public Character data;
	
	/**
	 * holds the pointer to the next node
	 */
	public Node next;

	/**
	 * default constructor
	 */
	public Node() {

	}
	
	/**
	 * constructor to set the next node
	 * @param data
	 * @param next
	 */
	public Node(Character data, Node next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * sets data for a node
	 * @param d
	 */
	void setData(Character d) {
		this.data = d;
	}
}
