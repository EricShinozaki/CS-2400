package EricShinozaki_p2;

public class PostfixTestUsingLinkedStack {

	public static void main(String[] args) {
		String postfix = new String("df*g+e*ab^bc*-g+/h-");
		Character[] variables = {'a','b','c','d','e','f','g','h'};
		int[] varValues = {2,3,4,5,6,7,1,72};
		
		Integer output = Postfix.evaluatePostfix(postfix, variables, varValues);

		System.out.println("Postfix expression to be evaluated: " + postfix);
		System.out.print("Variable values: ");
		for(int i = 0; i < variables.length; i++) {
			System.out.print(variables[i] + " = " + varValues[i] + " ");
		}
		System.out.println("\nExpression evaluates to: " + output);
	}

}
