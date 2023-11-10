package EricShinozaki_p2;

public class Postfix {

	public static String convertToPostfix(String infix) {
		//USE RESIZABLE ARRAY STACK
		StackInterface<Character> operatorStack = new ResizableArrayStack<Character>();
		String postfix = new String("");
		
		int index = 0;
		Character topOperator;
		Character nextCharacter;
		
		while(index < infix.length()) {
			nextCharacter = infix.charAt(index);
			while(Character.isWhitespace(nextCharacter)) {
				index++;
				if(index < infix.length()) {
					nextCharacter = infix.charAt(index);
				} else {
					break;
				}
			}
			
			switch(nextCharacter) {
				case 'a' : case 'b' : case 'c' : case 'd' : case 'e' : case 'f' : case 'g' : case 'h' : case 'i' : case 'j' : case 'k' : case 'l' : case 'm' : case 'n' : 
				case 'o' : case 'p' : case 'q' : case 'r' : case 's' : case 't' : case 'u' : case 'v' : case 'w' : case 'x' : case 'y' : case 'z' : 
				case 'A' : case 'B' : case 'C' : case 'D' : case 'E' : case 'F' : case 'G' : case 'H' : case 'I' : case 'J' : case 'K' : case 'L' : case 'M' : case 'N' : 
				case 'O' : case 'P' : case 'Q' : case 'R' : case 'S' : case 'T' : case 'U' : case 'V' : case 'W' : case 'X' : case 'Y' : case 'Z' : 
				case '0' : case '1' : case '2' : case '3' : case '4' : case '5' : case '6' : case '7' : case '8' : case '9' : 
					postfix = postfix + nextCharacter;
					break;
				case '^' :
					operatorStack.push(nextCharacter);
					break;
				case '+' : case '-' : case '*' : case '/' :
					while(!operatorStack.isEmpty() && lessThan(nextCharacter, operatorStack.peek())){ 
						postfix = postfix + operatorStack.peek();
						operatorStack.pop();
					}
					operatorStack.push(nextCharacter);
					break;
				case '(' :
					operatorStack.push(nextCharacter);
					break;
				case ')' :
					topOperator = operatorStack.pop();
					while(topOperator != '(') {
						postfix = postfix + topOperator;
						topOperator = operatorStack.pop();
					}
					break;
				default: break;
			}
			
			index++;
		}
		while(!operatorStack.isEmpty()) {
			topOperator = operatorStack.pop();
			postfix = postfix + topOperator;
		}
		return postfix;
	}
	
	public static Integer evaluatePostfix(String postfix, Character[] variables, int[] values) {
		//USE LINKED LIST STACK
		StackInterface<Integer> valueStack = new LinkedStack<Integer>();
		
		int index = 0;
		int valOfCharacter = 0;
		int result = 0;
		Character nextCharacter;
		Integer operandOne;
		Integer operandTwo;
		
		
		while(index < postfix.length()) {
			nextCharacter = postfix.charAt(index);
			while(Character.isWhitespace(nextCharacter)) {
				index++;
				if(index < postfix.length()) {
					nextCharacter = postfix.charAt(index);
				} else {
					break;
				}
			}
			switch(nextCharacter)
			{
				case 'a' : case 'b' : case 'c' : case 'd' : case 'e' : case 'f' : case 'g' : case 'h' : case 'i' : case 'j' : case 'k' : case 'l' : case 'm' : case 'n' : 
				case 'o' : case 'p' : case 'q' : case 'r' : case 's' : case 't' : case 'u' : case 'v' : case 'w' : case 'x' : case 'y' : case 'z' : 
				case 'A' : case 'B' : case 'C' : case 'D' : case 'E' : case 'F' : case 'G' : case 'H' : case 'I' : case 'J' : case 'K' : case 'L' : case 'M' : case 'N' : 
				case 'O' : case 'P' : case 'Q' : case 'R' : case 'S' : case 'T' : case 'U' : case 'V' : case 'W' : case 'X' : case 'Y' : case 'Z' :
					for(int i = 0; i < variables.length; i++){
						if(nextCharacter.equals(variables[i])) {
							valOfCharacter = values[i];
							break;
						}
					}
					valueStack.push(valOfCharacter);
					break;
				case '+' : case '-' : case '*' : case '/' : case '^' :
					operandTwo = valueStack.pop();
					operandOne = valueStack.pop();
					switch(nextCharacter) {
						case '+' :
							result = operandOne + operandTwo;
							break;
						case '-' :
							result = operandOne - operandTwo;
							break;
						case '*' :
							result = operandOne * operandTwo;
							break;
						case '/' :
							result = operandOne / operandTwo;
							break;
						case '^' : 
							result = 1; 
	                        for (int i = 0; i < operandTwo; i++) {
	                            result *= operandOne;
	                        }
	    					break;
	                    default: break;
					}
					valueStack.push(result);
					break;
				default: break;
			}
			index++;
		}
		return valueStack.peek();
	}
	
	
	public static boolean lessThan(Character nextCharacter, Character peek) {
	    boolean lessThan = false;
	    if (nextCharacter.equals('^')) {
	        if (peek.equals('^')) {
	            lessThan = true;
	        }
	    } else if (nextCharacter.equals('*') || nextCharacter.equals('/')) {
	        if (peek.equals('^') || peek.equals('*') || peek.equals('/')) {
	            lessThan = true;
	        } 
	    } else if (nextCharacter.equals('+') || nextCharacter.equals('-')) {
	        if (peek.equals('+') || peek.equals('-') || peek.equals('*') || peek.equals('/') || peek.equals('^')) {
	            lessThan = true;
	        }
	    }
	    return lessThan;
	}

}
