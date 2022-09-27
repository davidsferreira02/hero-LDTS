import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import java.io.IOException;


public class Game {
   //FIELDS
   private Screen screen;
    public static void main(String args[]) throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

    }

    private void draw() throws IOException {

        screen.clear();
        screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')
                [0]);
        screen.refresh();
    }
    public void run()throws IOException{

    }
}