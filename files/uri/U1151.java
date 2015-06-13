import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int a = 0;
		int b = 1;
		
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		
		for (int i = 1; i < n; i++) {
			sb.append(' ').append(b);
			int c = b;
			b += a;
			a = c;
		}
		
		System.out.println(sb);
	}

}