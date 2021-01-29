
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class start extends JPanel {

    JPanel jbg = new JPanel(new BorderLayout());
    JButton jb = new JButton("S t a r t");
    JButton jg = new JButton("Guide");

    public start() {
        setLayout(null);
        jb.setBounds(300, 500, 300, 80);
        jb.setBackground(Color.YELLOW);
        jb.setForeground(Color.BLACK);
        Font font = new Font("Bernard MT Condensed", Font.BOLD, 30);
        jb.setFont(font);
        jb.addMouseListener(new Mouse());
        jg.setBounds(650, 500, 300, 80);
        jg.setBackground(Color.YELLOW);
        jg.setForeground(Color.BLACK);
        jg.setFont(font);
        jg.addMouseListener(new Mouse1());
        add(jb);
        add(jg);
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
            jb.setBackground(Color.RED);
            jb.setForeground(Color.WHITE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jb.setBackground(Color.YELLOW);
            jb.setForeground(Color.BLACK);
        }
    }

    class Mouse1 implements MouseListener {

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
            jg.setBackground(Color.RED);
            jg.setForeground(Color.WHITE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jg.setBackground(Color.YELLOW);
            jg.setForeground(Color.BLACK);
        }
    }
    private Image imageS = new ImageIcon(this.getClass().getResource("start.png")).getImage();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageS, 0, 0, getWidth(), getHeight(), this);
    }
}
