import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // Instance Variables
    private TicTacToe ticTacToe;

    private final int WINDOW_HEIGHT = 500;
    private final int WINDOW_WIDTH = 500;

    private Image OMarker;
    private Image XMarker;

    // Constructor
    public TicTacToeViewer(TicTacToe ticTacToe) {
        // Initializes backend
        this.ticTacToe = ticTacToe;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

        // Initializes images
        OMarker = new ImageIcon("Resources/OMark.png").getImage();
        XMarker = new ImageIcon("Resources/XMark.png").getImage();
    }

    // Methods
    public Image getOMarker() {
        return OMarker;
    }

    public Image getXMarker() {
        return XMarker;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe.getBoard()[i][j].draw(g);
            }
        }

        // Print the correct winner
        if (ticTacToe.getWinner().equals(ticTacToe.X_MARKER)) {
            g.setColor(Color.BLACK);
            g.drawString("X WINS!", 250, 450);
        }

        else if (ticTacToe.getWinner().equals(ticTacToe.O_MARKER)) {
            g.setColor(Color.BLACK);
            g.drawString("O WINS!", 250, 450);
        }

        else if (ticTacToe.checkTie()) {
            g.setColor(Color.BLACK);
            g.drawString("DRAW",250,450);
        }

        // Draw axes
        g.drawString("0", 50, 150);
        g.drawString("0", 150, 73);
        g.drawString("1", 50, 250);
        g.drawString("1", 250, 73);
        g.drawString("2", 50, 350);
        g.drawString("2", 350, 73);

    }



}
