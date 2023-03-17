public class Game {

    private Board board;
    private GameViewer window;

    public Game()
    {
        board = new Board(8, 8);
        this.window = new GameViewer(this);
        board.setWindow(window);
    }

    public Board getBoard()
    {
        return board;
    }

    public void playGame()
    {
        window.repaint();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.playGame();
    }
}
