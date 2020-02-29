/**
 * 
 * @author tz_as
 *
 * @param <T> data type
 */
public class MyQueue<T> implements QueueInterface<T> {
	/**
	 * size
	 */
	int size;
	/**
	 * array
	 */
	T[] queueArray;
	/**
	 * last index
	 */
	int endIndex;

	/**
	 * constructor with default values
	 */
	public MyQueue() {

		size = 5;
		queueArray = (T[]) new Object[size];
		endIndex = -1;
	}

	/**
	 * constructor with set size
	 * 
	 * @param size with pre-set size
	 */
	public MyQueue(int size) {
		this.size = size;
		queueArray = (T[]) new Object[size];
		endIndex = -1;
	}

	/**
	 * empty info
	 * 
	 * @return empty or not
	 */
	@Override
	public boolean isEmpty() {
		return (endIndex == -1);
	}

	/**
	 * full info
	 * 
	 * @return full or not
	 */
	@Override
	public boolean isFull() {
		return (endIndex == (size - 1));
	}

	/**
	 * dequeue out
	 * 
	 * @return dequeued T
	 */
	@Override
	public T dequeue() {
		if (!isEmpty()) {
			T first = queueArray[0];
			for (int i = 0; i < queueArray.length - 1; i++) {
				queueArray[i] = queueArray[i + 1];
			}
			endIndex--;
			return first;
		}
		return null;
	}

	/**
	 * size
	 * 
	 * @return amount
	 */
	@Override
	public int size() {
		int amount = 0;
		for (int i = 0; i < queueArray.length; i++) {
			if (queueArray[i] != null)
				amount++;
		}
		return amount;
	}

	/**
	 * enqueue
	 * 
	 * @return enqueued or not
	 */
	@Override
	public boolean enqueue(T e) {
		if (!isFull()) {
			queueArray[++endIndex] = e;
			return true;
		}
		return false;
	}

	/**
	 * return the array
	 * 
	 * @return array
	 */
	@Override
	public T[] toArray() {
		return queueArray;
	}

}
