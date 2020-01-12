
public class Queue<T> {
	private Node<T> front = null;
	private Node<T> back = null;
	
	Queue() {
	}
	
	Queue(T data) {
		front = new Node<T>(data);
		back = front;
	}

	public void add(T data) {
		Node<T> newBack = new Node<T>(data);
		back.setNext(newBack);
		back = back.getNext();
	}
	
	public Object remove() {
		Node<T> tmpHead = front;
		front = front.getNext();
		tmpHead.setNext(null);
		return tmpHead.getData();
	}
	
	public Object peek() {
		return front.getData();
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public Object peekEnd() {
		return back.getData();
	}
	
}
