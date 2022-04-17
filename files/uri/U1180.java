import java.util.Scanner;


class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int menor = Integer.MAX_VALUE;
		int posicao = -1;
		
		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();
			
			if (v < menor) {
				menor = v;
				posicao = i;
			}
		}
		
		System.out.println("Menor valor: " + menor);
		System.out.println("Posicao: " + posicao);
		
		sc.close();
	}

}