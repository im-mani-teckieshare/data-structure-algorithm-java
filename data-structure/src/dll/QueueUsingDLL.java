package dll;

public class QueueUsingDLL {

	private DLL list = null;
	
	public QueueUsingDLL() {
		this.list = new DLL();
	}
	
	public void enqueue(int data) {
		list.add(data);
		System.out.println(data+" Enqueue into Queue");
		
	}
	
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("QUeue is Empty");
			return;
		}
		int data = front();
		list.remove(0);
		System.out.println(data+" Dequeued from Queue");
	}
	
	public int front() {
		return list.get(0);
	}
	
	public int rear() {
		return list.get(size()-1);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	public static void main(String[] args) {
		QueueUsingDLL q = new QueueUsingDLL();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		System.out.println(q);
		q.dequeue();
		System.out.println(q);
		System.out.println("Front element is "+q.front());
		System.out.println("Rear element is "+q.rear());
		q.dequeue();
		q.dequeue();
		System.out.println(q);
		System.out.println("Size of the Queue is "+q.size());
		System.out.println("Is Queue empty : "+q.isEmpty());
		

	}

}
