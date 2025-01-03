public abstract class ChessPiece {

    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String  getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    protected boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line < 0 || line >= chessBoard.board.length || column < 0 || column >= chessBoard.board.length)
            return false;
        else if (toLine < 0 || toLine >= chessBoard.board.length || toColumn < 0 || toColumn >= chessBoard.board.length)
            return false;
        else if (line == toLine && column == toColumn)
            return false;

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        if (targetPiece != null && targetPiece.getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }
}
