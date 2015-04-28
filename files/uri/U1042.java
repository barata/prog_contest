import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(tks.nextToken());
		int b = Integer.parseInt(tks.nextToken());
		int c = Integer.parseInt(tks.nextToken());
		
		int min = Math.min(a, Math.min(b, c));
		int max = Math.max(a, Math.max(b, c));
		
		System.out.println(min);
		System.out.println(a + b + c - min - max);
		System.out.println(max);
		
		System.out.println();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}