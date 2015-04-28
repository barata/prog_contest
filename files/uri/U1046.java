import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(tks.nextToken());
		int b = Integer.parseInt(tks.nextToken());
		
		System.out.printf("O JOGO DUROU %d HORA(S)\n", b > a ? b - a : b + 24 - a);
	}
	
}