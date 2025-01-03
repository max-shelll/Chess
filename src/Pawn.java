public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMove(chessBoard, line, column, toLine, toColumn))
            return false;

        int forwardSteps = Math.abs(toLine - line);
        int sidewaysSteps = Math.abs(toColumn - column);

        if (sidewaysSteps != 0)
            return false;

        if (color.equals("White")) {
            if (line == 1 && forwardSteps > 2)
                return false;
            else if (line != 1 && forwardSteps > 1)
                return false;
        } else if (color.equals("Black")) {
            if (line == 6 && forwardSteps > 2)
                return false;
            else if (line != 6 && forwardSteps > 1)
                return false;
        }

        if (color.equals("White")) {
            for (int nextLineIndex = line + 1; nextLineIndex <= toLine; nextLineIndex++) {
                if (chessBoard.board[nextLineIndex][column] != null)
                    return false;
            }
        } else {
            for (int nextLineIndex = line - 1; nextLineIndex >= toLine; nextLineIndex--) {
                if (chessBoard.board[nextLineIndex][column] != null)
                    return false;
            }
        }

        ChessPiece targetPice = chessBoard.board[toLine][toColumn];
        if (targetPice != null && !targetPice.getColor().equals(this.color))
            return true;
        else if (targetPice != null && targetPice.getColor().equals(this.color))
            return false;

        return true;
    }

    @Override
    protected boolean isValidMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!super.isValidMove(chessBoard, line, column, toLine, toColumn))
            return false;
        else if (color.equals("White") && (toLine < line || toColumn < column))
            return false;
        else if (color.equals("Black") && (toLine > line || toColumn > column))
            return false;

        return true;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
