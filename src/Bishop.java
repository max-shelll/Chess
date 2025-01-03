public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(chessBoard, line, column, toLine, toColumn))
            return false;

        int forwardSteps = Math.abs(toLine - line);
        int sidewaysSteps = Math.abs(toColumn - column);

        if (forwardSteps != sidewaysSteps)
            return false;

        ChessPiece targetPice = chessBoard.board[toLine][toColumn];
        if (targetPice != null && !targetPice.getColor().equals(this.color))
            return true;
        else if (targetPice != null && targetPice.getColor().equals(this.color))
            return false;

        if (color.equals("White")) {
            for (int nextLineIndex = line + 1, nextColumnIndex = column + 1; nextLineIndex <= toLine && nextColumnIndex <= toColumn; nextLineIndex++, nextColumnIndex++) {
                if (chessBoard.board[nextLineIndex][nextColumnIndex] != null) {
                    return false;
                }
            }
            for (int nextLineIndex = line + 1, nextColumnIndex = column - 1; nextLineIndex <= toLine && nextColumnIndex >= toColumn; nextLineIndex++, nextColumnIndex--) {
                if (chessBoard.board[nextLineIndex][nextColumnIndex] != null) {
                    return false;
                }
            }
        } else {
            for (int nextLineIndex = line - 1, nextColumnIndex = column + 1; nextLineIndex >= toLine && nextColumnIndex <= toColumn; nextLineIndex--, nextColumnIndex++) {
                if (chessBoard.board[nextLineIndex][nextColumnIndex] != null) {
                    return false;
                }
            }
            for (int nextLineIndex = line - 1, nextColumnIndex = column - 1; nextLineIndex >= toLine && nextColumnIndex >= toColumn; nextLineIndex--, nextColumnIndex--) {
                if (chessBoard.board[nextLineIndex][nextColumnIndex] != null) {
                    return false;
                }
            }
        }

        return true;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
