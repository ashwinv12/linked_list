/**
 * Linked List
 *
 * 		Class that creates nodes and a linked list
 */
public class LinkedList {
	
	private Node head;
	public int length = 0;

	/**
	 * Constructors
	 * 
	 */

	public LinkedList() {
		this.head = new Node(0, null);
	}



	/**
	 * push
	 *		Given an int, add a new node at the head of the list with this value.
	 *		
	 * @param int value - push takes in the value to store in the new node
	 */
	public static void push(int value) {
		length++;
		Node n = new Node(value, null);
		n.setNext(head.getNext());
	}


	/**
	 * length
	 * 		returns the number of nodes in the linked list
	 * @return length - number of nodes
	 */
	public static int length() {
		return length;
	}


	/**
	 * buildOneTwoThree
	 *
	 * 		Set the values of this list to {1, 2, 3}. Overwrite any previous values in the list. 
	 * 		The length after this operation should be 3.
	 * 
	 */
	public static void buildOneTwoThree() {
		push(1);
		push(2);
		push(3);
	}


}





