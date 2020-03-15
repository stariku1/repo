import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
/**
 * @author sos
 *
 * @param <T>
 * @param <Node>
 */
public class BasicDoubleLinkedList<T> extends Object implements Iterable<T> {
	class Link{
		public Link Before = null;
		public Link After = null;
		public T Info = null;
		public Link() {}
		public Link(T data) {
			Info = data;
		}
	}
	int l = 0;
	Link h = new Link();
	Link t = new Link();
	
	public BasicDoubleLinkedList() {}

	/**
	 *  not traverse the list to compute the size. 
	 * returns the value of the instance variable . 
	 * @return the size of the linked list
	 */
	public int getSize() {
		return l;
	}
	
	/**
	* Adds an element to the end of the list. 
	* Do not use iterators to implement this method. 
	* @param data- the data for the Node within the linked list 
	* @return reference to the current object
	*/	
	public BasicDoubleLinkedList<T> addToEnd(T data){
		l++;
		Link newLink = new Link(data);
		Link tailLink = t.Before;
		if (tailLink!=null) {
			tailLink.After = newLink;
		}
		else {
			h.After = newLink;
		}
		newLink.Before = tailLink;
		t.Before = newLink;
		return this;
	}
	
	/**
	 * Adds element to the front of the list. 
	 * Do not use iterators to implement this method. 
	 * @param datathe data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		l++;
		Link newLink = new Link(data);
		Link headLink = h.After;
		if (headLink!=null) {
			headLink.Before = newLink;
		}
		else {
			t.Before = newLink;
		}
		newLink.After = headLink;
		h.After = newLink;
		return this;
	}
	
	/**
	 * 	Returns but does not remove the first element from the list. 
	 *  Do not implement this method using iterators. 
	 * @return the data element or null
	 */
	public T getFirst() {
		if (l==0) return null;
		return h.After.Info;
	}
	
	/**
	 * Returns but does not remove the last element from the list. 
	 * Do not implement this method using iterators. 
	 * @return the data element or null
	 */
	public T getLast() {
		if (l==0) return null;
		return t.Before.Info;
	}
	
	/**
	 * This method must be implemented using an inner class that implements 
	 * ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous(). 
	 * Remember that we should be able to call the hasNext() method 
	 * as many times as we want without changing what is considered the next element. 
	 * @return
	 * @throws
	 * @throws java.util.NoSuchElementException 
	 */
	public java.util.ListIterator<T> iterator() throws UnsupportedOperationException,NoSuchElementException{
		return new iterate(toArrayList());
	}
	
	/**
	 * Removes the first instance of the targetData from the list. You must use 
	 * 
	 * Do not implement this method using iterators. 
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements 
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData,Comparator<T> comparator){
		if (l==0) return this;
		for (Link i=h.After;i!=null;i=i.After) {
			if (comparator.compare(i.Info, targetData)==0) {
				l--;
				if (i.Before==null) {
					h.After = i.After;
				}
				else {
					i.Before.After = i.After;
				}
				if (i.After==null) {
					t.Before = i.Before;
				}
				else {
					i.After.Before = i.Before;
				}
				return this;
			}
		}
		return this;
	}
	
	/**
	 * Removes and returns the first element from the list. 
	 * Do not implement this method using iterators. 
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		if (l==0) return null;
		l--;
		Link currentLink = h.After;
		h.After = h.After.After;
		if (h.After==null) t.Before=null;
		else h.After.Before = null;
		return currentLink.Info;
	}
	
	/**
	 * Removes and returns the last element from the list. 
	 * Do not implement implement this method using iterators. 
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		if (l==0) return null;
		l--;
		Link currentLink = t.Before;
		t.Before = t.Before.Before;
		if (t.Before==null) h.After=null;
		else t.Before.After = null;
		return currentLink.Info;
	}
	
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list 
	 * @return an arraylist of the items in the list
	 */
	public java.util.ArrayList<T> toArrayList(){
		java.util.ArrayList<T> LinkArrayList = new java.util.ArrayList<T>();
		for (Link i=h.After;i!=null;i=i.After) {
			LinkArrayList.add(i.Info);
		}
		return LinkArrayList;
	
	}

	class iterate implements java.util.ListIterator<T>{
		java.util.ListIterator<T> LIST;
		public iterate(ArrayList<T> a) {LIST = a.listIterator();}
		@Override
		public void add(T e) {throw new UnsupportedOperationException();}
		@Override
		public boolean hasNext() {return LIST.hasNext();}
		@Override
		public boolean hasPrevious() {return LIST.hasPrevious();}
		@Override
		public T next() {return LIST.next();}
		@Override
		public int nextIndex() {throw new UnsupportedOperationException();}
		@Override
		public T previous() {return LIST.previous();}
		@Override
		public int previousIndex() {throw new UnsupportedOperationException();}
		@Override
		public void remove() {throw new UnsupportedOperationException();}
		@Override
		public void set(T e) {throw new UnsupportedOperationException();}
	}
}