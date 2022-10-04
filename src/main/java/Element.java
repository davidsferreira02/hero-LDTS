import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    Element(int x,int y){
        this.position=new Position(x,y);
    }

abstract public void draw(TextGraphics graphics);
}
