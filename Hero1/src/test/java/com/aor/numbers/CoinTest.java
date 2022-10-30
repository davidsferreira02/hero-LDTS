package com.aor.numbers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CoinTest {

    @Test
    public void getWidthCoin_Test(){
        Coin coin=new Coin(10,10);
        Assertions.assertEquals(coin.getWidth(),10);
    }
    @Test
    public void getHeightCoin_Test(){
        Coin coin=new Coin(10,10);
        Assertions.assertEquals(coin.getHeight(),10);
    }
    @Test
    public void getPositionCoin_Test(){
        Coin coin=new Coin(10,10);
        Assertions.assertEquals(coin.getPosition(),new Position(10,10));
    }
    @Test
    public void draw() {
        TextGraphics mockito= Mockito.mock(TextGraphics.class);
        Coin coin=new Coin(10,10);
        coin.draw(mockito);
        Mockito.verify(mockito,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        Mockito.verify(mockito,Mockito.times(1)).putString(new TerminalPosition(coin.getWidth(), coin.getHeight()), " ");
    }
}
