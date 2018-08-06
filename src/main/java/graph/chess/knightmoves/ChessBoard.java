package graph.chess.knightmoves;

import java.util.LinkedList;

public class ChessBoard {
    private final int size;

    public ChessBoard(int size) {
        this.size = size;
    }
    public int getMinStepsForNextMove(Point sourcePoint, Point destinationPoint, ChessPiece chessPiece) {
        int[][] xyPossibilities;
        xyPossibilities = getXYPossibilities(chessPiece);

        LinkedList<Steps> wayQueue = new LinkedList<>();
        boolean[][] visited = new boolean[size+1][size+1];
        Steps steps = new Steps(sourcePoint, destinationPoint, chessPiece);

        wayQueue.add(steps);
        visited[sourcePoint.getX()][sourcePoint.getY()] = true;


        while(!wayQueue.isEmpty()){
            Steps currentStep = wayQueue.poll();
            if(currentStep.getSource().equals(currentStep.getDestination())){
                return currentStep.getNoOfSteps();
            }

            int newX, newY;
            for(int i=0; i<xyPossibilities.length; i++){
                newX = currentStep.getSource().getX() + xyPossibilities[i][0];
                newY = currentStep.getSource().getY() + xyPossibilities[i][1];
                if(newX >=1 && newX <= size && newY >=1 && newY <= size) {
                    final Point newPoint = new Point(newX, newY);
                    if (visited[newPoint.getX()][newPoint.getY()] == false) {
                        wayQueue.offer(new Steps(newPoint, currentStep.getDestination(),
                                currentStep.getNoOfSteps() + 1, currentStep.getChessPiece()));
                        visited[newPoint.getX()][newPoint.getY()] = true;
                    }
                }
            }

        }
        return 0;
    }

    private int[][] getXYPossibilities(ChessPiece chessPiece) {
        int[][] xyPossibilities;
        switch(chessPiece) {
            case KNIGHT:
                xyPossibilities = getXYPossibilitiesForKnight();
                break;
            default:
                xyPossibilities = new int[0][0];
                break;
        }
        return xyPossibilities;
    }

    private int[][] getXYPossibilitiesForKnight() {
        int[][] xyPossibilities = new int[8][2];
        xyPossibilities[0] = new int[]{+1, +2};
        xyPossibilities[1] = new int[]{+1, -2};
        xyPossibilities[2] = new int[]{-1, -2};
        xyPossibilities[3] = new int[]{-1, +2};

        xyPossibilities[4] = new int[]{+2, +1};
        xyPossibilities[5] = new int[]{+2, -1};
        xyPossibilities[6] = new int[]{-2, -1};
        xyPossibilities[7] = new int[]{-2, +1};
        return xyPossibilities;
    }
}
