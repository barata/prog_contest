import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		float n1 = Float.parseFloat(tks.nextToken());
		float n2 = Float.parseFloat(tks.nextToken());
		float n3 = Float.parseFloat(tks.nextToken());
		float n4 = Float.parseFloat(tks.nextToken());
		
		float media = (2 * n1 + 3 * n2 + 4 * n3 + n4) / 10f;
		System.out.printf("Media: %.1f\n", media);
		
		if (media >= 7) System.out.println("Aluno aprovado.");
		else if (media < 5) System.out.println("Aluno reprovado.");
		else {
			System.out.println("Aluno em exame.");
			float exame = Float.parseFloat(br.readLine());
			System.out.printf("Nota do exame: %.1f\n", exame);
			
			float mediaFinal = (media + exame) / 2f;
			
			if (mediaFinal >= 5) System.out.println("Aluno aprovado.");
			else System.out.println("Aluno reprovado.");
			
			System.out.printf("Media final: %.1f\n", mediaFinal);
		}
	}

}