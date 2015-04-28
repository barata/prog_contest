import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> happy = new HashSet<Integer>();
		Set<Integer> unhappy = new HashSet<Integer>();
		int nTests = Integer.parseInt(br.readLine());
		happy.add(1);
		
		for (int g = 1; g <= nTests; g++) {
			String result = null;
			int n = Integer.parseInt(br.readLine());
			
			int aux = n;
			Set<Integer> tmp = new HashSet<Integer>();
			tmp.add(aux);

			while (result == null) {
				if (happy.contains(aux)) result = "a Happy";
				else if (unhappy.contains(aux)) result = "an Unhappy";
				else {

					int sum = 0;
					while (aux > 0) {
						int d = aux % 10;
						aux /= 10;
						sum += d*d;
					}
					
					aux = sum;
					
					if (aux == 1) {
						happy.addAll(tmp);
					} else if (!tmp.add(aux)) {
						unhappy.addAll(tmp);
					}
				}
			}
			
			System.out.println("Case #" + g + ": " + n + " is " + result + " number.");
		}
	}

}
