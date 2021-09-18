package arraylist;

public class ArrayList {
	
	int arr[] = null;
	int capacity = 10;
	
	int size = 0;
	
	public ArrayList() {
		this.arr = new int[capacity];
	}
	public ArrayList(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
	}
	
	public void add(int data) {
		ensureCapacity();
		arr[size++] = data;
		System.out.println(data+" inserted into List");
	}
	
	public void add(int data, int index) {
		if(index > (size-1) || index < 0) {
			System.out.println("index out of bound");
			return;
		}
		ensureCapacity();
		for(int i = size;i>index;i--) {
			arr[i] = arr[i-1];
		}
		arr[index] = data;
		size++;
		System.out.println(data+" inserted into List");
	}
	
	public void remove(int index) {
		if(index > (size-1) || index < 0) {
			System.out.println("Index out of bound");
			return;
		}
		int data = arr[index];
		for (int i = index; i < size-1; i++) {
			arr[i] = arr[i+1];
		}
		size--;
		System.out.println(data+" removed from List");
	}
	
	public void removeObject(int data) {
		remove(indexOf(data));
	}
	
	public int indexOf(int data) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if(arr[i] == data) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int lastIndexOf(int data) {
		int index = -1;
		for (int i = size-1; i >=0; i--) {
			if(arr[i] == data) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public boolean contains(int data) {
		return indexOf(data) != -1;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			System.out.println("ArrayContainer Overflow");
			capacity = capacity + (capacity >> 1);
			System.out.println("The new capacity is "+ capacity);
			int newArr[] = new int[capacity];
			for (int i = 0; i < size; i++) {
				newArr[i] = arr[i];
			}
			this.arr = newArr;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(arr[i]).append(",");
		}
		if(sb.length()>1) {
		sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayList ls = new ArrayList();
		ls.add(10);
		ls.add(20);
		ls.add(30);
		ls.add(10);
		System.out.println(ls);
		System.out.println("Size of the List is "+ls.size());
		System.out.println("Is List Empty : "+ls.isEmpty());
		ls.clear();
		System.out.println("After clear the List.........");
		System.out.println("Is List Empty : "+ls.isEmpty());
		System.out.println(ls);
		System.out.println("Size of the List is "+ls.size());
	}

}
