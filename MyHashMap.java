public class HashMap<K, V> {

	private Entry<K, V>[] entryTable;
	private int initialCapacity = 16;

	@SuppressWarnings("unchecked")
	public HashMap() {
		entryTable = new Entry[initialCapacity];
	}

	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		initialCapacity = capacity;
		entryTable = new Entry[initialCapacity];
	}

	public void put(K key, V value) {
		if (key == null) {
			throw new RuntimeException("null key is not allowed");
		}
		// hash value of the key
		int hashValue = hashValue(key);
		// create the entry
		Entry<K, V> entry = new Entry<K, V>(key, value, null);

		// if no entry found at the hash value index of the entry table then put
		// the value
		if (entryTable[hashValue] == null) {
			entryTable[hashValue] = entry;
		} else {// if found then put the value in a linked list
			Entry<K, V> previous = null;
			Entry<K, V> current = entryTable[hashValue];
			while (current != null) {
				if (current.k.equals(key)) {
					if (previous == null) {
						entry.next = current.next;
						entryTable[hashValue] = entry;
					} else {
						entry.next = current.next;
						previous.next = entry;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = entry;
		}

	}

	public V get(K key) {
		if (key == null) {
			return null;
		}
		// hash value of the key
		int hashValue = hashValue(key);
		if (entryTable[hashValue] == null) {
			return null;
		} else {
			Entry<K, V> temp = entryTable[hashValue];
			while (temp != null) {
				if (temp.k.equals(key)) {
					return temp.v;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	public boolean remove(K key) {
		if (key == null) {
			return false;
		}
		// hash value of the key
		int hashValue = hashValue(key);
		if (entryTable[hashValue] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = entryTable[hashValue];
			while (current != null) {
				if (current.k.equals(key)) {
					if (previous == null) {
						entryTable[hashValue] = entryTable[hashValue].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}

	public boolean containsKey(K key) {
		int hashValue = hashValue(key);
		if (entryTable[hashValue] == null) {
			return false;
		} else {
			Entry<K, V> current = entryTable[hashValue];
			while (current != null) {
				if (current.k.equals(key)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

	public int size() {
		int count = 0;
		for (int i = 0; i < entryTable.length; i++) {
			if (entryTable[i] != null) {
				int nodeCount = 0;
				for (Entry<K, V> e = entryTable[i]; e.next != null; e = e.next) {
					nodeCount++;
				}
				count += nodeCount;
				count++;// consider also vertical count
			}
		}
		return count;
	}

	private int hashValue(K key) {
		return Math.abs(key.hashCode()) % initialCapacity;
	}

	private static class Entry<K, V> {
		private K k;
		private V v;
		private Entry<K, V> next;

		public Entry(K k, V v, Entry<K, V> next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}

	}

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>(3);
		map.put(1, "Hello");
		map.put(2, "World");

		System.out.println("Size: " + map.size());

		String hello = map.get(1);
		String world = map.get(2);

		System.out.println(hello + " " + world);

		System.out.println("Contains Key 1: " + map.containsKey(1));
		System.out.println("Contains Key 2: " + map.containsKey(2));
		System.out.println("Contains Key 3: " + map.containsKey(3));

		map.put(3, "Dummy");

		System.out.println("Contains Key 3: " + map.containsKey(3));
		System.out.println("Size: " + map.size());

		map.remove(3);

		System.out.println("Contains Key 3: " + map.containsKey(3));
		System.out.println("Size: " + map.size());

		HashMap<String, String> map2 = new HashMap<>();
		map2.put("1", "Hello");
		map2.put("2", "World");
		map2.put("3", "Hello");
		map2.put("4", "World");
		map2.put("5", "Hello");
		map2.put("6", "World");
		map2.put("7", "Hello");
		map2.put("8", "World");
		map2.put("9", "Hello");
		map2.put("10", "World");
		map2.put("11", "Hello");
		map2.put("12", "World");
		map2.put("13", "Hello");
		map2.put("14", "World");
		map2.put("15", "Hello");
		map2.put("16", "World");

		System.out.println("map2 size: " + map2.size());
		System.out.println("Get Key 1: " + map2.get("1"));
		System.out.println("Get Key 11: " + map2.get("11"));
		System.out.println("Get Key 6: " + map2.get("6"));
		System.out.println("Get Key 16: " + map2.get("16"));
	}

}
