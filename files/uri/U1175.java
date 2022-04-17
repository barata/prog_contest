import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] array = new int[20];
		
		for (int i = 0; i < array.length; i++) {
			int value = Integer.parseInt(br.readLine());
			
			array[array.length - i - 1] = value;
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("N[%d] = %d\n", i, array[i]);
		}
	}

}