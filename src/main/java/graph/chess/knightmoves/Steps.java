package graph.chess.knightmoves;

public class Steps {
    final Point source;
    final Point destination;
    int noOfSteps;
    final ChessPiece chessPiece;

    public Steps(Point source, Point destination, ChessPiece chessPiece) {
        this.source = source;
        this.destination = destination;
        this.noOfSteps = 0;
        this.chessPiece = chessPiece;
    }

    public Steps(Point source, Point destination, int noOfSteps, ChessPiece chessPiece) {
        this.source = source;
        this.destination = destination;
        this.noOfSteps = noOfSteps;
        this.chessPiece = chessPiece;
    }

    public Point getSource() {
        return source;
    }

    public Point getDestination() {
        return destination;
    }

    public int getNoOfSteps() {
        return noOfSteps;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }

}
