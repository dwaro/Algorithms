
public class Stack<T> {
	private Node<T> top;
	
	Stack() {
		top = null;
	}
	
	Stack(T data) {
		top = new Node<T>(data);
	}
	
	public void push(T data) {
		Node<T> newTop = new Node<T>(data);
		newTop.setNext(top);
		top = newTop;
	}
	
	public Object poll() {
		Node<T> oldTop = top;
		Node<T> newTop = top.getNext();
		top.setNext(null);
		top = newTop;
		return oldTop.getData();
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public Object peek() {
		if (top == null) return null;
		return top.getData();
	}
}
