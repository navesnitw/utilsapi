package applications;

import org.apache.commons.lang3.StringUtils;

public class ParenthesisChecker {
	
	private boolean isValidParentheis;
	
	
	public ParenthesisChecker(String input) {
		checkParenthesisMatch(input);
	}
	
	private void checkParenthesisMatch(String input) {
		if(input == null) {
			isValidParentheis = false; 
			return;
		}
		if(StringUtils.isEmpty(input)) {
			isValidParentheis = true;
			return;
		}
		
		
	}
	
	public boolean isValid() {
		return isValidParentheis;
	}
	

	public static void main(String[] args) {
		
		new ParenthesisChecker(null).isValid();
		
	}
}
