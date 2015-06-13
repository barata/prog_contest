import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tks = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(tks.nextToken());
		int y = Integer.parseInt(tks.nextToken());
		
		while (x != 0 && y != 0) {
			if (x > 0) {
				if (y > 0) System.out.println("primeiro");
				else System.out.println("quarto");
			} else {
				if (y > 0) System.out.println("segundo");
				else System.out.println("terceiro");
			}
			
			tks = new StringTokenizer(br.readLine());
			x = Integer.parseInt(tks.nextToken());
			y = Integer.parseInt(tks.nextToken());
		}
	}

}
