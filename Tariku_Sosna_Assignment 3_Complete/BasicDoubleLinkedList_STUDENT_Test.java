//package _solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("Lambo", "F150", 2020);
	public Car b=new Car("Ferrari", "Renegade", 2020);
	public Car c=new Car("Buggati", "Civic", 2020);
	public Car d=new Car("BMW", "Outback", 2020);
	public Car e=new Car("McLaren", "Silverado", 2020);
	public Car f=new Car("Tesla", "PTCruiser", 2020);

	public ArrayList<Car> fill = new ArrayList<Car>();
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("SUPERCARS");
		linkedString.addToEnd("WORLDSTAR");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
		linkedCar= new BasicDoubleLinkedList<Car>();
		linkedCar.addToEnd(b);
		linkedCar.addToEnd(c);
		comparatorCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedCar = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedCar.getSize());
	}
	
	private void assertEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testAddToEnd() {
		assertEquals("WORLDSTAR", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d,linkedCar.getLast());
	}
	
	private void assertEquals(Car c2, Car last) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(String string, String last) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testAddToFront() {
		assertEquals("SUPERCARS", linkedString.getFirst());
		linkedString.addToFront("Start");
		assertEquals("Start", linkedString.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a,linkedCar.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("SUPERCARS", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a,linkedCar.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("WORLDSTAR", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d,linkedCar.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Car> list;
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		list = linkedCar.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Start");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Start", iterator.next());
		assertEquals("SUPERCARS", iterator.next());
		assertEquals("WORLDSTAR", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
	}
	
	private void assertEquals(boolean g, boolean hasNext) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	private void assertTrue(String string, boolean g) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedCar.addToFront(a);
		linkedCar.addToEnd(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(b, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		linkedCar.remove(a, comparatorCar);
		assertEquals(b, linkedCar.getFirst());
		//remove from the end of the list
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());
		linkedCar.remove(d, comparatorCar);
		assertEquals(c, linkedCar.getLast());
		//remove from middle of list
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.remove(b, comparatorCar);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(a, linkedCar.retrieveFirstElement());
		assertEquals(b,linkedCar.getFirst());
		assertEquals(b, linkedCar.retrieveFirstElement());
		assertEquals(c,linkedCar.getFirst());
		
		assertEquals("SUPERCARS", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("SUPERCARS",linkedString.getFirst());
		assertEquals("SUPERCARS", linkedString.retrieveFirstElement());
		assertEquals("WORLDSTAR",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd(d);
		assertEquals(d, linkedCar.getLast());
		assertEquals(d, linkedCar.retrieveLastElement());
		assertEquals(c,linkedCar.getLast());
		
		assertEquals("WORLDSTAR", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("WORLDSTAR",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Car{
		String a;
		String b;
		int c;
		
		public Car(String make, String model, int year){
			this.a = make;
			this.b = model;
			this.c = year;
		}
		
		public String getMake(){
			return a;
		}
		public String getModel(){
			return b;
		}
		public int getYear(){
			return c;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}