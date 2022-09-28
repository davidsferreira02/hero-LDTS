import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;


import javax.swing.*;
import java.io.IOException;


public class Game {
    private final TerminalScreen screen;
    private int x = 10;
    private int y = 10;

    public Game(int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don’t need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
        TerminalSize terminalSize = new TerminalSize(width, height);
        // DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
    }

    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void run() throws IOException {
     boolean play=true;
        while(play) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        boolean play = true;
        while (play == true) {
            switch (key.getKeyType()) {
                case ArrowUp:
                    y--;
                    break;
                case ArrowDown:
                    y++;
                    break;
                case ArrowLeft:
                    x--;
                    break;

                case ArrowRight:
                    x++;
                    break;
                case Character:
                    if (key.getCharacter() == 'q') {
                        screen.close();
                    }
                    play = false;
                    break;
                case EOF:
                    play = false;
                    screen.close();
                    break;
            }
            System.out.println(key);
            run();
        }
    }
}