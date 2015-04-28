import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
			StringTokenizer tks = new StringTokenizer(line);
			double x1 = Double.parseDouble(tks.nextToken());
			double y1 = Double.parseDouble(tks.nextToken());
			double x2 = Double.parseDouble(tks.nextToken());
			double y2 = Double.parseDouble(tks.nextToken());
			double x3 = Double.parseDouble(tks.nextToken());
			double y3 = Double.parseDouble(tks.nextToken());
			
			double b = (x1*x1*x2 - x1*x1*x3 - x1*x2*x2 + x1*x3*x3 - x1*y2*y2 + x1*y3*y3 + x2*x2*x3 - x2*x3*x3 + x2*y1*y1 - x2*y3*y3 - x3*y1*y1 + x3*y2*y2) / (2*(-x1*y2 + x1*y3 + x2*y1 - x2*y3 - x3*y1 + x3*y2));
			double a = x1 != x2 ? (x1*x1 - x2*x2 + y1*y1 - y2*y2 - 2*b*(y1-y2)) / (2*(x1-x2)) : (x1*x1 - x3*x3 + y1*y1 - y3*y3 - 2*b*(y1-y3)) / (2*(x1-x3));
			double r = Math.sqrt((x1-a)*(x1-a) + (y1-b)*(y1-b));
			
			System.out.printf("%.2f\n", 2*Math.PI*r);
		}
	}

}
