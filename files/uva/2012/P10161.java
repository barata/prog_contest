import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		
		while ((n = Integer.parseInt(br.readLine())) > 0) {
			int dist = (int) Math.ceil(Math.sqrt(n));
			int last = dist * dist;
			int first = (dist - 1) * (dist - 1) + 1;
			
			int l = Math.min(dist, n - first + 1);
			int c = Math.min(dist, last - n + 1);
			
			if (dist % 2 == 0) System.out.println(l+" "+c);
			else System.out.println(c+" "+l);
		}
	}

}
