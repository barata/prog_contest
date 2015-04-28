import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int round;
		
		while ((round = Integer.parseInt(br.readLine())) >= 0) {
			String word = br.readLine();
			boolean[] expected = new boolean[256];
			int nDiff = 0;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!expected[c]) {
					expected[c] = true;
					nDiff++;
				}
			}
			
			int right = 0; int wrong = 0;
			word = br.readLine();
			boolean[] checked = new boolean[256];
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (expected[c]) {
					if (!checked[c]) {
						checked[c] = true;
						right++;
						if (right == nDiff) break;
					}
				} else {
					if (!checked[c]) {
						checked[c] = true;
						wrong++;
						if (wrong == 7) break;
					}
				}
			}
			
			
			
			
			System.out.println("Round " + round);
			if (right == nDiff) System.out.println("You win.");
			else if (wrong == 7) System.out.println("You lose.");
			else System.out.println("You chickened out.");
		}
	}

}
