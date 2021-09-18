package map;

public class HashMap {
	
	class HashNode{
		String key;
		String value;
		HashNode next;
		public HashNode(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
	}
	
	private HashNode[] hashTable = null;
	private int bucketSize = 16;
	private int size = 0;
	
	public HashMap() {
		this.hashTable = new HashNode[bucketSize];
	}
	
	
	public void put(String key, String value) {
		int position = hash(key);
		HashNode curr = hashTable[position];
		if(curr == null) {
		hashTable[position] = createHashNode(key, value);
		size++;
		}else {
			while(curr.next != null && curr.key != key) {
				curr = curr.next;
			}
			if(curr.key == key) {
				curr.value = value;
			}else {
			curr.next = createHashNode(key,value);
			size++;
			}
		}
	}
	
	public HashNode createHashNode(String key,String value) {
		return new HashNode(key, value);
	}
	
	public String get(String key) {
		HashNode target = find(key);
		if(target == null) return null;
		return target.value;
	}
	
	public boolean contains(String key) {
		HashNode target = find(key);
		return target != null;
	}
	
	public boolean remove(String key) {
		int position = hash(key);
		HashNode targetNode = hashTable[position];
		HashNode prev = null;
		HashNode curr = targetNode;
		while(curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}
		if(curr == null) return false;
		if(prev == null) {
			hashTable[position] = curr.next;
		}else {
			prev.next = curr.next;
		}
		curr.next = null;
		afterRemoveNode(curr);
		size--;
		return true;
	}
	
	public void afterRemoveNode(HashNode curr) {
		
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		size = 0;
		this.hashTable = new HashNode[bucketSize];
	}
	
	private HashNode find(String key) {
		int position = hash(key);
		HashNode targetNode = hashTable[position];
		if(targetNode == null)return null;
		else {
			while(targetNode != null && targetNode.key != key) {
				targetNode = targetNode.next;
			}
		}
		return targetNode;
	}
	
	private int hash(String key) {
		return Math.abs(key.hashCode()) % bucketSize;
	}
	
	public String toString() {
		StringBuffer buf =new StringBuffer();
		buf.append("{");
		for(int i=0;i<bucketSize;i++) {
			HashNode node = hashTable[i];
			while(node != null) {
				buf.append(node.key).append("=").append(node.value);
				buf.append(",");
				node = node.next;
			}
		}
		if(buf.length() >1) {
			buf.deleteCharAt(buf.length()-1);
		}
		buf.append("}");
		return buf.toString();
	}
	
	
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("one", "ONE");
		map.put("two", "TWO");
		map.put("three", "THREE");
		map.put("four", "FOUR");
		map.put("five", "Five");
		map.put("six", "SIX");
		System.out.println(map);
	}
}
