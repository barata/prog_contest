import java.io.BufferedReader;
import java.io.InputStreamReader;



class Main {
	
	static short[] cost = new short[256];
	
	static {
		cost['a'] = 1;
		cost['b'] = 2;
		cost['c'] = 3;
		cost['d'] = 1;
		cost['e'] = 2;
		cost['f'] = 3;
		cost['g'] = 1;
		cost['h'] = 2;
		cost['i'] = 3;
		cost['j'] = 1;
		cost['k'] = 2;
		cost['l'] = 3;
		cost['m'] = 1;
		cost['n'] = 2;
		cost['o'] = 3;
		cost['p'] = 1;
		cost['q'] = 2;
		cost['r'] = 3;
		cost['s'] = 4;
		cost['t'] = 1;
		cost['u'] = 2;
		cost['v'] = 3;
		cost['w'] = 1;
		cost['x'] = 2;
		cost['y'] = 3;
		cost['z'] = 4;
		cost[' '] = 1;
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int nCase = 1; nCase <= t; nCase++) {
			String line = br.readLine();
			
			System.out.println("Case #" + nCase + ": " + calculate(line));
		}
	}

	private static int calculate(String line) {
		int sum = 0;
		
		for (int i = 0; i < line.length(); i++) {
			sum += cost[line.charAt(i)];
		}
		
		return sum;
	}
}