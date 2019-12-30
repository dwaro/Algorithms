
public class Stack<T> {
	private Node top;
	
	Stack() {
		top = null;
	}
	
	Stack(T data) {
		top = new Node(data);
	}
	
	public void push(T data) {
		Node newTop = new Node(data);
		newTop.setNext(top);
		top = newTop;
	}
	
	public Object poll() {
		Node oldTop = top;
		Node newTop = top.getNext();
		top.setNext(null);
		top = newTop;
		return oldTop.getData();
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public Object peek() {
		return top.getData();
	}
}
