import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] par = new int[5];
		int[] impar = new int[5];
		
		int p = 0, i = 0;
		
		for (int k = 0; k < 15; k++) {
			int v = Integer.parseInt(br.readLine());
			
			if (v % 2 == 0) {
				par[p] = v;
				p++;
				
				if (p >= 5) {
					for (int j = 0; j < p; j++) {
						System.out.printf("par[%d] = %d\n", j, par[j]);
					}
					
					p = 0;
				}
			} else {
				impar[i] = v;
				i++;
				
				if (i >= 5) {
					for (int j = 0; j < i; j++) {
						System.out.printf("impar[%d] = %d\n", j, impar[j]);
					}
					
					i = 0;
				}
			}
		}

		for (int k = 0; k < i; k++) {
			System.out.printf("impar[%d] = %d\n", k, impar[k]);
		}
		
		for (int k = 0; k < p; k++) {
			System.out.printf("par[%d] = %d\n", k, par[k]);
		}
	}

}