public class SinglyNode {
	private int val;
	private SinglyNode next;
	
	public SinglyNode() {
		this(-1, null);
	}
	
	public SinglyNode(int val) {
		this(val, null);
	}
	
	public SinglyNode(int val, SinglyNode next) {
		this.val = val;
		this.next = next;
	}
	
	public int getVal() {
		return this.val;
	}
	
	public SinglyNode getNext() {
		return this.next;
	}
	
	public void getVal(int val) {
		this.val = val;
	}
	
	public void setNext(SinglyNode next) {
		this.next = next;
	}
}
