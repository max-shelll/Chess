public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(chessBoard, line, column, toLine, toColumn))
            return false;

        int forwardSteps = Math.abs(toLine - line);
        int sidewaysSteps = Math.abs(toColumn - column);

        if (forwardSteps == 1 && sidewaysSteps > 2)
            return false;
        else if (forwardSteps == 2 && sidewaysSteps > 1)
            return false;
        else if (forwardSteps > 2 || sidewaysSteps > 2)
            return false;

        ChessPiece targetPice = chessBoard.board[toLine][toColumn];
        if (targetPice != null && !targetPice.getColor().equals(this.color))
            return true;
        else if (targetPice != null && targetPice.getColor().equals(this.color))
            return false;

        return true;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
