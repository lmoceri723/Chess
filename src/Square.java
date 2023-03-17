import java.awt.*;

public class Square
{
    public static final Color WHITE_SQUARE_COLOR = new Color(238,238,210);
    public static final Color BLACK_SQUARE_COLOR = new Color(118,150,86);
    private Piece piece;
    private final Board board;
    private final int rank;
    private final int file;
    private final boolean isWhite;

    public Square(Board board, int rank, int file, boolean isWhite) {
        this.board = board;
        this.rank = rank;
        this.file = file;
        this.piece = null;
        this.isWhite = isWhite;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRank()
    {
        return rank;
    }
    public int getFile()
    {
        return file;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        if (this.piece == null)
        {
            return "null";
        }
        return piece.toString();
    }

    public void drawSquare(Graphics g)
    {
        if (isWhite)
        {
            g.setColor(WHITE_SQUARE_COLOR);
        }
        else
        {
            g.setColor(BLACK_SQUARE_COLOR);
        }

        g.fillRect(150 + file * 75, 150 + rank * 75, 75, 75);

        if (piece != null)
        {
            piece.drawPiece(g);
        }
    }
}
