import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			int drank = n;
			
			while (n >= 3) {
				drank += n/3;
				n = (n/3) + (n%3);
			}
			
			if (n == 2) drank++;
			
			System.out.println(drank);
		}
	}

}
