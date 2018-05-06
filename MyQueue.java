public class MyQueue<V> {
	private class Node<V> {
		V value;
		Node next;
		public Node(V value) {
			this.value = value;
		}
	}

	private int size;
	private Node<V> head;
	private Node<V> tail;

	@SuppressWarnings("unchecked")
	public MyQueue() {
		size = 0;
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public void add(V value) {
		if(head == null) {
			head = new Node(value);
			tail = head;
		}
		else {
			tail.next = new Node(value);
			tail = tail.next;
		}
		size++;
	}

	public V remove() {
		if(size == 0)
			return null;
		V value = head.value;
		head = head.next;
		size--;

		return value;
	}

	public V peek() {
		if(size == 0)
			return null;
		return head.value;
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		System.out.println("Is Queue Empty ? "+myQueue.isEmpty());
		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);

		System.out.println("Queue Size : "+myQueue.size());

		System.out.println("Removing from Queue : "+myQueue.remove());
		System.out.println("Is Queue Empty ? "+myQueue.isEmpty());
		System.out.println("Peeking in Queue : "+myQueue.peek());
	}
}