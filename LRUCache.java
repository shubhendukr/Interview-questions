package system.design;
/**
 * Design and Implement a data structure for Least Recently Used Cache
 */
import java.util.HashMap;
import java.util.Map;

class LRUCache {
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
	}
		
	private void addNode(DLinkedNode node) {
		// always add the new node right after head
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	private void removeNode(DLinkedNode node) {
		// remove an existing node from the linked list
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;
		
		prev.next = next;
		next.prev = prev;
	}
		
	private void moveToHead(DLinkedNode node) {
		// move certain node in between to the head
		removeNode(node);
		addNode(node);
	}
	
	private DLinkedNode popTail() {
		// pop the current tail
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res;
	}
		
	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DLinkedNode head, tail;
	
	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
		
	}
	
	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		moveToHead(node);
		
		return node.value;
	}
	
	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		
		if (node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			
			cache.put(key, newNode);
			addNode(newNode);
			
			++size;
			
			if (size > capacity) {
				// pop the tail
				DLinkedNode tail = popTail();
				cache.remove(tail.key);
				--size;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}
}

class Main {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.put(1, 100);
		cache.put(2, 200);
		System.out.println("Value for Key 1: " + cache.get(1));
		System.out.println("Value for Key 2: " + cache.get(2));
		cache.put(3, 300);
		cache.put(4, 400);
		cache.put(5, 500);
		cache.put(6, 600);
		System.out.println("Value for Key 5: " + cache.get(5));
		System.out.println("Value for Key 2: " + cache.get(2));
	}
}
