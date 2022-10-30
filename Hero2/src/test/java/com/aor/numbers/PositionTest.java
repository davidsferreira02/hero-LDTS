package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void getXPosition_Test(){
      Position position=new Position(10,10);
      Assertions.assertEquals(position.getX(),10);
    }

    @Test
    public void getYPosition_Test(){
        Position position=new Position(10,10);
        Assertions.assertEquals(position.getY(),10);
    }
    @Test
    public void setXPosition_Test(){
        Position position=new Position(10,10);
        position.setX(12);
        Assertions.assertEquals(position.getX(),12);
    }

    @Test
    public void setYPosition_Test(){
        Position position=new Position(10,10);
        position.setY(12);
        Assertions.assertEquals(position.getY(),12);
    }
}
