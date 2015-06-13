import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer pass = null;
		
		do {
			pass = Integer.valueOf(br.readLine());
			System.out.println(pass.equals(2002) ? "Acesso Permitido" : "Senha Invalida");
		} while (!pass.equals(2002));
	}

}
