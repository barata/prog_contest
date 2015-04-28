import java.util.StringTokenizer;

class Main {

	static String readLn() {
	    String newLine = System.getProperty("line.separator");
	    StringBuffer buffer = new StringBuffer();
	    int car = -1;
	    try {
	        car = System.in.read();
	        while ((car > 0) && (car != newLine.charAt(0))) {
	            buffer.append((char)car);
	            car = System.in.read();
	        }
	        if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
	    } catch (java.io.IOException e) { return (null); }
	    if ((car < 0) && (buffer.length() == 0)) return (null);
	    return (buffer.toString());
	}

	public static void main(String[] args) {
		String expression = readLn();
		
		while (expression != null) {
			
			int[] variables = initVariables();
			int[] plusValues = new int[26];
			boolean[] mask = new boolean[26];
			
			String clearedExpression = removeSpaces(expression, mask);
			clearedExpression = executeStep1(clearedExpression, variables);
			clearedExpression = executeStep3(clearedExpression, plusValues);
			int value = executeStep2(clearedExpression, variables);
			addTo(variables, plusValues, mask);
			
			System.out.println("Expression: " + expression);
			System.out.println("    value = " + value);
			for (int i = 0; i < variables.length; i++) {
				if (mask[i]) {
					System.out.println("    " + (char) ('a' + i) + " = " + variables[i]);
				}
			}
			
			
			expression = readLn();
		}
	}
	
	static String executeStep1(String expression, int[] variables) {
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			
			if (Character.isLetter(ch)) {
				
				if (i >= 2) {
					if (expression.charAt(i - 1) == '+' && expression.charAt(i - 2) == '+') {
						variables[ch - 'a']++;
						expression = expression.substring(0, i - 2) + expression.substring(i);
						i -= 2;
						continue;
					}
					if (expression.charAt(i - 1) == '-' && expression.charAt(i - 2) == '-') {
						variables[ch - 'a']--;
						expression = expression.substring(0, i - 2) + expression.substring(i);
						i -= 2;
					}
				}
			}
			
		}
		return expression;
	}
	
	static int executeStep2(String expression, int[] variables) {
		StringTokenizer tks = new StringTokenizer(expression, "+-", true);
		int value = variables[tks.nextToken().charAt(0) - 'a'];
		
		while (tks.hasMoreTokens()) {
			String sign = tks.nextToken();
			int term = variables[tks.nextToken().charAt(0) - 'a'];
			
			if ("+".equals(sign)) value += term;
			else value -= term;
		}
		
		return value;
	}
	
	static String executeStep3(String expression, int[] plusValues) {
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			
			if (Character.isLetter(ch)) {
				
				if (i < expression.length() - 2) {
					if (expression.charAt(i + 1) == '+' && expression.charAt(i + 2) == '+') {
						plusValues[ch - 'a']++;
						expression = expression.substring(0, i + 1) + expression.substring(i + 3);
						continue;
					}
					if (expression.charAt(i + 1) == '-' && expression.charAt(i + 2) == '-') {
						plusValues[ch - 'a']--;
						expression = expression.substring(0, i + 1) + expression.substring(i + 3);
					}
				}
			}
			
		}
		return expression;
	}
	
	static void addTo(int[] variables, int[] plusValues, boolean[] mask) {
		for (int i = 0; i < variables.length; i++) {
			if (mask[i]) variables[i] += plusValues[i];
		}
	}

	static String removeSpaces(String expression, boolean[] mask) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			
			if (ch != ' ') {
				sb.append(ch);
				if (Character.isLetter(ch)) mask[ch - 'a'] = true;
			}
		}
		
		return sb.toString();
	}

	static int[] initVariables() {
		int[] variables = new int[26];
		
		for (int i = 0; i < variables.length; i++) {
			variables[i] = i + 1;
		}
		
		return variables;
	}

}
