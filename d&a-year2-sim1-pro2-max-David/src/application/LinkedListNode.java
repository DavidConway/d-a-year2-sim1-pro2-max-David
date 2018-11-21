package application;

public class LinkedListNode<T> {

	private T contents;
	private int i;
	private int temp;

	public LinkedListNode<T> next = null;

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}

	public T getContents() {
		return contents;
	}

	public int getIndex() {
		return i;
	}

	public void setIndex(int index) {
		this.i = index;
	}

	public int getTempIndex() {
		return temp;
	}

	public void setTempIndex(int temp) {
		this.temp = temp;
	}

	public String toString() {
		return contents.toString();
	}

}
