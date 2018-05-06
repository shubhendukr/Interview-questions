import java.util.Arrays;

class ArrayList<E> {
	private Object[] data;
	private int count;
	private int SIZE = 10;

	public ArrayList() {
		data = new Object[this.SIZE];
	}

	public ArrayList(int initialSize){ 
		data = new Object[initialSize];
	}

	public void reSizeArray() {
		data = Arrays.copyOf(data, data.length * 2);
	}

	public void add(Object obj) {
		if(data.length - count <= data.length / 2) {
			this.reSizeArray();
		}
		data[count++] = obj;
	}

	public int size() {
		return count;
	}

	public Object get(int index) {
		if(index < count)
			return data[index];
		else
			throw new ArrayIndexOutOfBoundsException();
	}

	public Object remove(int index) {
		if(index < count) {
			Object obj = data[index];
			int temp = index;
			data[index] = null;

			while(temp < count) {
				data[temp] = data[temp +1];
				data[temp + 1] = null;
				temp++;
			}
			count--;
			return obj;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+" ");
		System.out.println();
		list.add(4);
		System.out.println("Element at Index 3 : "+list.get(3));
		System.out.println("Element removed from Index 1 : "+list.remove(1));
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+" ");
		System.out.println();
	}
}