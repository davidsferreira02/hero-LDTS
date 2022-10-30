package com.aor.numbers;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    Element(int x,int y){
        this.position=new Position(x,y);
    }
    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    abstract public void draw(TextGraphics graphics);
}
