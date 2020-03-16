package array;

public class IsValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int[] row = new int[9];
			int[] col = new int[9];
			int[] cube = new int[9];
			for (int j = 0; j < 9; j++) {
				// 比较行是否重复
				if (board[i][j] != '.') {
					if (row[board[i][j] - '1'] == 1) {
//						System.out.println("第" + i + "行不满足，" + "row=" + i + ",col=" + j + ",value=" + board[i][j]);
						return false;
					} else {
						row[board[i][j] - '1'] = 1;
					}
				}
				// 比较列是否重复
				if (board[j][i] != '.') {
					if (col[board[j][i] - '1'] == 1) {
//						System.out.println("第" + i + "列不满足，" + "row=" + j + ",col=" + i + ",value=" + board[j][i]);
						return false;
					} else {
						col[board[j][i] - '1'] = 1;
					}
				}
				// 比较9*9格子是否重复
				//需要将X与Y限制在一个九宫格中，下面的计算方法是按照由上到下，再由左到右
				int cubeX = 3 * (i / 3) + j / 3;
				int cubeY = 3 * (i % 3) + j % 3;
				//先由左到右再由上到下
//				int cubeY = 3 * (i / 3) + j / 3;
//				int cubeX = 3 * (i % 3) + j % 3;
				if (board[cubeX][cubeY] != '.') {
					if (cube[board[cubeX][cubeY] - '1'] == 1) {
//						System.out.println("第" + cubeX + "行，第" + cubeY + "列不满足,value=" + board[cubeX][cubeY]);
						return false;
					} else {
						cube[board[cubeX][cubeY] - '1'] = 1;
					}
				}
			}
		}

		return true;

	}

	public static void main(String[] args) {
		IsValidSudoku isValidSudoku = new IsValidSudoku();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		System.out.print(isValidSudoku.isValidSudoku(board));
	}
}
