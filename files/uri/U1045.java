import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(tks.nextToken());
		double b = Double.parseDouble(tks.nextToken());
		double c = Double.parseDouble(tks.nextToken());
		
		double max = Math.max(a, Math.max(b, c));
		double min = Math.min(a, Math.min(b, c));
		double other = a + b + c - max - min;
		
		if (max >= min + other) System.out.println("NAO FORMA TRIANGULO");
		else {
			if (max * max > min * min + other * other) System.out.println("TRIANGULO OBTUSANGULO");
			else if (max * max < min * min + other * other) System.out.println("TRIANGULO ACUTANGULO");
			else System.out.println("TRIANGULO RETANGULO");
			
			if (eq(max, min)) System.out.println("TRIANGULO EQUILATERO");
			else if (eq(other, min) || eq(other, max)) System.out.println("TRIANGULO ISOSCELES");
		}
	}
	
	private static boolean eq(double d1, double d2) {
		return Math.abs(d1 - d2) <= 1e-10;
	}

}