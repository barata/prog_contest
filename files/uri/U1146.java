import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x;
		
		while ((x = Integer.parseInt(br.readLine())) != 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= x; i++) {
				if (i > 1) sb.append(' ');
				sb.append(i);
			}
			System.out.println(sb);
		}
	}

}