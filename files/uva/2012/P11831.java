import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tks.nextToken());
		int m = Integer.parseInt(tks.nextToken());
		int s = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || m != 0 || s != 0) {
			char[][] matrix = new char[n][m];
			
			for (int i = 0; i < n; i++) {
				br.readLine().getChars(0, m, matrix[i], 0);
			}
			
			Cell startPos = findStartPosition(matrix);
			int l = startPos.l;
			int c = startPos.c;
			double angle = 0;
			switch (matrix[l][c]) {
				case 'N': angle = Math.PI * 3 / 2; break;
				case 'S': angle = Math.PI / 2; break;
				case 'L': angle = 0; break;
				case 'O': angle = Math.PI; break;
			}
			matrix[l][c] = '.';
			
			String commands = br.readLine();
			int nSticks = 0;
			
			for (int i = 0; i < s; i++) {
				char cmd = commands.charAt(i);
				switch (cmd) {
					case 'E': angle -= Math.PI / 2; break;
					case 'D': angle += Math.PI / 2; break;
					case 'F':
						int nL = l + (int) Math.round(Math.sin(angle));
						int nC = c + (int) Math.round(Math.cos(angle));
						
						if (nL >= 0 && nL < n && nC >= 0 && nC < m && matrix[nL][nC] != '#') {
							l = nL;
							c = nC;
							if (matrix[l][c] == '*') {
								nSticks++;
								matrix[l][c] = '.';
							}
						}
				}
			}
			
			System.out.println(nSticks);
			
			
			tks = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tks.nextToken());
			m = Integer.parseInt(tks.nextToken());
			s = Integer.parseInt(tks.nextToken());
		}
	}
	
	private static Cell findStartPosition(char matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'N' || matrix[i][j] == 'S' ||
						matrix[i][j] == 'L' || matrix[i][j] == 'O') return new Cell(i, j);
			}
		}
		return null;
	}

}

class Cell {
	public int l, c;
	public Cell(int l, int c) {
		this.l = l;
		this.c = c;
	}
}