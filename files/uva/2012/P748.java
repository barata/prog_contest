import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
			StringTokenizer tks = new StringTokenizer(line);
			String r = tks.nextToken();
			int n = Integer.parseInt(tks.nextToken());
			System.out.println(format(new BigDecimal(r).pow(n).toPlainString()));
		}
	}
	
	private static String format(String s) {
		int start = 0;
		int end = s.length() - 1;
		
		while (s.charAt(start) == '0') start++;
		while (s.charAt(end) == '0') end--;
		
		return s.substring(start, end + 1);
	}

}
