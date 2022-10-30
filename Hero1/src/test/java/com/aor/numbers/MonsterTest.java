package com.aor.numbers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterTest {

    @Test
    public void drawMonster_Test(){
        Monster monster=new Monster(10,10);
        TextGraphics mockito= Mockito.mock(TextGraphics.class);
        monster.draw(mockito);
        Mockito.verify(mockito,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(mockito,Mockito.times(1)).putString(new TerminalPosition(monster.getX(),monster.getY()), "O");
    }
    @Test
    public void  moveUpMonster_Test(){
        Monster monster=new Monster(10,10);
        Assertions.assertEquals(monster.moveUp(),new Position(10,9));
    }
    @Test
    public void moveDownMonster_Test(){
        Monster monster=new Monster(10,10);
        Assertions.assertEquals(monster.moveDown(),new Position(10,11));
    }
    @Test
    public void moveLeftMonster_Test(){
        Monster monster=new Monster(10,10);
        Assertions.assertEquals(monster.moveLeft(),new Position(9,10));
    }
    @Test
    public void moveRightMonster_Test(){
        Monster monster=new Monster(10,10);
        Assertions.assertEquals(monster.moveRight(),new Position(11,10));
    }
    @Test
    public void setPositionMonster_Test(){
        Monster monster=new Monster(10,10);
        monster.setPosition(new Position(12,12));
        Assertions.assertEquals(monster.getPosition(),new Position(12,12));
    }
    @Test
    public void getPositionMonster_Test(){
        Monster monster=new Monster(10,10);
        Assertions.assertEquals(monster.getPosition(),new Position(10,10));
    }

}
