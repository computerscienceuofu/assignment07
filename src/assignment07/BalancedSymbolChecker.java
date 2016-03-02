package assignment07;

import java.io.*;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author ??
 */
public class BalancedSymbolChecker {

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */
	public String checkFile(String filename) throws FileNotFoundException 
	{

		if(new File(filename).isFile() == false)
		{
			throw new FileNotFoundException();
		}
		
		int lineNumber = 0;
		int colNumber = 0;
		char symbolRead = ' ';
		char symbolExpected = ' '; 
		
		LinkedListStack<Character> stringcheck = new LinkedListStack<Character>();
		
		File text = new File(filename);
		Scanner s = new Scanner(text);



		while(s.hasNext()) 
		{
			String nex = s.nextLine();
			lineNumber++;
			colNumber = 0;
		for(int i = 0; i <= nex.length() - 1; i++)	  
		{
			colNumber++;
			char c = nex.charAt(i);

		    if (c == '/')
		    {
		    	nex = s.next();
		    	
		    	switch(nex)
		    	{
		    		case "/":
		    			s.nextLine();
		    			lineNumber++;
		    			colNumber = 0;
		    			break;
		    		case "*":
		    			stringcheck.push('/');
		    			break;
		    	}
		    }
		    else if  (c == '*' && stringcheck.peek() == '/')
		    {		    	
		    	colNumber++;
		    			stringcheck.pop();	
		    			break;
		    }
		    
		    else if (c == '(' || c == '{' || c == '[' && stringcheck.peek() != '/')
		    {
		    	switch(c)
                {
                    case '(':
                    	stringcheck.push(c);        	
        		    	symbolRead = c;
        		    	symbolExpected = ')';
        		    	break;
        		    	
                    case '{':
                    	stringcheck.push(c);
        		    	symbolRead = c;
        		    	symbolExpected = '}';
        		    	break;
        		    	
                    case '[':
                    	stringcheck.push(c);
        		    	symbolRead = c;
        		    	symbolExpected = ']';
        		    	break;
                    default:
                        break;
                }
		    }
		    
		    else if (c == ')' || c == '}' || c == ']' && stringcheck.peek() != '/')
		    {
	                switch(c)
	                {
	                    case ']':
	                        if (stringcheck.peek() != '[')
	                        {	        
	                        	symbolRead = c;
	                    		s.close();
	                            return unmatchedSymbol(lineNumber, colNumber, symbolRead, symbolExpected);
	                        }
	                        else
	                        {
	                        	symbolRead = c;
	                        	stringcheck.pop();
	                        	break;
	                        }
	                    case '}':
	                        if (stringcheck.peek() != '{')
	                        {
	                        	symbolRead = c;
	                    		s.close();
	                        	return unmatchedSymbol(lineNumber, colNumber, symbolRead, symbolExpected);
	                        }
	                        else
	                        {
	                        	symbolRead = c;
	                        	stringcheck.pop();
	                        	break;
	                        }
	                    case ')':
	                        if (stringcheck.peek() != '(')
	                        {
	                        	symbolRead = c;
	                    		s.close();
	                        	return unmatchedSymbol(lineNumber, colNumber, symbolRead, symbolExpected);
	                        }
	                        else
	                        {
	                        	symbolRead = c;
	                        	stringcheck.pop();
	                        	break;
	                        }
	                    default:
	                        break;
	                }
	               
		    }
		   
		}

		
		}
		if(!stringcheck.isEmpty())
		{
			Character lastString = stringcheck.peek();
			switch(lastString)
            {
                case '[': 
                		symbolRead = '[';
                    	symbolExpected = ']';
                		s.close();
                    	return unmatchedSymbolAtEOF(symbolExpected);
                    
                case '{':       
                		symbolRead = '{';
                    	symbolExpected = '}';
                		s.close();
                    	return unmatchedSymbolAtEOF(symbolExpected);
                    
                case '(':  
                		symbolRead = '(';
                    	symbolExpected = ')';
                		s.close();
                    	return unmatchedSymbolAtEOF(symbolExpected);  
                case '/':
                	
            		s.close();
                		return unfinishedComment();
                default:
                    break;
            }
			
		}
		
		
		if(stringcheck.isEmpty())
        {
			s.close();
			return allSymbolsMatch();
        }

		s.close();
		return filename;
		
		
	}

	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 */
	private String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 */
	private String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 */
	private String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 */
	private String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}