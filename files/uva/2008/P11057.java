import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;



class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			BitSet prevNumbers = new BitSet(1000001);
			int a = Integer.MAX_VALUE;
			int b = 0;
			
			for (int i = 0; i < n; i++) {
				int aux = Integer.parseInt(tks.nextToken());
				int diff = Math.abs(m - aux);
				
				if (prevNumbers.get(diff)) {
					if (Math.abs(diff - aux) < Math.abs(a - b)) {
						a = Math.max(diff, aux);
						b = Math.min(diff, aux);
					}
				}
				
				prevNumbers.set(aux);
			}
			
			System.out.println("Peter should buy books whose prices are "+b+" and "+a+".\n");
			br.readLine();
		}
		
	}

}