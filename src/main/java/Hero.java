
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;



public class Hero {
    private int x;
    private int y;


    Hero(int x,int y){
        this.x=x;
        this.y=y;
    }


    public int getX(){
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
    }
    public void draw(TerminalScreen screen){
        screen.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
    }
    public void moveUp(){
      y--;
    }
    public void moveDown(){
       y++;
    }
    public void moveLeft(){
     x--;
    }
    public void moveRight(){
      x++;
    }

}
