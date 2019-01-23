package com.liber;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Brick extends Rectangle2D.Float
{
    boolean up;
    Brick(int x, int y)
    {
        this.up = true;
        this.x = x;
        this.y = y;
        this.width=60;
        this.height=10;
    }

    void destroy(){
        this.height = 0;
        this.width = 0;
    }
}