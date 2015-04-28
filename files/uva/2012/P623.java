import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


class Main {
	
	static String[] table = new String[1001];
	
	static {
		table[0] = "1";
		table[1] = "1";
		BigInteger b = new BigInteger("1");
		for (int i = 2; i < table.length; i++) {
			b = b.multiply(new BigInteger(String.valueOf(i)));
			table[i] = b.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			
			System.out.println(n + "!");
			System.out.println(table[n]);
		}
	}
	
}
