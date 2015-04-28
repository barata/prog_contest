import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(br.readLine());
		float x1 = Float.parseFloat(tks.nextToken());
		float y1 = Float.parseFloat(tks.nextToken());
		
		tks = new StringTokenizer(br.readLine());
		float x2 = Float.parseFloat(tks.nextToken());
		float y2 = Float.parseFloat(tks.nextToken());
		
		System.out.printf("%.4f\n", Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
	}

}
