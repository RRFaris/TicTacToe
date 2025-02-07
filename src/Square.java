import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private TicTacToeViewer window;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer window) {

        this.window = window;
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        // Draws the board
        g.setColor(Color.BLACK);
        g.drawRect(100 + col*100, 100 + row*100, 100, 100);

        if(isWinningSquare) {
            g.setColor(Color.GREEN);
            g.fillRect(100 + (col*100), 100 + (row*100), 100,100);
        }

        // Draws the correct marker
        if (marker.equals(TicTacToe.X_MARKER)) {
            g.drawImage(window.getXMarker(), 100 + (col*100), 100 + (row*100), 100, 100, window);
        }
        else if (marker.equals(TicTacToe.O_MARKER)) {
            g.drawImage(window.getOMarker(), 100 + (col*100), 100 + (row*100), 100, 100, window);
        }
    }
}
