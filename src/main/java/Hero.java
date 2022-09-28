
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;



public class Hero {
   /* private int x;
    private int y;*/
    private Position position=new Position(10,10);

    Hero(Position position){
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }


    /*public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }*/
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

}
