/**
 * 
 * @author tz_as
 *
 * @param <T> data type
 */
public class MyStack<T> implements StackInterface<T> {
	/**
	 * size
	 */
	int size;
	/**
	 * stack array
	 */
	T[] stackArray;
	/**
	 * last index
	 */
	int endIndex;

	/**
	 * constructor with default values
	 */

	public MyStack() {
		size = 5;
		stackArray = (T[]) new Object[size];
		endIndex = -1;
	}

	/**
	 * constructor with user set size
	 * 
	 * @param size size
	 */
	public MyStack(int size) {
		this.size = size;
		stackArray = (T[]) new Object[size];
		endIndex = -1;
	}

	/**
	 * is empty
	 * 
	 * @return empty or not
	 */
	@Override
	public boolean isEmpty() {
		return (endIndex == -1);
	}

	/**
	 * is full
	 * 
	 * @return full or not
	 */
	@Override
	public boolean isFull() {
		return (endIndex == (size - 1));
	}

	/**
	 * pop T
	 * 
	 * @return popped T
	 */
	@Override
	public T pop() {
		if (!isEmpty()) {
			T first = stackArray[endIndex];
			stackArray[endIndex--] = null;
			return first;
		}
		return null;
	}

	/**
	 * amount
	 * 
	 * @return amount
	 */
	@Override
	public int size() {
		int amount = 0;
		for (int i = 0; i < stackArray.length; i++) {
			if (stackArray[i] != null)
				amount++;
		}
		return amount;
	}

	/**
	 * push T
	 * 
	 * @return pushed or not
	 */
	@Override
	public boolean push(T e) {
		if (!isFull()) {
			stackArray[++endIndex] = e;
			return true;
		}
		return false;
	}

	/**
	 * toArray
	 * 
	 * @return array
	 */
	@Override
	public T[] toArray() {
		return stackArray;
	}

}
