package com.aor.numbers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Wall extends Element {

public Wall(int x,int y){
    super(x,y);
}
public int getWallX(){
  return position.getX();
}
public int getWallY(){
    return position.getY();
}
public Position getPosition(){
    return position;
}

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(new TerminalPosition(this.getWallX(), this.getWallY()), " ");
    }

}
