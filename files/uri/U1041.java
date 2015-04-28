import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		float x = Float.parseFloat(tks.nextToken());
		float y = Float.parseFloat(tks.nextToken());
		
		if (x == 0 && y == 0) {
			System.out.println("Origem");
		} else if (x == 0) {
			System.out.println("Eixo Y");
		} else if (y == 0) {
			System.out.println("Eixo X");
		} else if (x > 0 && y > 0) {
			System.out.println("Q1");
		} else if (x < 0 && y < 0) {
			System.out.println("Q3");
		} else if (x < 0) {
			System.out.println("Q2");
		} else {
			System.out.println("Q4");
		}
	}

}