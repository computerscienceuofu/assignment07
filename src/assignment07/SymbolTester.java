package assignment07;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class SymbolTester {
	
	
	static long startTime = 0;
	static long stopTime = 0;
	static long aveTime = 0;
	static long listsize = 0;
	
//	@Test
//	public void TimingTest() throws IOException{
//		try(FileWriter fw = new FileWriter(new File("visualization/data.csv"))) { //open up a file writer so we can write to file.
//			
//			System.out.println("Balanced Symbl Checker");
//			fw.write("Balanced Symbol Checker Time Analysis" + "\t" + "Number of operations performed" + "\t" + "Time in NanoSeconds it takes to Push Peek or Pop from the stack" + "\n");
//			
//			
//			LinkedListStack<String> tester = new LinkedListStack<String>();
//			
//				
//
//				for (int size2 = 1024; size2 < 100000000; size2 *= 2 )
//				{	
//						tester.push("{");
//						if (size2 % 1024 == 0)
//						{
//						startTime = System.nanoTime();
//						tester.push("{");
//						stopTime = System.nanoTime();
//						aveTime = stopTime - startTime;
//						fw.write("Push item onto stack (Doubly Linked List)" + "\t" + size2 + "\t" + aveTime + "\n"); // write to file.
//						}
//				}
//		
//		for (int size2 = 1024; size2 < 100000000; size2 *= 2 )
//		{	
//				tester.peek();
//				if (size2 % 1024 == 0)
//				{
//				startTime = System.nanoTime();
//				tester.peek();
//				stopTime = System.nanoTime();
//				aveTime = stopTime - startTime;
//				fw.write("Peek item onto stack (Doubly Linked List)" + "\t" + size2 + "\t" + aveTime + "\n"); // write to file.
//				}
//		}
//		
//		for (int size2 = 1024; size2 < 100000000; size2 *= 2 )
//		{	
//				tester.pop();
//				if (size2 % 1024 == 0)
//				{
//				startTime = System.nanoTime();
//				tester.pop();
//				stopTime = System.nanoTime();
//				aveTime = stopTime - startTime;
//				fw.write("Pop item from stack (Doubly Linked List)" + "\t" + size2 + "\t" + aveTime + "\n"); // write to file.
//				}
//		}}
//				
//				
//		  		catch (IOException e) 
//		  		{
//					e.printStackTrace();
//				
//		  		}
//		}
//					
//		

	
	@Test
	public void test1() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class1.java");
		String expected = "ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test2() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class2.java");
		String expected = "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test3() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class3.java");
		String expected = "No errors found. All symbols match.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test4() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class4.java");
		String expected = "ERROR: File ended before closing comment.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test5() throws FileNotFoundException {
		BalancedSymbolChecker tester = new BalancedSymbolChecker();		
		String msg = tester.checkFile("Class5.java");	
		String expected = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
		assertEquals(expected, msg);
		
	}
	
	@Test
	public void test6() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class6.java");
		String expected = "No errors found. All symbols match.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test7() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class7.java");
		String expected = "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test8() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class8.java");
		String expected = "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test9() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class9.java");
		String expected = "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test10() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class10.java");
		String expected = "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test11() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class11.java");
		String expected = "ERROR: Unmatched symbol at the end of file. Expected }.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test12() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class12.java");
		String expected = "No errors found. All symbols match.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test13() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class13.java");
		String expected = "No errors found. All symbols match.";
		assertEquals(expected, msg);
	}
	
	@Test
	public void test14() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class14.java");
		String expected = "No errors found. All symbols match.";
		assertEquals(expected, msg);
	}
}

