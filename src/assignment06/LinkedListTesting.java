package assignment06;

import static org.junit.Assert.*;


import java.util.Iterator;
import org.junit.Test;

public class LinkedListTesting {

	static long startTime = 0;
	static long stopTime = 0;
	static long aveTime = 0;
	static long listsize = 0;
	
//	@Test
//	public void TimingTest(){
//		try(FileWriter fw = new FileWriter(new File("visualization/data.csv"))) { //open up a file writer so we can write to file.
//			
//			System.out.println("AddFirst Tests");
//			fw.write("Linked Lists addLast Test (Java and Doubly)" + "\t" + "Number of items added" + "\t" + "Time in NanoSeconds" + "\n");
//			
//			
//			DoublyLinkedList<String> temp = new DoublyLinkedList<String>();
//			LinkedList<String> Link = new LinkedList<String>();
//				
//				int search = 0;
//				for (int size2 = 1; size2 < 10000000; size2 += 1)
//				{	
//					temp.addLast("CatsAreGreat");
//					search++;
//					if (search % 100000 == 0)
//					{
//						startTime = System.nanoTime();
//						temp.addLast("CatsAreGreat");
//						stopTime = System.nanoTime();
//						aveTime = stopTime - startTime;
//						fw.write("add Last Doubly" + "\t" + search + "\t" + aveTime + "\n"); // write to file.
//						search++;
//					}
//					
//															
//				}
//
//				search = 0;
//	     		for (int size4 = 1; size4 < 10000000; size4 += 1)
//	     		{		
//	     			temp.addLast("CatsAreGreat");
//					search++;
//					if (search % 100000 == 0)
//					{
//	     			startTime = System.nanoTime();
//	     			Link.addLast("CatsAreGreat");	
//	     			stopTime = System.nanoTime();
//					aveTime = stopTime - startTime;
//					fw.write("add Last java's Linked list" + "\t" + search + "\t" + aveTime + "\n"); // write to file.
//					search++;
//					}
//	     		
//	     		}
//	     		
//	     		
//			}
//		
//			
//	  		catch (IOException e) 
//	  		{
//				e.printStackTrace();
//			
//	  		}
//
//	}
//	
	@Test
	public void GetFirsttest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
	
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		assertEquals("pig", testlist.getFirst());
		
	}
	
	@Test
	public void RemoveTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");
		testlist.remove(2);
		assertEquals("pig", testlist.getFirst());
	}
	
	@Test
	public void RemoveEdgeTest2() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");
		testlist.remove(4);
		assertEquals("pig", testlist.getFirst());
	}
	
	@Test
	public void RemoveEdgeTest3() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");
		testlist.remove(0);
		assertEquals("donkey", testlist.getFirst());
	}
	
	@Test
	public void RemoveMiddleTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(4, "dog");
		testlist.remove(2);
		assertEquals("fish", testlist.get(2));
	}
	
	@Test
	public void RemoveMiddleTest2() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(4, "dog");
		testlist.add(2, "dog");
		testlist.remove(2);
		assertEquals("Monkey", testlist.get(2));
	}
	
	
	
	@Test
	public void GetLasttest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");	

		assertEquals("cat", testlist.getLast());
		
	}
	
	
	@Test
	public void GetIndexOftest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");	
		assertEquals(0, testlist.indexOf("pig"));
		assertEquals(1, testlist.indexOf("donkey"));
		assertEquals(2, testlist.indexOf("dog"));
		assertEquals(3, testlist.indexOf("Monkey"));
		assertEquals(4, testlist.indexOf("fish"));
		assertEquals(5, testlist.indexOf("cat"));
		
	}
	
	@Test
	public void GetLastIndexOftest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "pig");
		testlist.add(2, "pig");
		testlist.add(3, "fish");	
		assertEquals(2, testlist.lastIndexOf("pig"));		
	}
	
	@Test
	public void GetSize() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "pig");
		testlist.add(2, "pig");
		testlist.add(3, "fish");	
		assertEquals(5, testlist.size());		
	}
	
	@Test
	public void isEmptyTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "pig");
		testlist.add(2, "pig");
		testlist.add(3, "fish");	
		assertEquals(false, testlist.isEmpty());	
		    
	}
	
	@Test
	public void ClearTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "pig");
		testlist.add(2, "pig");
		testlist.add(3, "fish");	
		testlist.clear();
		assertEquals(true, testlist.isEmpty());
		    
	}
	
	
	@Test
	public void ToArrayTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "pig");
		testlist.add(2, "pig");
		testlist.add(3, "fish");			
		Object[] arraytest = testlist.toArray();
		for(Object i: arraytest)
			System.out.println(i);
		System.out.println("\n");
		    
	}
	
	@Test
	public void Gettest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.addFirst("donkey");
		testlist.add(1, "Monkey");
		testlist.add(2, "fish");		
		assertEquals("donkey", testlist.get(0));
		assertEquals("Monkey", testlist.get(1));
		assertEquals("fish", testlist.get(2));
		assertEquals("cat", testlist.get(3));
		
	}
	
	@Test
	public void RemoveLastTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");	
		testlist.removeLast();
		assertEquals("fish", testlist.getLast());
		testlist.removeFirst();
		assertEquals("donkey", testlist.getFirst());
		
		
	}
	
	@Test
	public void IteratorPrintTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");
		
		Iterator<String> test = testlist.iterator();
	    while(test.hasNext())
	    {
	    	Object element = test.next();
	        System.out.print(element + "\n");	        
	    }
	    
	    Iterator<String> test2 = testlist.iterator();
	    while(test2.hasNext())
	    {
	    	test2.next();
	    	test2.remove();	        
	    }	
	    
	 
	}
	
	@Test
	public void IteratorPrintTest2() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");
		
		Iterator<String> test = testlist.iterator();	    
		assertEquals("pig", test.next());
		assertEquals("donkey", test.next());
		assertEquals("dog", test.next());
		assertEquals("Monkey", test.next());
		assertEquals("fish", test.next());
		assertEquals("cat", test.next());
	 
	}
	
	@Test
	public void IteratorremoveTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");
		
		Iterator<String> test = testlist.iterator();
		test.next();
		test.remove();
		assertEquals(true, testlist.getFirst() == "donkey");
	 
	}
	
	@Test
	public void IteratorHasNextTest() {
		DoublyLinkedList<String> testlist = new DoublyLinkedList<String>();
		testlist.addFirst("cat");
		testlist.add(0, "pig");
		testlist.add(1, "donkey");
		testlist.add(2, "Monkey");
		testlist.add(3, "fish");
		testlist.add(2, "dog");
		
		Iterator<String> test = testlist.iterator();
		assertEquals(true, test.hasNext());
		Iterator<String> test2 = testlist.iterator();
		    while(test2.hasNext())
		    {
		    	test2.next();
		    	test2.remove();	        
		    }	
		    
		assertEquals(false, test2.hasNext());
		
		
	}

}
