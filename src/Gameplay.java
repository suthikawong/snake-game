import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private Color backgroundColor;
    private Color borderColor;
    private int borderSize;
    private int gridSize;

    public Gameplay() {
        backgroundColor = new Color(40, 40, 40);
        borderColor = Color.BLACK;
        borderSize = 10;
        gridSize = 20;

        // border
        setBackground(backgroundColor);
        setBorder(BorderFactory.createLineBorder(borderColor, borderSize));
    }

    @Override
    public void paint(Graphics g) {
        // board
        super.paintComponent(g);
        super.printBorder(g);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
