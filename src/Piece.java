import java.awt.*;

public class Piece
{
    private final int value;
    private final boolean isWhite;
    private Image icon;
    private Square currentSquare;
    private boolean isCaptured;

    public Piece (int value, boolean isWhite, Image icon, Square currentSquare)
    {
        this.value = value;
        this.isWhite = isWhite;
        //this.icon = icon;
        this.currentSquare = currentSquare;
    }

    public int getValue() {
        return value;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public Image getIcon() {
        return icon;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    public void move(Square newSquare)
    {
        if (canMoveTo(newSquare))
        {
            if (newSquare.getPiece() != null)
            {
                capture(newSquare.getPiece());
            }
            this.currentSquare = newSquare;
            newSquare.setPiece(this);
        }
    }


    public boolean canMoveTo(Square square)
    {
        return true;
    }

    public void capture(Piece piece)
    {
        if (piece.isWhite())
        {
            currentSquare.getBoard().whitePieces.remove(piece);
        }
        else
        {
            currentSquare.getBoard().blackPieces.remove(piece);
        }
    }

    public void drawPiece(Graphics g)
    {
        g.drawImage(Board.WHITE_PAWN, 150 + currentSquare.getFile() * 75, 150 + currentSquare.getRank() * 75, 75, 75, currentSquare.getBoard().getWindow());
    }

    @Override
    public String toString() {
        return "pawn";
    }
}
