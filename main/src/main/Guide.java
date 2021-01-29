
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Guide extends JPanel {

    JPanel jbg = new JPanel(new BorderLayout());
    JButton jp = new JButton("Go");

    public Guide() {
        setLayout(null);
        jp.setBounds(1010, 200, 80, 80);
        jp.setBackground(Color.YELLOW);
        jp.setForeground(Color.BLACK);
        Font font = new Font("Bernard MT Condensed", Font.BOLD, 30);
        jp.setFont(font);
        jp.addMouseListener(new Mouse());
        add(jp);
    }

    class Mouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jp.setBackground(Color.RED);
            jp.setForeground(Color.WHITE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jp.setBackground(Color.YELLOW);
            jp.setForeground(Color.BLACK);
        }
    }
    private Image imageH = new ImageIcon(this.getClass().getResource("how to.png")).getImage();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageH, 0, 0, getWidth(), getHeight(), this);
    }
}
