public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(chessBoard, line, column, toLine, toColumn))
            return false;

        int forwardSteps = Math.abs(toLine - line);
        int sidewaysSteps = Math.abs(toColumn - column);

        if ((forwardSteps != 0 && sidewaysSteps != 0) && (forwardSteps != sidewaysSteps))
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
        } else if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            int lineStep = (toLine > line) ? 1 : -1;
            int columnStep = (toColumn > column) ? 1 : -1;
            int currentLine = line + lineStep;
            int currentColumn = column + columnStep;

            while (currentLine != toLine && currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += lineStep;
                currentColumn += columnStep;
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
        return "Q";
    }
}
