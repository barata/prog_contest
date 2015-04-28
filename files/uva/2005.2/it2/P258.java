import java.util.StringTokenizer;

class Main {

	static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char)car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }
	
	static char[][] maze;
	static boolean[][] mask;
	static int l, c;
	static int direcao;

	public static void main(String[] args) {
		StringTokenizer tks = new StringTokenizer(readLn());
		boolean shouldPrint = false;
		
		int m = Integer.parseInt(tks.nextToken());
		int n = Integer.parseInt(tks.nextToken());
		
		while (m != -1 && n != -1) {
			
			maze = new char[n][m];
			mask = new boolean[n][m];
			
			for (int i = 0; i < n; i++) {
				String line = readLn();
				line.getChars(0, line.length(), maze[i], 0);
			}
			
			initializeVariables();
			
			walk(l, c, direcao);
			
			
			
			
			// print maze
			if (shouldPrint) System.out.println();
			else shouldPrint = true;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					sb.append(maze[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
			
			
			
			
			tks = new StringTokenizer(readLn());
			
			m = Integer.parseInt(tks.nextToken());
			n = Integer.parseInt(tks.nextToken());
		}
	}

	static boolean walk(int _l, int _c, int d) {
		if (_l == -1 || _l == maze.length || _c == -1 || _c == maze[_l].length) return true;
		
		if (maze[_l][_c] == '*') return false;
		
		if (maze[_l][_c] == '.') return walk(_l + getDL(d), _c + getDC(d), d % 360);
		
		if (maze[_l][_c] == '/' && !mask[_l][_c]) {
			if (d % 180 == 0) d -= 90;
			else d += 90;
			
			mask[_l][_c] = true;
			
			if (!walk(_l + getDL(d), _c + getDC(d), d % 360)) {
				maze[_l][_c] = '\\';
				d -= 180;
				if (!walk(_l + getDL(d), _c + getDC(d), d % 360)) {
					mask[_l][_c] = false;
					return false;
				}
				return true;
			}
			return true;
		}
		
		if (maze[_l][_c] == '\\' && !mask[_l][_c]) {
			if (d % 180 == 0) d += 90;
			else d -= 90;
			
			mask[_l][_c] = true;
			
			if (!walk(_l + getDL(d), _c + getDC(d), d % 360)) {
				maze[_l][_c] = '/';
				d -= 180;
				if (!walk(_l + getDL(d), _c + getDC(d), d % 360)) {
					mask[_l][_c] = false;
					return false;
				}
				return true;
			}
			return true;
		}
		
		return false;
	}
	
	static int getDL(int d) {
		return (int) Math.round(Math.sin(d * Math.PI / 180));
	}
	
	static int getDC(double d) {
		return (int) Math.round(Math.cos(d * Math.PI / 180));
	}
	
	static void initializeVariables() {
		// first line
		for (int i = 0; i < maze[0].length; i++) {
			if (maze[0][i] == '.') {
				l = 0;
				c = i;
				direcao = 90;
				return;
			}
		}
		
		// last line
		for (int i = 0; i < maze[maze.length - 1].length; i++) {
			if (maze[maze.length - 1][i] == '.') {
				l = maze.length - 1;
				c = i;
				direcao = 270;
				return;
			}
		}
		
		// first column
		for (int i = 0; i < maze.length; i++) {
			if (maze[i][0] == '.') {
				l = i;
				c = 0;
				direcao = 0;
				return;
			}
		}
		
		// last column
		for (int i = 0; i < maze.length; i++) {
			if (maze[i][maze[i].length - 1] == '.') {
				l = i;
				c = maze[i].length - 1;
				direcao = 180;
				return;
			}
		}
	}

}
