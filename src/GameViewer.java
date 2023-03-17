import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame
{
    public static final int WINDOW_HEIGHT = 900;
    public static final int WINDOW_WIDTH = WINDOW_HEIGHT;
    public static final int MARGIN_SIZE = 150;
    public static final Color BG_COLOR = new Color(50,46,43);
    private Game game;
    public GameViewer(Game game)
    {
        this.game = game;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(BG_COLOR);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        game.getBoard().drawBoard(g);
    }
}
