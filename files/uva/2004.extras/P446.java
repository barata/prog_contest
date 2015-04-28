import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine(), "+-", true);
			
			String number1 = tks.nextToken().trim();
			String op = tks.nextToken();
			String number2 = tks.nextToken().trim();
			
			int number1int = Integer.valueOf(number1, 16);
			int number2int = Integer.valueOf(number2, 16);
			
			System.out.println(formata(Integer.toBinaryString(number1int), 13) + " " + op + " " +
					formata(Integer.toBinaryString(number2int), 13) + " = " +
					("+".equals(op) ? number1int + number2int : number1int - number2int));
		}
	}
	
	static String formata(String text, int size) {
		return str("0", size - text.length()) + text;
	}
	
	static String str(String ch, int n) {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < n; i++) {
			resultado.append(ch);
		}
		return resultado.toString();
	}
	
}