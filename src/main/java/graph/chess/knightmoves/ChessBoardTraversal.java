package graph.chess.knightmoves;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessBoardTraversal {
    private static final File chessBoardTraversalBulkInputFile;

    static {
        chessBoardTraversalBulkInputFile = new File(ChessBoardTraversal.class
                .getClassLoader()
                .getResource("ChessBoardTraversalInput.txt")
                .getPath());
    }
    public static void main (String[] args) {
        Scanner sc= null;
        try {
            sc = new Scanner(chessBoardTraversalBulkInputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found or loaded"); e.printStackTrace();
        }

        int nTestCase = sc.nextInt();
        List<Integer> result = new ArrayList<>(nTestCase);
        for(; nTestCase>= 1; nTestCase--) {
            ChessBoard chessBoard = new ChessBoard(sc.nextInt());

            final Point sourcePoint = new Point(sc.nextInt(), sc.nextInt());
            final Point destinationPoint = new Point(sc.nextInt(), sc.nextInt());
            result.add(chessBoard.getMinStepsForNextMove(sourcePoint, destinationPoint, ChessPiece.KNIGHT));
        }

        result.forEach(System.out::println);

    }
}
