import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 0; i < t; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			String cmd = tks.nextToken();
			
			if ("report".equals(cmd)) System.out.println(sum);
			else if ("donate".equals(cmd)) sum += Integer.parseInt(tks.nextToken());
		}
	}

}
