public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(chessBoard, line, column, toLine, toColumn))
            return false;

        int forwardSteps = Math.abs(toLine - line);
        int sidewaysSteps = Math.abs(toColumn - column);

        if (forwardSteps != 0 && sidewaysSteps != 0)
            return false;

        if (line == toLine) {
            if (column < toColumn) {
                for (int nextColumnIndex = column + 1; nextColumnIndex < toColumn; nextColumnIndex++) {
                    if (chessBoard.board[line][nextColumnIndex] != null) {
                        return false;
                    }
                }
            } else {
                for (int nextColumnIndex = column - 1; nextColumnIndex > toColumn; nextColumnIndex--) {
                    if (chessBoard.board[line][nextColumnIndex] != null) {
                        return false;
                    }
                }
            }
        } else if (column == toColumn) {
            if (line < toLine) {
                for (int nextLineIndex = line + 1; nextLineIndex < toLine; nextLineIndex++) {
                    if (chessBoard.board[nextLineIndex][column] != null) {
                        return false;
                    }
                }
            } else {
                for (int nextLineIndex = line - 1; nextLineIndex > toLine; nextLineIndex--) {
                    if (chessBoard.board[nextLineIndex][column] != null) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

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
        return "R";
    }
}
