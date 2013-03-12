/**
 * Linked List
 *
 * 		Class that creates nodes and a linked list
 */
public class LinkedList {
	
	private Node head;


	/**
	 * Constructors
	 * 
	 */

	public LinkedList() {
		this.head = new Node(0, null);
	}



	/**
	 * push
	 *
	 * @param int value - push takes in the value to store in the new node
	 */
	public static void push(int value) {
		Node n = new Node(value, null);
		n.setNext(head.getNext());
	}

	
}