public class MyStack<V> {
	private class Node {
		V value;
		Node next;
		public Node(V value) {
			this.value = value;
		}
	}

	private int size;
	private Node head;

	@SuppressWarnings("unchecked")
	public MyStack() {
		size = 0;
		head = null;
	}

	public void push(V value) {
		Node newNode = new Node(value);
		if(head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public V pop() {
		if(head == null)
			return null;
		Node node = head;
		head = head.next;
		size--;

		return node.value;
	}

	public V peek() {
		if(head == null)
			return null;
		return head.value;
	}

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		System.out.println("Is stack empty ? "+myStack.isEmpty());
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);

		System.out.println(myStack.size());

		System.out.println("Pop from Stack : "+myStack.pop());
		System.out.println("Is stack empty ? "+myStack.isEmpty());
		System.out.println("Peek from Stack : "+myStack.peek());
	}
}