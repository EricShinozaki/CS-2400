package EricShinozaki_p2;

public class PostfixTestUsingArrayStack {

	public static void main(String[] args) {
		String infix = new String("(d * f + 1) * e/(a^b - b * c + 1) - 72");
		String postfix = Postfix.convertToPostfix(infix);
		System.out.println("Infix Input: " + infix);
		System.out.println("Postfix output: " + postfix);
	}

}
