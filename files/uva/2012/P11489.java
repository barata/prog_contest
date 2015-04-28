import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= t; g++) {
			String n = br.readLine();
			int[] freq = new int[10];
			int sum = 0;
			
			for (int i = 0; i < n.length(); i++) {
				int f = Character.getNumericValue(n.charAt(i));
				sum += f;
				freq[f]++;
			}
			
			
			String result;
			if (sum % 3 == 0) {
				result = ((freq[3] + freq[6] + freq[9]) % 2 == 0 ? "T" : "S");
			} else if (sum % 3 == 1) {
				if (freq[1] + freq[4] + freq[7] > 0)
					result = ((freq[3] + freq[6] + freq[9]) % 2 == 0 ? "S" : "T");
				else result = "T";
			} else {
				if (freq[2] + freq[5] + freq[8] > 0)
					result = ((freq[3] + freq[6] + freq[9]) % 2 == 0 ? "S" : "T");
				else result = "T";
			}
			
			
			System.out.println("Case " + g + ": " + result);
		}
	}

}
