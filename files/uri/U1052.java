import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	static String[] TABLE = { "", "January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December" };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int month = Integer.parseInt(br.readLine());
		
		System.out.println(TABLE[month]);
	}

}