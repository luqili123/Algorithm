
public class IsValidSudoku {
	/*
	 * 你构建一个数组,长度为10,专门用来验证行的,假设验证的当前数字是5,
	 * 那么你就在这个数组里面索引为5的位置设置为1(代表出现过了),如果在验证当前行
	 * 时,别的列还出现了5,那么你判断这个数组索引为4的位置是否为1,如果是1,代表重复, 直接返回
	 */
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int[] row = new int[9];
			int[] col = new int[9];
			int[] cube = new int[9];
			// 检测行是否有重复
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (row[board[i][j]-'1']== 1)
						return false;
					else {
						row[board[i][j]-'1'] = 1;
					}
				}

			}
			//对列进行判断
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (row[board[i][j]-'1']== 1)
						return false;
					else {
						row[board[j][i]-'1'] = 1;
					}
				}

			}
			//对正方形进行判断
			for (int j = 0; j < 9; j++) {
				int cubeX=3*(i/3)+j/3;
				int cubeY=3*(i%3)+j%3;
				if (board[cubeX][cubeY] != '.') {
					if (row[board[cubeX][cubeY]-'1']== 1)
						return false;
					else {
						row[board[cubeX][cubeY]-'1'] = 1;
					}
				}

			}
		}
		return true;

	}
}
