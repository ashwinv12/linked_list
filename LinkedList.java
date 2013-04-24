/**
 * Linked List
 *
 * 		Class that creates nodes and a linked list
 */
public class LinkedList {
	
	private Node head, current;
	

	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		// l.test();
	}

	/**
	 * Constructors
	 * 
	 */

	public LinkedList() {
		this.head = new Node(0, null);
	}

	public Node getHead() {
		return head;
	}


	// methods

	/**
	 * push
	 *		Given an int, add a new node at the head of the list with this value.
	 *		
	 * @param int value - push takes in the value to store in the new node
	 */
	public void push(int value) {
		// length++;
		Node n = new Node(value, head.getNext());
		head.setNext(n);
	}

	
	/**
	 * length
	 * 		returns the number of nodes in the linked list
	 * @return length - number of nodes
	 */
	public int length() {
		int length = 0;
		Node next = head;
		while (next.getNext() != null) {
			next = next.getNext();
			length++;
		}
		return length;
	}
	
	/**
	 * getLength
	 * 		gets the length of the LinkedList for test code to run
	 */
	public int getLength() {
		int length = 0;
		Node next = head;
		while (next.getNext() != null) {
			next = next.getNext();
			length++;
		}
		return length;
	}

	/**
	 * buildOneTwoThree
	 *
	 * 		Set the values of this list to {1, 2, 3}. Overwrite any previous values in the list. 
	 * 		The length after this operation should be 3.
	 * 
	 */
	public void buildOneTwoThree(){
		clear();
		push(3);
		push(2);
		push(1);

	}


	/**
	 * print
	 *
	 * 		Print the list. Start at the head, then move from node to node until you reach the end of the list.
	 */
	public void print() {
		if (head == null || head.getNext() == null) {
			System.out.println("List is Empty");
			return;
		}
		
		Node current = head.getNext();
		while (current != null) {
			System.out.print(current.getValue() + "  ");
			current = current.getNext();
		}
	}

	

	/**
	 * count
	 *
	 * 		Given an int, return how many times it occurs in the list.
	 * @param check - the number that you want to check to see if it appears in the list
	 * @return count - the number of times "check" appears in the list
	 */
	public int count(int check) {
		Node next = head;
		int count = 0;
		while (next.getNext()!=null) {
			next = next.getNext();
			if (next.getValue() == check) {
				count++;
			}
		}
		return count;
	}


	/**
	 * getNth
	 *
	 * 		Given an index, return the value of the node at that index.
	 *
	 * @param index - the index given to search for the node in that place
	 * @return nodeindex - the node at the given index
	 */
	public int getNth(int index) {
		Node current = head;
		
		for (int i=0;i<length();i++) {
			current = current.getNext();
			
			if (i==index) {
				return current.getValue();
			}
			
			
		}
		return -1;
	}

	/**
	*clear
	*	empties the list
	*/
	public void clear() {
		head = new Node();
		// length = 0;
	}

	/**
	*empty
	*	empties the list
	*/
	public void empty() {
		head.setNext(null);
	}

	/**
	 * pop
	 * 
	 * precondition - list is not empty
	 * @return current.getValue() - value of the node closest to head
	 */
	public int pop(){
		Node first = head.getNext();
		Node now = first.getNext();
		head.setNext(now);
		return first.getValue();
	}


	/**
	 * linearSearch
	 * 		Given an int n, returns the index where it is found
	 *
	 * @param n - the number you want to find the index of
	 *
	 * @return index - index of n
	 */
	public int linearSearch(int n) {
		int index = 0;
		Node current = head;
	 	// boolean found = false;
		while(current.getNext()!=null) {
			current = current.getNext();
			if(current.getValue() == n) {
				return index;
			}
			index++;
		}
		return -1;
	}
        /**
	 * insertNth
	 * 		insert the given value into the linked list at the given  index
	 *
	 * @param value - value that the user wants inserted into the linkedList
	 * @param  index - index that you want the value to be inserted into
	 */

        public void insertNth(int value, int index){
        	Node n = new Node(index);
        	Node now = head;
        	if(value == 0){
        		push(index);
        	}
        	if(value > length()){
        		return;
        	}
        	for(int i = 0; i<=value; i++){
        		now = now.getNext();
        		if(i == value-1){
        			n.setNext(now.getNext());
        			now.setNext(n);
        		}
        	}
        }
        /**
	 * sortedInsert
	 * 		creates and inserts a node into a sorted linkedList so that the list stays sorted
	 *
	 * precondition: the list must be sorted in ascending order
	 * @param  value - value of the node you want to insert
	 * 
	 */
        public void sortedInsert(int value){
        	Node now = head.getNext();
        	int index = 0;
        	boolean run = true;
        	if(now != null){
        		while(run && now.getValue()<value){
        			index++;
        			if(now.getNext() != null){
        				now = now.getNext();
        			}else{
        				run = false;
        			}	
        		}
        	}	
        	insertNth(index, value);
        }

	/**
	* insertSort
	*		rearranges nodes in list so they are sorted in ascending order
	*
	**/
	public void insertSort() {
		int[] values = new int[length()];
		Node now = head;
		for(int i = 0; i<length(); i++){
			now = now.getNext();
			values[i] = now.getValue();
		}
		empty();
		for(int i = 0; i<values.length; i++){
			sortedInsert(values[i]);
		}
	}
    	/**
	* append
	*	given another LinkedList, appends the values from that list to the end of this list
	*
	*@param list - the LinkedList you wish to append to this list
	*
	**/
	public void append(LinkedList list) {
		Node next = head;
		while(next.getNext()!=null) {
			next = next.getNext();
		}
		next.setNext(list.getHead().getNext());
	}
		/**
	* frontBackSplit
	*		return a length 2 array of LinkedLists that contains the front and back halves of the list
	*
	*@return LinkedList[2]
	*
	**/
	public LinkedList[] frontBackSplit() {
		LinkedList[] a = new LinkedList[2];
		if (length() == 0) {
			LinkedList[] empty = new LinkedList[2];
			empty[0] = new LinkedList();
			empty[1] = new LinkedList();
			return empty;
		}
		int length = length()/2;
		int index = 0;
		Node next = head;
		if(head.getNext()==null) {
			return a;
		}
		
		next = head.getNext();
		a[0] = new LinkedList();
		a[1] = new LinkedList();
		int[] front = new int[length()/2];
		int j = 0;
		while(index<length()/2) {
			front[j] = next.getValue();
			next = next.getNext();
			index++;
			j++;
		}
		int[] back = new int[length()-index];
		j=0;
		while(index<length()) {
			back[j] = next.getValue();
			next = next.getNext();
			index++;
			j++;
		}
		for(int i = front.length-1; i >= 0; i--) {
			a[0].push(front[i]);
		}
		for(int i = back.length-1; i>= 0; i--) {
			a[1].push(back[i]);
		}
                // System.out.println();
                // a[0].print();
                // System.out.println();
                // a[1].print();
		return a;
		
	}

	

        /**
	* removeDuplicates
	* 		deletes any duplicate nodes from the list
	*
	*precondition: the list must be sorted in increasing order
	*
	**/
	public void removeDuplicates() {
		insertSort();
		
		if (length() <2) {
			return;
		}
		Node now = head.getNext();
		Node next = now.getNext();
		for(int i = 1; i < length(); i++){
			while(now != null && next != null && now.getValue() == next.getValue()){
				now.setNext(next.getNext());
				next = now.getNext();
			}
			if(now != null){
				now = now.getNext();
			}
			if(now != null && now.getNext() != null){	
				next = now.getNext();
			}	
		}

	}
	
	
	

	// Merge Sort methods

	private void insert(int value, Node next) {
		next.setNext(new Node(value, next.getNext()));
	}

        /**
	* alternatingSplit
	*		returns a length 2 array of LinkedLists; the first list consists of the values of the odd nodes, and the second consists of the values of the even nodes
	*
	*@return LinkedList[2]
	*
	**/
	public LinkedList[] alternatingSplit() {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList[] listarray = {list1, list2};
		Node current = head;
		int length = length();
		int[] listvalues = new int[length];

		for (int i=0;i<length;i++) {
			current = current.getNext();
			listvalues[i] = current.getValue();
		}
		for (int i=length-1;i>=0;i--) {
			if (i%2 != 0) {
				second.push(values[i]);
			}
			else {
				first.push(values[i]);
			}
		}
		return listvalues;
	}


		/**
	* sortedMerge
	*		takes in 2 LinkedLists and returns the result of merging the 2 lists 
	*			and organizing the result in ascending order
	*
	*@param a - the first list you want to merge
	*@param b - the second list you want to merge
	*
	* precondition: both a and b must be sorted in ascending order 
	*
	*@return LinkedList
	*
	**/
	public static LinkedList sortedMerge(LinkedList a, LinkedList b) {
		LinkedList sortedList = new LinkedList();
		Node headA = a.getHead().getNext();
		Node headB = b.getHead().getNext();
		Node sortedHead = sortedList.getHead();

		while (headA != null && headB != null) {

			if (headA.getValue() < headB.getValue()) {
				sortedList.insert(headA.getValue(), sortedHead);
				headA = headA.getNext();
				
				
			}
			else {
				sortedList.insert(headB.getValue(), sortedHead);
				headB = headB.getNext();
				
			}
			
			sortedHead = sortedHead.getNext();
			
		}
		
		
		while (headA != null) {
			sortedList.insert(headA.getValue(), sortedHead);
			headA = headA.getNext();
			sortedHead = sortedHead.getNext();
		}

		while (headB != null) {
			sortedList.insert(headB.getValue(), sortedHead);
			headB = headB.getNext();
			sortedHead = sortedHead.getNext();
		}
		
		
		return sortedList;
	}


 //        
         /*

	 * mergeSort
	 * 		takes in a LinkedList and sorts it ascendingly
	 *
	 *
	 * @return  LinkedList
	 */
         public LinkedList mergeSort() {
         	if(length() <= 1){
         		return this;
         	}

         	LinkedList[] sortedList = this.frontBackSplit();
         	return sortedMerge(sortedList[0].mergeSort(), sortedList[1].mergeSort());
         }


	/**
	 * makeReverse
	 * 		make and return a reversed version of this list
	 *
	 * @return  reversedList - the list in reverse order
	 */
	public LinkedList makeReverse() {
		LinkedList reversedList = new LinkedList();
		int length = length();
		Node current = head;

		for (int i=0;i<length;i++) {
			current = current.getNext();
			reversedList.push(current.getValue());
		}

		return reversedList;
	}


	// Reversal

	/**
	 * reverse 
	 * 		reverses the original list by iteratively rearranging all the next references
	 */
	public void reverse() {
		int length = length();
		if (length<=1) {
			return;
		}

		Node current = head;
		Node last = head;
		Node temp;

		for (int i=0;i<length;i++) {
			for (int j=0;j<length;j++) {
				last = last.getNext();
			}

			temp = current.getNext();
			current.setNext(last);
			last.setNext(temp);
			current = current.getNext();

			if (i == length-1) {
				last.setNext(null);
			}

			else {
				last = head;
			}
		}
	}

	/**
	* recursiveReverse
	*    reverses the original list recursively
	*
	**/	
	public void recursiveReverse() {
		int length = length();
		if (length<=1) {
			return;
		}
		Node last = helpReverse(head.getNext());
		last.setNext(null);
	}


	/**
	* helpReverse
	*    private method that actually does the sorting in recursiveReverse
	*
	* @param node - first Node in a list that needs to be reversed
	*
	* @return Node
	**/
	private Node helpReverse(Node node) {
		if (node.getNext() == null) {
			return null;
		}

		return helpReverse(node.getNext()).setNext(node);
	}





}





