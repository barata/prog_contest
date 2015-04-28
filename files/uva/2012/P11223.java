import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


class Main {
	
	static Map<String, Character> map = new HashMap<String, Character>();
	
	static {
		map.put(".-", 'A');
		map.put("-...", 'B');
		map.put("-.-.", 'C');
		map.put("-..", 'D');
		map.put(".", 'E');
		map.put("..-.", 'F');
		map.put("--.", 'G');
		map.put("....", 'H');
		map.put("..", 'I');
		map.put(".---", 'J');
		map.put("-.-", 'K');
		map.put(".-..", 'L');
		map.put("--", 'M');
		map.put("-.", 'N');
		map.put("---", 'O');
		map.put(".--.", 'P');
		map.put("--.-", 'Q');
		map.put(".-.", 'R');
		map.put("...", 'S');
		map.put("-", 'T');
		map.put("..-", 'U');
		map.put("...-", 'V');
		map.put(".--", 'W');
		map.put("-..-", 'X');
		map.put("-.--", 'Y');
		map.put("--..", 'Z');
		map.put("-----", '0');
		map.put(".----", '1');
		map.put("..---", '2');
		map.put("...--", '3');
		map.put("....-", '4');
		map.put(".....", '5');
		map.put("-....", '6');
		map.put("--...", '7');
		map.put("---..", '8');
		map.put("----.", '9');
		map.put(".-.-.-", '.');
		map.put("--..--", ',');
		map.put("..--..", '?');
		map.put(".----.", '\'');
		map.put("-.-.--", '!');
		map.put("-..-.", '/');
		map.put("-.--.", '(');
		map.put("-.--.-", ')');
		map.put(".-...", '&');
		map.put("---...", ':');
		map.put("-.-.-.", ';');
		map.put("-...-", '=');
		map.put(".-.-.", '+');
		map.put("-....-", '-');
		map.put("..--.-", '_');
		map.put(".-..-.", '"');
		map.put(".--.-.", '@');
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			StringBuilder s = new StringBuilder();
			
			String[] words = line.split("  ");
			
			for (String w : words) {
				String[] letters = w.split(" ");
				
				for (String l : letters) {
					s.append(map.get(l));
				}
				
				s.append(' ');
			}
			
			if (i > 1) System.out.println();
			System.out.println("Message #" + i);
			System.out.println(s.substring(0, s.length() - 1));
		}
	}

}
