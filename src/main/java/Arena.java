import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster>monsters;

    public Arena(int width, int height, Hero hero) {
        ;
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.walls = createWalls();
        this.coins=createCoins();
        this.monsters=createMonsters();
    }

    public void moveHero(Position position) {
        if (canMove(position))
            hero.setPosition(position);
        retrieveCoins();
    }
    private void setMonsterPosition(Position position,Monster monsters){
        if(canMove(position)){
            monsters.setPosition(position);
        }
    }

   public void moveMonsters(){
       Random random = new Random();
       for(Monster monster : monsters){
           switch (random.nextInt(4)){
               case 0:
                   setMonsterPosition(monster.moveDown(), monster);
                   break;
               case 1:
                   setMonsterPosition(monster.moveUp(), monster);
                   break;
               case 2:
                   setMonsterPosition(monster.moveRight(), monster);
                   break;
               case 3:
                   setMonsterPosition(monster.moveLeft(), monster);
                   break;
           }
       }

   }
    public boolean verifyMonsterCollisions(){
        for(Monster monster:monsters){
            if(monster.getPosition().equals(hero.getPosition())){
                return true;
            }
        }
        return false;
    }


    private boolean canMove(Position position) {
        if (position.getX() <0 || position.getX() >= width) {
            return false;
        }
         if (position.getY() < 0 || position.getY() >= height) {
            return false;
        }
         for(Wall wall:walls){
             if(wall.getPosition().equals(position)){
                 return false;
             }
         }

        return true;
    }
    public void retrieveCoins(){
        int index=0;
        for(int i=0;i<coins.size();i++){
            if(coins.get(index).getPosition().equals(hero.getPosition())){
                coins.remove(index);
            }
            else{
                index++;
            }
        }
        Integer a=0;
        if(a.equals(coins.size())){
            coins=createCoins();
        }
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
                }
        }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }
    private List<Monster> createMonsters(){
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for(Coin coin:coins){
            coin.draw(graphics);
        }
        for(Monster monster:monsters){
            monster.draw(graphics);
        }

    }

}