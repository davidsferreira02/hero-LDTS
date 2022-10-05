import com.googlecode.lanterna.TerminalSize;

import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;


import java.io.IOException;


public class Game {
    //Attributes
    private Hero hero;
    private Screen screen;
    private Arena arena;
    private Wall walls;

    //Methods
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null); //don't need a cursor
            this.screen.startScreen(); //start screen
            this.screen.doResizeIfNecessary(); //resize if needed


            this.hero = new Hero(10, 10);
            this.arena = new Arena(40, 20, hero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {

        boolean playing = true;
        while (playing) {
            draw();
            arena.moveMonsters();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
                playing = false;
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'Q') {
                screen.close();
                playing = false;
            }
            if (arena.verifyMonsterCollisions()) {
                screen.close();
                playing = false;
            }
            if (key.getKeyType() == KeyType.EOF) {
                playing = false;
            } else
                processKey(key);

        }
    }


    private void processKey(KeyStroke key) {
        arena.processKey(key);

    }

    private void draw() throws IOException {
        this.screen.clear();
        arena.draw(screen.newTextGraphics());
        this.screen.refresh();
    }
}