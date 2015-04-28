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
			
			double k = (x1*x1*x2 - x1*x1*x3 - x1*x2*x2 + x1*x3*x3 - x1*y2*y2 + x1*y3*y3 + x2*x2*x3 - x2*x3*x3 + x2*y1*y1 - x2*y3*y3 - x3*y1*y1 + x3*y2*y2) / (2*(-x1*y2 + x1*y3 + x2*y1 - x2*y3 - x3*y1 + x3*y2));
			double h = x1 != x2 ? (x1*x1 - x2*x2 + y1*y1 - y2*y2 - 2*k*(y1-y2)) / (2*(x1-x2)) : (x1*x1 - x3*x3 + y1*y1 - y3*y3 - 2*k*(y1-y3)) / (2*(x1-x3));
			double r = Math.sqrt((x1-h)*(x1-h) + (y1-k)*(y1-k));
			
			double c = 2*h;
			double d = 2*k;
			double e = h*h + k*k - r*r;
			
			System.out.printf("(x %c %.3f)^2 + (y %c %.3f)^2 = %.3f^2\n", h>0?'-':'+', Math.abs(h), k>0?'-':'+', Math.abs(k), r);
			System.out.printf("x^2 + y^2 %c %.3fx %c %.3fy %c %.3f = 0\n\n", c>0?'-':'+', Math.abs(c), d>0?'-':'+', Math.abs(d), e<0?'-':'+', Math.abs(e));
		}
	}

}
