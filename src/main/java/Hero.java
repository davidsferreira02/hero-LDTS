
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;



public class Hero {

    private Position position;

    Hero(Position position){
        this.position=position;
    }


    public void draw(TerminalScreen screen){
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }
    public Position moveUp(){
      return new Position(position.getX(), position.getY()-1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }
    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }
    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }
    public void setPosition(Position position){
     this.position=position;
    }
    public Position getPosition(){
        return position;
    }

}
