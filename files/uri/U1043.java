import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		float a = Float.parseFloat(tks.nextToken());
		float b = Float.parseFloat(tks.nextToken());
		float c = Float.parseFloat(tks.nextToken());
		float max = Math.max(a, Math.max(b, c));
		
		if (a + b + c - max > max) System.out.printf("Perimetro = %.1f\n", a + b + c);
		else System.out.printf("Area = %.1f\n", (a + b) * c / 2f);
	}

}