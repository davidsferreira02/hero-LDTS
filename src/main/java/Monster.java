import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {


   public Monster(int x,int y){
       super(x,y);
    }
    public Position moveUp(){
       return new Position(getX(),getY()-1);
    }
    public Position moveLeft(){
        return new Position(getX()-1,getY());
    }
    public Position moveRight(){
        return new Position(getX()+1,getY());
    }
    public Position moveDown(){
        return new Position(getX(),getY()+1);
    }
    public Position getPosition(){
       return position;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(new TerminalPosition(getX(),getY()), "O");
    }


}
