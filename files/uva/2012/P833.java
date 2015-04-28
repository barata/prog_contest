import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nTests = Integer.parseInt(br.readLine());
		
		for (int g = 0; g < nTests; g++) {
			br.readLine();
			
			List<Line> lines = new LinkedList<Line>();
			int nLines = Integer.parseInt(br.readLine());
			for (int i = 0; i < nLines; i++) {
				StringTokenizer tks = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(tks.nextToken());
				int y1 = Integer.parseInt(tks.nextToken());
				int x2 = Integer.parseInt(tks.nextToken());
				int y2 = Integer.parseInt(tks.nextToken());
				lines.add(new Line(x1, y1, x2, y2));
			}
			
			if (g > 0) System.out.println();
			
			int nPoints = Integer.parseInt(br.readLine());
			for (int i = 0; i < nPoints; i++) {
				StringTokenizer tks = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tks.nextToken());
				int y = Integer.parseInt(tks.nextToken());
				Point p = new Point(x, y);
				
				while (p.y > 0) {
					p = getNextPoint(p, lines);
				}
				
				System.out.println(p.x);
			}
		}
	}

	private static Point getNextPoint(Point ref, List<Line> lines) {
		double maxY = 0;
		Line currentLine = null;
		
		for (Line l : lines) {
			double y = l.projection(ref.x);
			if (y <= ref.y && y > maxY) {
				maxY = y;
				currentLine = l;
			}
		}
		
		if (currentLine == null) return new Point(ref.x, 0);
		return currentLine.p1.y < currentLine.p2.y ? currentLine.p1 : currentLine.p2;
	}

}

class Point {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Line {
	public Point p1;
	public Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Line(int x1, int y1, int x2, int y2) {
		this(new Point(x1, y1), new Point(x2, y2));
	}
	
	public double projection(int x) {
		if (x <= Math.min(p1.x, p2.x) || x >= Math.max(p1.x, p2.x)) return 0;
		return (p2.x*p1.y - p1.x*p2.y + (p2.y-p1.y)*x) / (double) (p2.x-p1.x);
	}
}