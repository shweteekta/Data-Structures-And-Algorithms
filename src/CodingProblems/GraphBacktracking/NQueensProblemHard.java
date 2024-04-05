package GraphBacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblemHard {


    public static List<List<String>> solve(int numOfQueens){
        List<List<String>> solutions = new ArrayList<>();
        char[][] chessTable = new char[numOfQueens][numOfQueens];
        for (int i = 0; i < numOfQueens; i++) {
            for (int j = 0; j < numOfQueens; j++) {
                chessTable[i][j] = '.';
            }
        }
        setQueens(0, solutions, numOfQueens, chessTable);
        return solutions;
    }

    private static void setQueens(int rowIndex, List<List<String>> solutions, int numOfQueens, char[][] chessTable){
        if (rowIndex == numOfQueens){
            solutions.add(getStringValues(chessTable));
            return ;
        }
        for (int i = 0; i < numOfQueens; i++) {
            if(isPlaceValid(rowIndex, i, numOfQueens, chessTable)){
                chessTable[rowIndex][i] = 'Q';
                setQueens(rowIndex + 1, solutions,numOfQueens, chessTable);
                chessTable[rowIndex][i] = '.';
            }
        }
    }

    private static List<String> getStringValues(char[][] chessTable) {
        List<String> result = new ArrayList<>();
        for (char[] value: chessTable
             ) {
            result.add(new String(value));
        }
        return result;
    }


    private static boolean isPlaceValid(int rowIndex, int colIndex,int numOfQueens, char[][]chessTable) {
        for (int i = 0; i < rowIndex; i++) {
            if (chessTable[i][colIndex] == 'Q') {
                return false;
            }
        }
        // Left Diagonal
        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if(chessTable[i][j]== 'Q'){
                return false;
            }
        }
        // right diagonal
        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < numOfQueens; i--, j++){
            if(chessTable[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        List<List<String>> solutions = solve(4);

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
