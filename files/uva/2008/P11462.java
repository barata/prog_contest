import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while (n != 0) {
			
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int[] count = new int[101];
			
			while (tks.hasMoreTokens()) {
				count[Integer.parseInt(tks.nextToken())]++;
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i < count.length; i++) {
				for (int j = 0; j < count[i]; j++) {
					sb.append(i).append(' ');
				}
			}
			
			System.out.println(sb.toString().trim());
			
			
			
			n = Integer.parseInt(br.readLine());
		}
		
	}
	
}