package applications;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class ParenthesisChecker {

	private boolean isValidParentheis;
	private Stack<Character> stack;

	public ParenthesisChecker(String input) {
		stack = new Stack<>();
		checkParenthesisMatch(input);
	}

	private void checkParenthesisMatch(String input) {
		if (input == null) {
			isValidParentheis = false;
			return;
		}
		if (StringUtils.isEmpty(input)) {
			isValidParentheis = true;
			return;
		}

		// Assuming true by default.
		isValidParentheis = true;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			} else if (ch == '}' || ch == ']' || ch == ')') {
				if(stack.isEmpty()) {
					isValidParentheis = false;
					break;
				}
				char pop = stack.pop();
				if ((ch == '}' && pop == '{') || (ch == ']' && pop == '[') || (ch == ')' && pop == '(')) {
					continue;
				}
				isValidParentheis = false;
				break;
			}
		}
	}

	public boolean isValid() {
		return isValidParentheis;
	}

	public static void main(String[] args) {

		evaluate(new ParenthesisChecker(null).isValid());
		evaluate(new ParenthesisChecker("[]").isValid());
		evaluate(new ParenthesisChecker("[()]").isValid());
		evaluate(new ParenthesisChecker("[(90)]").isValid());
		evaluate(new ParenthesisChecker("[1(2)123]232{}{}}}[]").isValid());
		
	}
	
	private static void evaluate(boolean b) {
		if(b) {
			System.out.println("Balanced");
		} else {
			System.out.println("Unbalanced");
		}
	}
}
