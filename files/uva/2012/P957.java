import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			int y = Integer.parseInt(line);
			int p = Integer.parseInt(br.readLine());
			
			int[] freq = new int[1000001];
			int sum = 0;
			int first = -1;
			int last = -1;
			
			for (int i = 0; i < p; i++) {
				int value = Integer.parseInt(br.readLine());
				if (i == 0) first = value;
				if (i == p - 1) last = value;
				
				freq[value]++;
			}
			
			int maxLast = first;
			
			for (int i = first; i < Math.min(last + 1, first + y); i++) {
				sum += freq[i];
				if (freq[i] > 0) maxLast = i;
			}
			int maxSum = sum;
			for (int i = first + y; i <= last; i++) {
				sum += freq[i];
				sum -= freq[i - y];
				
				if (sum > maxSum) {
					maxSum = sum;
					maxLast = i;
				}
			}
			int maxFirst = maxLast;
			for (int i = 1; i < y && maxLast - i >= 0; i++) {
				if (freq[maxLast - i] > 0) maxFirst = maxLast - i;
			}
			
			System.out.println(maxSum + " " + maxFirst + " "  + maxLast);
			
			br.readLine();
		}
	}

}
