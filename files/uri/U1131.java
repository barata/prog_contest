import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int winsInter = 0;
		int winsGremio = 0;
		int draw = 0;
		int yesno;
		
		do {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int inter = Integer.parseInt(tks.nextToken());
			int gremio = Integer.parseInt(tks.nextToken());
			
			if (inter > gremio) winsInter++;
			else if (gremio > inter) winsGremio++;
			else draw++;
		
			System.out.println("Novo grenal (1-sim 2-nao)");
			yesno = Integer.parseInt(br.readLine());
		
		} while (yesno != 2);
		
		System.out.printf("%d grenais\n", winsInter + winsGremio + draw);
		System.out.printf("Inter:%d\n", winsInter);
		System.out.printf("Gremio:%d\n", winsGremio);
		System.out.printf("Empates:%d\n", draw);
		
		if (winsInter > winsGremio) System.out.println("Inter venceu mais");
		else if (winsGremio > winsInter) System.out.println("Gremio venceu mais");
		else System.out.println("Nao houve vencedor");
	}

}