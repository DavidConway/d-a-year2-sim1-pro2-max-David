package application;

public class LinkedList<T> {

	private LinkedListNode<T> head = null;
	private LinkedListNode<T> temp = null;
	private int size;
	
	public void add(T contents) {
		LinkedListNode<T> node = new LinkedListNode<>();
		node.next = head;
		head = node;
		node.setContents(contents);
		node.setIndex(size()-1);
	}

	public void remove(int index) {
		if (head.getIndex() == index) // if need to delete head
		{
			head = head.next; // just move head to the next node
		} else {
			temp = head;
			while (temp != null && temp.next != null) {
				if (temp.next.getIndex() == index) {
					index(temp.next);
					temp.next = temp.next.next;
					temp = null;
				}
			}
		}
	}

	public LinkedListNode<T> get(int i) {
		LinkedListNode<T> temp;
		temp = head;
		if (temp != null && temp.next == null) {
			return temp;
		}

		else {
			while (temp.getIndex() != i && temp.next != null) {
				temp = temp.next;
			}
		}
		return temp;
	}

	public int size() {
		int t = 0;
		temp = head;
		while (temp != null && temp.next != null) {
			temp = temp.next;
			t++;
		}
		if (temp != null && temp.next == null) {
			t++;
		}
		size = t;
		temp = null;
		return size;
	}

	public void index(LinkedListNode<T> node) {
		if (node.next !=null) {
			while (node.next != null)
			{
				node.next.setIndex(node.next.getIndex()-1);
				node = node.next;
			}
		}	
	}

	public void clear() {
		LinkedListNode<T> node = null;
		head = node;

	}
}
