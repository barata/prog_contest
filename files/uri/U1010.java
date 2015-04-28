import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		tks.nextToken();
		int qnt1 = Integer.parseInt(tks.nextToken());
		float price1 = Float.parseFloat(tks.nextToken());
		
		tks = new StringTokenizer(br.readLine());
		tks.nextToken();
		int qnt2 = Integer.parseInt(tks.nextToken());
		float price2 = Float.parseFloat(tks.nextToken());
		
		System.out.printf("VALOR A PAGAR: R$ %.2f\n", qnt1 * price1 + qnt2 * price2);
	}

}
