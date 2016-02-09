import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			long pa = Integer.parseInt(tks.nextToken());
			long pb = Integer.parseInt(tks.nextToken());
			double g1 = Double.parseDouble(tks.nextToken()) / 100;
			double g2 = Double.parseDouble(tks.nextToken()) / 100;
			
			long years = 0;
			
			while (pa <= pb && years <= 100) {
				pa += Math.round(Math.floor(pa * g1));
				pb += Math.round(Math.floor(pb * g2));
				years++;
			}
			
			System.out.println(years > 100 ? "Mais de 1 seculo." : years + " anos.");
		}
	}

}