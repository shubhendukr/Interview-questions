import java.util.Arrays;

public class MyMinHeap {
	int capacity = 15;
	int size = 0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex) {
		return 2*parentIndex + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return 2*parentIndex + 2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex - 1)/2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	private void ensureCapacity() {
		if(items.length == size) {
			items = Arrays.copyOf(items, 2*capacity);
			capacity *= 2;
		}
	}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	public int peek() {
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && (rightChild(index) < items[smallerChildIndex])) {
				smallerChildIndex = getRightChildIndex(index);
			}
			if(parent(index) < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}
	}
	
	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && (parent(index) > items[index])) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	public static void main(String[] args) {
		MyMinHeap minHeap = new MyMinHeap();
		minHeap.add(20);
		minHeap.add(40);
		minHeap.add(10);
		minHeap.add(15);
		System.out.println(minHeap.peek());
		minHeap.poll();
		System.out.println(minHeap.peek());
	}
}
