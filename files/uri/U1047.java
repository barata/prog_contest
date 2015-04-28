import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(tks.nextToken());
		a += Double.parseDouble(tks.nextToken()) / 60;
		double b = Double.parseDouble(tks.nextToken());
		b += Double.parseDouble(tks.nextToken()) / 60;

		if (b > a) {
			int h = (int) (b - a);
			System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", h, Math.round(((b - a) - h) * 60));
		} else {
			int h = (int) (b + 24 - a);
			System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", h, Math.round(((b + 24 - a) - h) * 60));
		}
	}
	
}