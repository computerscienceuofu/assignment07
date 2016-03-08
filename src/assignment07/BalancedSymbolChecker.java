package assignment07;

import java.io.*;
import java.util.Scanner;


/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Chris Murphy && Li Yu
 */
public class BalancedSymbolChecker {

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */
	public String checkFile(String filename) throws FileNotFoundException 
	{
		//this checks whether there is a file named "filename"
		if(new File(filename).isFile() == false)
		{
			throw new FileNotFoundException();
		}
		
		//here are the counters for the lines and columns
		int lineNumber = 0;
		int colNumber = 0;
		char symbolRead = ' ';

		
		LinkedListStack<Character> stringcheck = new LinkedListStack<Character>();
		LinkedListStack<Character> symbolexpectedcheck = new LinkedListStack<Character>();
		
		
		File text = new File(filename);
		Scanner s = new Scanner(text);
		String nex;
		char symbolExpected = 0;
		int on = 0;
		
		//While loop starts here
		
		while(s.hasNextLine()) 
		{
		
				nex = s.nextLine();
				lineNumber++;
				colNumber = 0;
			
			
		/*the for loop steps through each character in the current line.  
		*It then goes back to the while loop and gets another line.
		*/
		for(int i = 0; i < nex.length(); i++)	  
		{
			colNumber++;
			char c = nex.charAt(i);
			
			// here it checks for comment lines and quotes, and flips the on switch if it has them
			if (i != nex.length()-1){
				if (nex.charAt(i) == '/' && nex.charAt(i+1) == '/'){
					break;
				}else if (nex.charAt(i)  == '/'  && nex.charAt(i + 1) == '*' && on != 1){
					on = 1;
				}else if (nex.charAt(i)  == '*'  && nex.charAt(i + 1) == '/' && on == 1){
					on = 0;
				}else if (nex.charAt(i)  == '"'  && on != 2 ){
					on = 2;
				}else if(nex.charAt(i)  == '"' && (nex.charAt(i - 1) != '\\' || on == 2)){
					on = 0;
				}else if(nex.charAt(i)  == '\'' && nex.charAt(i + 2) == '\''){
					break;
				}else if(nex.charAt(i)  == '\\'){
					i++;
					continue;
				}
			}
			
			//Can only check symbols if this equals 0
			if(on == 0)
			{
			    //Here it checks the start symbol
			    if (c == '(' || c == '{' || c == '[')
			    {
			    	switch(c)
	                {
	                    case '(':
	                    	stringcheck.push(c);        	
	        		    	symbolRead = c;
	        		    	symbolexpectedcheck.push(')');
	        		    	break;
	        		    	
	                    case '{':
	                		stringcheck.push(c);
	        		    	symbolRead = c;
	        		    	symbolexpectedcheck.push('}');
	        		    	break;
	                    	
	                    case '[':
	                    	stringcheck.push(c);
	        		    	symbolRead = c;
	        		    	symbolexpectedcheck.push(']');
	        		    	break;
	        		    	
	                    default:
	                        break;
	                }
			    }
				
			    //here it checks the end symbol	    	
			    if (c == ')' || c == '}' || c == ']')
			    {
			    		if(stringcheck.isEmpty()){
			    			s.close();
			    			return unmatchedSymbol(lineNumber, colNumber, symbolRead, ' ');
			    		}
			    		
			    		symbolExpected = symbolexpectedcheck.peek();
			    		
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
		                        	symbolexpectedcheck.pop();
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
		                        	symbolexpectedcheck.pop();
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
		                        	symbolexpectedcheck.pop();
		                        	break;
		                        }
	
		                }
			    }
		    }
		 }
		   
		
	}
		
		//While loop ends here
		
		if(on == 1)
		{
			s.close();
    		return unfinishedComment();
		}
		
		if (on == 2)
		{
			s.close();
			return allSymbolsMatch();
		}
		
		
		//Checks whether the stack is not empty.  
		if(!stringcheck.isEmpty())
		{
			symbolExpected = symbolexpectedcheck.peek(); 
			Character lastString = stringcheck.peek();
			switch(lastString)
            {
                case '[': 
                		symbolRead = '[';
                		s.close();
                    	return unmatchedSymbolAtEOF(symbolExpected);
                    
                case '{':       
                		symbolRead = '{';
                		s.close();
                    	return unmatchedSymbolAtEOF(symbolExpected);
                    
                case '(':  
                		symbolRead = '(';
                		s.close();
                    	return unmatchedSymbolAtEOF(symbolExpected);  

                default:
                    break;
            }
			
		}
		
		
		//checks whether the stack is empty.
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