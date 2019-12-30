
public class Node<T> {
	private T data;
	private Node next;
	
	Node() {
		this(null);
	}
	
	Node(T data) {
		this.data = data;
		this.next = null;
	}
	
	public Node getNext() {
		return next;
	}
	
	public T getData() {
		return data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
}
