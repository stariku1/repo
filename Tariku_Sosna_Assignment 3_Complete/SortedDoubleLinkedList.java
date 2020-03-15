import java.util.Comparator;
import java.util.ListIterator;

/**
 * 
 * @author sos
 *
 * @param <T>
 */

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	Comparator<T> compare;
	/**
	 * @param comparator
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.compare = comparator;
	}
	
	/**
	 * @param data
	 * @return
	 */
	public SortedDoubleLinkedList<T>add(T data){
		super.addToFront(data);
		for (Link i=h.After;i!=null;i=i.After) {
			if (i.After!=null && compare.compare(i.Info, i.After.Info)>0) {
				T info = i.After.Info;
				i.After.Info = i.Info;
				i.Info = info;
			}
		}
		return this;
	}
	
	public BasicDoubleLinkedList<T> addToEnd(T store) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public BasicDoubleLinkedList<T> addToFront(T store) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
		super.remove(data, comparator);
		return this;
	}
}
