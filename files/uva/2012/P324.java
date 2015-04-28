import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


class Main {
	
	static int[][] table = new int[367][];
	
	static {
		table[1] = getFreq("1");
		BigInteger b = new BigInteger("1");
		for (int i = 2; i < table.length; i++) {
			b = b.multiply(new BigInteger(String.valueOf(i)));
			table[i] = getFreq(b.toString());
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			
			System.out.println(n + "! --");
			
			int[] array = table[n];
			for (int i = 0; i < array.length; i++) {
				System.out.print(" (" + i + ") " + array[i]);
				if ((i+1) % 5 == 0) System.out.println();
			}
		}
	}

	private static int[] getFreq(String s) {
		int[] freq = new int[10];
		for (int i = 0; i < s.length(); i++) {
			freq[Character.getNumericValue(s.charAt(i))]++;
		}
		return freq;
	}
	
}
