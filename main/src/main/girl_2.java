
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

public class girl_2 extends JPanel {

    private int x;
    private int change;
    private int y = 0;
    private int check = 0;
    private int check_Stop = 0;
    private Timer timer;
    public String bg[] = {"bg1.png", "bg2.png", "bg3.png", "bg4.png", "bg1_N.png", "bg2_N.png", "bg3_N.png", "bg4_N.png"};
    public String wolf[] = {"wolf_cub.png", "wolf_jump.png"};
    public String wolf1[] = {"wolf_cub_1.png", "wolf_jump_1.png"};
    JButton jnext = new JButton("N E X T");
    JButton jback = new JButton("B A C K");
    private boolean end = false;
    private boolean next = false;
    private boolean flower = false;
    private boolean grow = false;
    public Random r = new Random();
    public int r2;
    public int r3;
    public int f = 0;
    public int f1 = 0;
    public int j = 0;
    public int PS = -99;
    public int money = 3000;
    public boolean H1 = true;
    public boolean H2 = true;
    public boolean H3 = true;
    public boolean H4 = true;
    public boolean H5 = true;
    public boolean die = false;
    girl g1 = new girl();
    photo p = new photo();

    girl_2() {
        if (next == false && end == false && die == false) {
            r2 = r.rand1();
            j = r.rand();
            k = r.rand();
            change = 100;
            x = 100;
            r2 = r.rand1();
            r3 = r.randW();
            timer = new Timer(100, new Listener());
            timer.start();
            this.setFocusable(true);
            this.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        check_Stop = 0;
                        change = change + 10;
                        x = x + 10;
                        if (check != 1) {
                            check = 1;
                        } else {
                            check = -11;
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        check_Stop = 0;
                        x = x - 10;
                        change = change - 10;
                        if (check != 2) {
                            check = 2;
                        } else {
                            check = -22;
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_UP && y == 0) {
                        check_Stop = 0;
                        change = change;
                        if (check != 3) {
                            x = x;
                            check = 3;
                        } else {
                            check = 88;
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_SPACE && y == 0) {
                        check_Stop = 0;
                        change = change;
                        if (check != 4) {
                            x = x;
                            check = 4;
                        } else {
                            check = -88;
                        }
                    } else {
                        check = 88;
                    }
                }
            });
            this.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    check_Stop = 0;
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    check_Stop = 0;
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    check_Stop = 100 + check;
                }
            });
        }

    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
    int k;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (next == false && end == false && die == false) {
            Image image1 = new ImageIcon(this.getClass().getResource(bg[j])).getImage();
            g.drawImage(image1, 0, 0, getWidth(), getHeight(), this);
            Image image_W_J = new ImageIcon(this.getClass().getResource(wolf1[r2])).getImage();
            g.drawImage(image_W_J, r3, getHeight() - 280, this);

            if (change <= 10) {
                x = 0;
                change = 0;
                if (flower == true) {
                    g.drawImage(p.image_r_F, 0, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image_r, 0, getHeight() - 280 + y, this);
                }
            } else if (check_Stop == 102 || check_Stop == 78 || check_Stop == 104 || check_Stop == 56) {
                if (flower == true) {
                    g.drawImage(p.image_r_F, x, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image_r, x, getHeight() - 280 + y, this);
                }
            } else if (check_Stop == 101 || check_Stop == 89) {
                if (flower == true) {
                    g.drawImage(p.image_SF, x, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image, x, getHeight() - 280 + y, this);
                }
            } else if (x >= getWidth()) {
                x = 0;
                r2 = r.rand1();
                r3 = r.randW();
                f = r.rand1();
                f1 = r.randW();
                if (flower == true) {
                    g.drawImage(p.image_SF, 0, getHeight() - 280, this);
                } else {
                    g.drawImage(p.image, 0, getHeight() - 280, this);
                }
            } else if (check == 1 && check_Stop == 0) {
                if (flower == true) {
                    g.drawImage(p.image_L_F, x, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image_L, x, getHeight() - 280 + y, this);
                }
            } else if (check == -11 && check_Stop == 0) {
                if (flower == true) {
                    g.drawImage(p.image_R_F, x, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image_R, x, getHeight() - 280 + y, this);
                }
            } else if (check == 2 && check_Stop == 0) {
                if (x <= -80) {
                    x = getWidth();
                    r2 = r.rand1();
                    r3 = r.randW();
                    if (flower == true) {
                        g.drawImage(p.image_L_r_F, x, getHeight() - 280 + y, this);
                    } else {
                        g.drawImage(p.image_L_r, x, getHeight() - 280 + y, this);
                    }
                } else {
                    if (flower == true) {
                        g.drawImage(p.image_L_r_F, x, getHeight() - 280 + y, this);
                    } else {
                        g.drawImage(p.image_L_r, x, getHeight() - 280 + y, this);
                    }
                }
            } else if (check == -22 && check_Stop == 0) {
                if (flower == true) {
                    g.drawImage(p.image_R_r_F, x, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image_R_r, x, getHeight() - 280 + y, this);
                }
            } else if (check == 3 && check_Stop == 0) {
                if (x >= getWidth() + 10) {
                    r2 = r.rand1();
                    r3 = r.randW();
                    if (flower == true) {
                        g.drawImage(p.image_L_F, 100, getHeight() - 280 + y, this);
                    } else {
                        g.drawImage(p.image_L, 100, getHeight() - 280 + y, this);
                    }
                    x = 100;
                } else {
                    if (flower == true) {
                        g.drawImage(p.image_L_F, x + 300, getHeight() - 470 + y, this);
                    } else {
                        g.drawImage(p.image_L, x + 300, getHeight() - 470 + y, this);
                    }
                    x = x + 300;
                    change = change + 300;
                }
            } else if (check == 4 && check_Stop == 0) {
                if (x <= -80) {
                    x = getWidth();
                    r2 = r.rand1();
                    r3 = r.randW();
                    if (flower == true) {
                        g.drawImage(p.image_L_r_F, x, getHeight() - 280 + y, this);
                    } else {
                        g.drawImage(p.image_L_r, x, getHeight() - 280 + y, this);
                    }
                } else {
                    if (flower == true) {
                        g.drawImage(p.image_L_r_F, x - 300, getHeight() - 470 + y, this);
                    } else {
                        g.drawImage(p.image_L_r, x - 300, getHeight() - 470 + y, this);
                    }
                    x = x - 300;
                    change = change - 300;
                }
            } else {
                if (flower == true) {
                    g.drawImage(p.image_SF, x, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image, x, getHeight() - 280 + y, this);
                }
            }
            if (change <= 1200) {
                g.drawImage(p.image_GM, 0, getHeight() - 320, this);
            }
            if (change >= 4000 && flower == true) {
                g.drawImage(p.image_shop, getWidth() - 300, getHeight() - 460, this);
            }
            if (((r3 - x) <= 50 && (r3 - x) >= 0) || (x - r3) >= 0 && (x - r3) <= 50) {
                if (r2 == 0) {
                    x = x - 100;
                    change = change - 100;
                    r2 = r.rand1();
                    r3 = r.randW();
                    if (H1 == true) {
                        H1 = false;
                    } else if (H2 == true) {
                        H2 = false;
                    } else if (H3 == true) {
                        H3 = false;
                    } else if (H4 == true) {
                        H4 = false;
                    } else if (H5 == true) {
                        H5 = false;
                        die = true;
                    }
                } else if (r2 == 1) {
                    x = 0;
                    change = 0;
                    r2 = r.rand1();
                    r3 = r.randW();
                    if (H1 == true && H2 == true) {
                        H1 = false;
                        H2 = false;
                    } else if (H2 == true && H3 == true) {
                        H2 = false;
                        H3 = false;
                    } else if (H3 == true && H4 == true) {
                        H3 = false;
                        H4 = false;
                    } else if (H4 == true && H5 == true) {
                        H4 = false;
                        H5 = false;
                        die = true;
                    } else if (H5 == true) {
                        H5 = false;
                        die = true;
                    }
                }
            }
            if (grow == false) {
                if (f == 1) {
                    g.drawImage(p.imageF, f1, getHeight() - 300, this);
                    PS = f1;
                }
            }
            if ((((PS - x) <= 20 && (PS - x) >= 0) || (x - PS) >= 0 && (x - PS) <= 20) && y == 0) {
                flower = true;
                grow = true;
            }
            if (H1 == true) {
                g.drawImage(p.imageH, 820, 20, this);
            }
            if (H2 == true) {
                g.drawImage(p.imageH, 890, 20, this);
            }
            if (H3 == true) {
                g.drawImage(p.imageH, 960, 20, this);
            }
            if (H4 == true) {
                g.drawImage(p.imageH, 1030, 20, this);
            }
            if (H5 == true) {
                g.drawImage(p.imageH, 1100, 20, this);
            }
            if (((((getWidth() - 300) - x) <= 50 && ((getWidth() - 300) - x) >= 0) || (x - (getWidth() - 300)) >= 0 && (x - (getWidth() - 300)) <= 50) && (change >= 4000) && flower == true) {
                this.next = true;
                return;
            }
            g.drawImage(p.imageS2, getWidth() / 2 - 50, 20, this);
        } else if (next == true && end == false && die == false) {
            Image image1 = new ImageIcon(this.getClass().getResource(bg[k])).getImage();
            g.drawImage(image1, 0, 0, getWidth(), getHeight(), this);
            Image image_W = new ImageIcon(this.getClass().getResource(wolf[r2])).getImage();
            g.drawImage(image_W, r3, getHeight() - 280, this);
            if (change >= 4900) {
                g.drawImage(p.image_SM, getWidth() - 300, getHeight() - 280 + y, this);
                change = 4900;
            } else if (check_Stop == 102 || check_Stop == 78 || check_Stop == 104 || check_Stop == 56) {
                g.drawImage(p.image_r_M, x, getHeight() - 280 + y, this);
            } else if (check_Stop == 101 || check_Stop == 89) {
                g.drawImage(p.image_SM, x, getHeight() - 280 + y, this);
            } else if (x <= -10) {
                x = getWidth();
                r2 = r.rand1();
                r3 = r.randW();
                g.drawImage(p.image_SM, x, getHeight() - 280, this);
            } else if (check == 1 && check_Stop == 0) {
                g.drawImage(p.image_L_M, x, getHeight() - 280 + y, this);
            } else if (check == -11 && check_Stop == 0) {
                g.drawImage(p.image_R_M, x, getHeight() - 280 + y, this);
            } else if (check == 2 && check_Stop == 0) {
                if (x >= getWidth() + 10) {
                    x = 0;
                    r2 = r.rand1();
                    r3 = r.randW();
                    g.drawImage(p.image_L_r_M, x, getHeight() - 280 + y, this);
                } else {
                    g.drawImage(p.image_L_r_M, x, getHeight() - 280 + y, this);
                }
            } else if (check == -22 && check_Stop == 0) {
                g.drawImage(p.image_R_r_M, x, getHeight() - 280 + y, this);
            } else if (check == 3 && check_Stop == 0) {
                if (x <= -10) {
                    r2 = r.rand1();
                    r3 = r.randW();
                    g.drawImage(p.image_L_r_M, 0, getHeight() - 280 + y, this);
                    x = 0;
                } else {
                    g.drawImage(p.image_L_r_M, x - 300, getHeight() - 470 + y, this);
                    x = x - 300;
                    change = change - 300;
                }
            } else if (check == 4 && check_Stop == 0) {
                if (x >= getWidth() + 10) {
                    r2 = r.rand1();
                    r3 = r.randW();
                    g.drawImage(p.image_L_M, 100, getHeight() - 280 + y, this);
                    x = 100;
                } else {
                    g.drawImage(p.image_L_M, x + 300, getHeight() - 470 + y, this);
                    x = x + 300;
                    change = change + 300;
                }
            } else {
                g.drawImage(p.image_r_M, x, getHeight() - 280 + y, this);
            }
            if (change <= 100) {
                g.drawImage(p.image_GM, 0, getHeight() - 320, this);
            }
            if (change >= 4000) {
                g.drawImage(p.image_shop, getWidth() - 300, getHeight() - 460, this);
            }
            if (((r3 - x) <= 50 && (r3 - x) >= 0) || (x - r3) >= 0 && (x - r3) <= 50) {
                if (r2 == 0) {
                    x = x - 100;
                    change = change - 100;
                    money = money - 100;
                    r2 = r.rand1();
                    r3 = r.randW();
                    if (H1 == true) {
                        H1 = false;
                    } else if (H2 == true) {
                        H2 = false;
                    } else if (H3 == true) {
                        H3 = false;
                    } else if (H4 == true) {
                        H4 = false;
                    } else if (H5 == true) {
                        H5 = false;
                        die = true;
                    }
                } else if (r2 == 1) {
                    x = 0;
                    change = 0;
                    money = money - 1000;
                    r2 = r.rand1();
                    r3 = r.randW();
                    if (H1 == true && H2 == true) {
                        H1 = false;
                        H2 = false;
                    } else if (H2 == true && H3 == true) {
                        H2 = false;
                        H3 = false;
                    } else if (H3 == true && H4 == true) {
                        H3 = false;
                        H4 = false;
                    } else if (H4 == true && H5 == true) {
                        H4 = false;
                        H5 = false;
                        die = true;
                    } else if (H5 == true) {
                        H5 = false;
                        die = true;
                    }
                }
            }
            if (H1 == true) {
                g.drawImage(p.imageH, 820, 20, this);
            }
            if (H2 == true) {
                g.drawImage(p.imageH, 890, 20, this);
            }
            if (H3 == true) {
                g.drawImage(p.imageH, 960, 20, this);
            }
            if (H4 == true) {
                g.drawImage(p.imageH, 1030, 20, this);
            }
            if (H5 == true) {
                g.drawImage(p.imageH, 1100, 20, this);
            }
            if (money < 0) {
                die = true;
            }
            if (change <= 0 && x <= 10) {
                end = true;
            }
            g.drawImage(p.imageS2, getWidth() / 2 - 50, 20, this);
            g.setColor(Color.WHITE);
            Font font = new Font("Times New Roman", Font.BOLD, 50);
            g.setFont(font);
            g.drawString("Money : " + money, 10, 60);
        } else if (next == true && die == false) {
            g.drawImage(p.imageWin, 0, 0, getWidth(), getHeight(), this);
            jnext.setForeground(Color.WHITE);
            jnext.setBackground(Color.RED);
            jnext.setBounds(700, 500, 300, 80);
            add(jnext);
        } else {
            g.drawImage(p.imageOver, 0, 0, getWidth(), getHeight(), this);
            g.setColor(Color.RED);
            Font font = new Font("Times New Roman", Font.BOLD, 30);
            g.setFont(font);
            if (next == true) {
                g.drawString("Total Money : " + money, 495, 400);
            } else {
                g.drawString("Total Money : " + g1.money, 495, 400);
            }
        }
    }
}
