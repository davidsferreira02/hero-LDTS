import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;
    Element(Position position){
        this.position=position;
    }

abstract public void draw(TextGraphics graphics);
}
