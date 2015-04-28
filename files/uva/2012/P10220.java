import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


class Main {
	
	static int[] table = new int[1001];

	static {
		table[0] = table[1] = 1;
		table[2] = 2;
		
		BigInteger n = new BigInteger("2");
		for (int i = 3; i <= 1000; i++) {
			n = n.multiply(new BigInteger(String.valueOf(i)));
			
			String str = n.toString();
			int sum = 0;
			for (int j = 0; j < str.length(); j++) {
				sum += Character.getNumericValue(str.charAt(j));
			}
			table[i] = sum;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			
			System.out.println(table[n]);
		}
	}

}
