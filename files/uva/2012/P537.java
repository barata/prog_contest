import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
	
	static double p, u, i;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= t; g++) {
			p = u = i = Double.MIN_VALUE;
			String line = br.readLine();
			
			int index = setField(line, 0);
			setField(line, index + 5);
			
			double result;
			String fix;
			if (p == Double.MIN_VALUE) {
				result = u * i;
				fix = "PW";
			} else if (u == Double.MIN_VALUE) {
				result = p / i;
				fix = "UV";
			} else {
				result = p / u;
				fix = "IA";
			}
			
			
			
			System.out.println("Problem #" + g);
			System.out.printf("%c=%.2f%c\n\n", fix.charAt(0), result, fix.charAt(1));
		}
	}
	
	static int setField(String s, int beginIndex) {
		int eqIndex = s.indexOf('=', beginIndex);
		if (eqIndex < 0) return -1;
		
		switch (s.charAt(eqIndex - 1)) {
			case 'P':
				p = convert(s.substring(eqIndex + 1, s.indexOf('W', eqIndex + 2)));
				break;
			case 'U':
				u = convert(s.substring(eqIndex + 1, s.indexOf('V', eqIndex + 2)));
				break;
			case 'I':
				i = convert(s.substring(eqIndex + 1, s.indexOf('A', eqIndex + 2)));
				break;
		}
		
		return eqIndex;
	}
	
	static double convert(String value) {
		switch (value.charAt(value.length() - 1)) {
			case 'm':
				return Double.parseDouble(value.substring(0, value.length() - 1)) / 1000;
			case 'k':
				return Double.parseDouble(value.substring(0, value.length() - 1)) * 1000;
			case 'M':
				return Double.parseDouble(value.substring(0, value.length() - 1)) * 1000000;
			default:
				return Double.parseDouble(value.substring(0, value.length()));
		}
	}

}
