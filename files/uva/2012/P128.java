import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger g = new BigInteger("34943");
		String line;
		
		while (!"#".equals((line = br.readLine()))) {
			if ("".equals(line)) System.out.println("00 00");
			else {
				BigInteger n = new BigInteger(line.getBytes("US-ASCII")).shiftLeft(16).mod(g);
				String result = "0000" + g.subtract(n).toString(16).toUpperCase();
				char c1 = result.charAt(result.length() - 4);
				char c2 = result.charAt(result.length() - 3);
				char c3 = result.charAt(result.length() - 2);
				char c4 = result.charAt(result.length() - 1);
				System.out.println(""+c1+c2+" "+c3+c4);
			}
		}
	}

}
