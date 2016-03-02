package assignment07;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class SymbolTester {

	

	@Test
	public void test() throws FileNotFoundException {
		BalancedSymbolChecker tester = new BalancedSymbolChecker();		
		String msg = tester.checkFile("Class5.java");	
		String expected = "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.";
		assertEquals(expected, msg);
		
	}
	
	@Test
	public void test3() throws FileNotFoundException {

		BalancedSymbolChecker tester = new BalancedSymbolChecker();	
		String msg = tester.checkFile("Class1.java");
		String expected = "No errors found. All symbols match.";
		assertEquals(expected, msg);
	}
}
