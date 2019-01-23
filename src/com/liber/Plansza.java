package com.liber;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Plansza extends JPanel implements MouseMotionListener
{
    Brick[] Wall;
    Belka b;
    Kulka a;
    SilnikKulki s;

    Plansza()
    {
        super();
        addMouseMotionListener(this);
        Wall = new Brick[16];
        b = new Belka(100);
        a = new Kulka(this,100,200,1,1);
        s = new SilnikKulki(a);

        int iteration = 0;
        for(int i=0; i<4; i++){
            for(int k=0; k<4; k++){
                Wall[iteration] = new Brick(((i+1)* 30)+(i*60),(15)+(k*30));
                iteration++;
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;

        g2d.fill(a);
        g2d.fill(b);

        for(int i=0; i<16; i++){
            Brick to_paint = Wall[i];
            g2d.fill(to_paint);
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        b.setX(e.getX()-50);
        repaint();
    }

    public void mouseDragged(MouseEvent e)
    {

    }
}