import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Board
{
    private Square[][] board;

    private GameViewer window;
    public LinkedList<Piece> whitePieces;
    public LinkedList<Piece> blackPieces;

    public static final Image WHITE_PAWN = new ImageIcon("Resources/wp.png").getImage();

    public Board(int ranks, int files)
    {
        this.board = new Square[ranks][files];
        whitePieces = new LinkedList<>();
        blackPieces = new LinkedList<>();

        boolean whiteSquare = true;
        for (int i = 0; i < ranks; i++)
        {
            for (int j = 0; j < files; j++)
            {
                if ((i % 2 == 0 && j % 2 == 0) || i % 2 == j % 2)
                {
                    board[i][j] = new Square(this, i, j, true);
                }
                else
                {
                    board[i][j] = new Square(this, i, j, false);
                }

            }
        }
        for (int i = 0; i < files; i++)
        {
            Piece pawn = new Piece(1, true, WHITE_PAWN, board[6][i]);
            Piece bPawn = new Piece(1, false, WHITE_PAWN, board[1][i]);
            board[6][i].setPiece(pawn);
            board[1][i].setPiece(bPawn);
        }
    }

    public GameViewer getWindow()
    {
        return window;
    }
    public void setWindow(GameViewer window)
    {
        this.window = window;
    }
    public void printBoard()
    {
        for (Square[] row : board)
        {
            for (Square s : row)
            {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public void drawBoard(Graphics g)
    {
        for (Square[] row : board)
        {
            for (Square s : row)
            {
                s.drawSquare(g);
            }
        }
    }
}
