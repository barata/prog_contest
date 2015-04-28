
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

	public static void main(String[] args) {
		int nCase = 1;
		char[][] board = readBoard();

		while (!boardEmpty(board)) {
			
			if (checkBlack(board)) System.out.println("Game #" + (nCase++) + ": black king is in check.");
			else {
				board = rotateBoard(board);
				if (checkWhite(board)) System.out.println("Game #" + (nCase++) + ": white king is in check.");
				else System.out.println("Game #" + (nCase++) + ": no king is in check.");
			}
			
			
			
			readLn(); // skip blank line
			board = readBoard();
		}
	}

	private static boolean checkWhite(char[][] board) {
		int[] result = findPiece(board, 'K');
		int line = result[0];
		int column = result[1];
		
		return check(board, line, column);
	}
	
	private static boolean checkBlack(char[][] board) {
		int[] result = findPiece(board, 'k');
		int line = result[0];
		int column = result[1];
		
		return check(board, line, column);
	}

	private static boolean check(char[][] board, int line, int column) {
		
		// check pawn
		char target = (char) ('k' + 'P' - board[line][column]);
		if ((line + 1 < board.length && column > 0 && board[line + 1][column - 1] == target)
				|| (line + 1 < board.length && column + 1 < board[line + 1].length && board[line + 1][column + 1] == target)) {
			return true;
		}
		
		// check rook
		target = (char) ('k' + 'R' - board[line][column]);
		if (find(board, line, column, target, 0) || find(board, line, column, target, 90)
				|| find(board, line, column, target, 180) || find(board, line, column, target, 270)) {
			return true;
		}
		
		// check bishop
		target = (char) ('k' + 'B' - board[line][column]);
		if (find(board, line, column, target, 45) || find(board, line, column, target, 135)
				|| find(board, line, column, target, 225) || find(board, line, column, target, 315)) {
			return true;
		}
		
		// check queen
		target = (char) ('k' + 'Q' - board[line][column]);
		if (find(board, line, column, target, 0) || find(board, line, column, target, 45)
				|| find(board, line, column, target, 90) || find(board, line, column, target, 135)
				|| find(board, line, column, target, 180) || find(board, line, column, target, 225)
				|| find(board, line, column, target, 270) || find(board, line, column, target, 315)) {
			return true;
		}
		
		// check knight
		target = (char) ('k' + 'N' - board[line][column]);
		if (line >= 2 && column >= 1 && board[line - 2][column - 1] == target) return true;
		if (line >= 2 && column + 1 < board[line - 2].length && board[line - 2][column + 1] == target) return true;
		if (line + 2 < board.length && column >= 1 && board[line + 2][column - 1] == target) return true;
		if (line + 2 < board.length && column + 1 < board[line + 2].length && board[line + 2][column + 1] == target) return true;
		if (line >= 1 && column >= 2 && board[line - 1][column - 2] == target) return true;
		if (line >= 1 && column + 2 < board[line - 1].length && board[line - 1][column + 2] == target) return true;
		if (line + 1 < board.length && column >= 2 && board[line + 1][column - 2] == target) return true;
		if (line + 1 < board.length && column + 2 < board[line + 1].length && board[line + 1][column + 2] == target) return true;
		
		
		return false;
	}

	private static boolean find(char[][] board, int line, int column, char target, int direction) {
		int deltaL = (int) Math.round(Math.cos(direction * Math.PI / 180));
		int deltaC = (int) Math.round(Math.sin(direction * Math.PI / 180));
		
		line += deltaL;
		column += deltaC;
		
		while (line >= 0 && column >= 0 && line < board.length && column < board[line].length) {
			if (board[line][column] != '.') return board[line][column] == target;
			
			line += deltaL;
			column += deltaC;
		}
		
		return false;
	}

	private static int[] findPiece(char[][] board, char c) {
		int[] result = new int[2];
		int i = -1, j = -1;

		label: for (i = 0; i < board.length; i++) {
			for (j = 0; j < board[i].length; j++) {
				if (board[i][j] == c) {
					break label;
				}
			}
		}
		
		result[0] = i;
		result[1] = j;
		
		return result;
	}
	
	private static boolean boardEmpty(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') return false;
			}
		}
		return true;
	}
	
	private static char[][] rotateBoard(char[][] board) {
		char[][] newBoard = new char[8][8];
		
		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard[i].length; j++) {
				newBoard[i][j] = board[newBoard.length - i - 1][newBoard[i].length - j - 1];
			}
		}
		
		return newBoard;
	}

	private static char[][] readBoard() {
		char[][] board = new char[8][8];
		
		for (int i = 0; i < board.length; i++) {
			String line = readLn();
			
			line.getChars(0, line.length(), board[i], 0);
		}
		
		return board;
	}

}
