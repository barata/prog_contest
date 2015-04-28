import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			Set<String> set = new HashSet<String>();
			
			for (int i = 0; i < line.length(); i++) {
				for (int j = i; j < line.length(); j++) {
					
					if (isPalindrome(line, i, j)) {
						set.add(line.substring(i, j + 1));
					}
					
				}
			}
			
			System.out.println("The string '"+line+"' contains "+set.size()+" palindromes.");
		}
	}

	private static boolean isPalindrome(String word, int i, int j) {
		for (int k = i; k < (i + j + 1) >> 1; k++) {
			if (word.charAt(k) != word.charAt(j - (k - i))) return false;
		}
		return true;
	}
}