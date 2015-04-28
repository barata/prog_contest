import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null) {
			long n = Long.parseLong(line);
			
			double diagonal = (Math.sqrt(1 + 8 * n) - 1) / 2;
			long x = (long) Math.round((diagonal - (Math.ceil(diagonal) - 1)) * Math.ceil(diagonal));
			long y = (long) Math.ceil(diagonal) - x + 1;
			
			System.out.println(y + "/" + x);
		}
	}

}
