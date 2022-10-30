package com.aor.numbers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallTest {

    @Test
    public void getWallX_Test(){
       Wall wall=new Wall(10,10);
        Assertions.assertEquals(wall.getWallX(),10);
    }
    @Test
    public void getWallY_Test(){
        Wall wall=new Wall(10,10);
        Assertions.assertEquals(wall.getWallY(),10);
    }
    @Test
    public void getPosition_Test(){
        Wall wall=new Wall(10,10);
        Assertions.assertEquals(wall.getPosition(),new Position(10,10));
    }

    @Test
    public void draw_Wall() {
        Wall wall=new Wall(10,10);
        TextGraphics mockito= Mockito.mock(TextGraphics.class);
        wall.draw(mockito);
        Mockito.verify(mockito,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FF0000"));

        Mockito.verify(mockito,Mockito.times(1)).putString(new TerminalPosition(wall.getWallX(), wall.getWallY()), " ");

    }

}
