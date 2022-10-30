package com.aor.numbers;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HeroTest {
@Test
    public void drawHero_Test(){
    Hero hero=new Hero(10,10);
    TextGraphics mockito= Mockito.mock(TextGraphics.class);
hero.draw(mockito);
    Mockito.verify(mockito,Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
    Mockito.verify(mockito,Mockito.times(1)).enableModifiers(SGR.BOLD);
    Mockito.verify(mockito,Mockito.times(1)).putString(new TerminalPosition(hero.getPosition().getX(),
            hero.getPosition().getY()), "X");

    }
@Test
    public void  moveUpHero_Test(){
    Hero hero=new Hero(10,10);
    Assertions.assertEquals(hero.moveUp(),new Position(10,9));
    }
 @Test
 public void moveDownHero_Test(){
     Hero hero=new Hero(10,10);
     Assertions.assertEquals(hero.moveDown(),new Position(10,11));
    }
 @Test
 public void moveLeftHero_Test(){
     Hero hero=new Hero(10,10);
     Assertions.assertEquals(hero.moveLeft(),new Position(9,10));
    }
 @Test
 public void moveRightHero_Test(){
     Hero hero=new Hero(10,10);
     Assertions.assertEquals(hero.moveRight(),new Position(11,10));
    }
   @Test
   public void setPositionHero_Test(){
       Hero hero=new Hero(10,10);
       hero.setPosition(new Position(12,12));
       Assertions.assertEquals(hero.getPosition(),new Position(12,12));
    }
   @Test
   public void getPosition(){
       Hero hero=new Hero(10,10);
       Assertions.assertEquals(hero.getPosition(),new Position(10,10));
    }

}
