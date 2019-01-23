package com.liber;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Kulka extends Ellipse2D.Float
{
    Plansza p;
    int dx,dy;
    int points;

    Kulka(Plansza p,int x,int y,int dx,int dy)
    {
        this.x=x;
        this.y=y;
        this.width=10;
        this.height=10;
        this.points = 0;

        this.p=p;
        this.dx=dx;
        this.dy=dy;
    }

    boolean BallPadCollsion(Rectangle2D.Float pad) {
        if(this.intersects(pad)){
            return true;
        } else {
            return false;}
    }

    boolean BoardCollisionX(){
        if(getMinX()<0 || getMaxX()>p.getWidth())  { return true;} else return false;
    }

    boolean BoardCollisionY(){
        if(getMinY()<0 || getMaxY()>p.getHeight()) { return true;} else return false;
    }

    void nextKrok() {
        x+=dx;
        y+=dy;

        if(BoardCollisionX())  { dx =- dx;};
        if(BoardCollisionY()) { dy =- dy;};
        if(BallPadCollsion(p.b)) { dy =- dy;}

        for(int i=0; i<16; i++){
            if(p.Wall[i].up){
                if (BallPadCollsion(p.Wall[i])) {
                    this.points += 1;
                    dy =- dy;
                    p.Wall[i].destroy();
                    p.Wall[i].up = false;
                    p.repaint();
                }
            }
        }

        p.repaint();
    }
}
