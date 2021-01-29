
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class play extends JFrame implements ActionListener {

    public int start = 0;
    private girl g = new girl();
    private girl_2 g2 = new girl_2();
    private girl_3 g3 = new girl_3();
    start t = new start();
    Guide gd = new Guide();

    public play() {
        this.add(t);
        t.jb.addActionListener(this);
        t.jg.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t.jb) {
            this.setLocationRelativeTo(null);
            this.remove(t);
            this.setSize(1200, 700);
            this.add(g);
            g.jnext.addActionListener(this);
            g.requestFocusInWindow();
        }
        if (e.getSource() == t.jg) {
            this.setLocationRelativeTo(null);
            this.remove(t);
            this.setSize(1200, 700);
            this.add(gd);
            gd.jp.addActionListener(this);
            gd.requestFocusInWindow();
        }
        if (e.getSource() == gd.jp) {
            this.setLocationRelativeTo(null);
            this.remove(gd);
            this.setSize(1200, 700);
            this.add(g);
            g.jnext.addActionListener(this);
            g.requestFocusInWindow();
        }
        if (e.getSource() == g.jnext) {
            this.remove(g);
            this.add(g2);
            g2.H1 = g.H1;
            g2.H2 = g.H2;
            g2.H3 = g.H3;
            g2.H4 = g.H4;
            g2.H5 = g.H5;
            g2.money = g2.money + g.money;
            g2.jnext.addActionListener(this);
            g2.requestFocusInWindow();
        }
        if (e.getSource() == g2.jnext) {
            this.remove(g2);
            this.add(g3);
            g3.H1 = g2.H1;
            g3.H2 = g2.H2;
            g3.H3 = g2.H3;
            g3.H4 = g2.H4;
            g3.H5 = g2.H5;
            g3.money = g3.money + g2.money;
        }
        this.validate();
        this.repaint();
    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
