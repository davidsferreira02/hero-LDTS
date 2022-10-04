import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


public class Coin extends Element {


    Coin(int x, int y) {
        super(x,y);
    }

    public int getWidth(){
        return getX();
    }
    public int getHeight(){
        return getY();
    }
    public Position getPosition(){
        return position;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.putString(new TerminalPosition(getWidth(), getHeight()), " ");
    }

}
