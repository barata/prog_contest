import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		double salary = Double.parseDouble(br.readLine());
		double sold = Double.parseDouble(br.readLine());
		BigDecimal bd = new BigDecimal(salary + sold * 0.15d).setScale(2, RoundingMode.HALF_UP);
		
		System.out.printf("TOTAL = R$ %s\n", bd.toString());
	}

}
