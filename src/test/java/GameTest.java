import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.game.Game;
import ru.netology.game.NotRegisteredException;
import ru.netology.game.Player;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player vova = new Player(1, "Вова", 110);
        Player misha = new Player(2, "Миша", 115);
        Game game = new Game();
        game.register(vova);
        game.register(misha);
        int actual = game.round("Миша", "Вова");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player vova = new Player(1, "Вова", 115);
        Player misha = new Player(2, "Миша", 105);
        Game game = new Game();
        game.register(vova);
        game.register(misha);
        int actual = game.round("Миша", "Вова");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothPlayesEqual() {
        Player vova = new Player(1, "Вова", 115);
        Player misha = new Player(2, "Миша", 115);
        Game game = new Game();
        game.register(vova);
        game.register(misha);
        int actual = game.round("Миша", "Вова");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player vova = new Player(1, "Вова", 115);
        Player misha = new Player(2, "Миша", 125);
        Game game = new Game();
        game.register(vova);
        game.register(misha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Игорь", "Миша"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player vova = new Player(1, "Вова", 115);
        Player misha = new Player(2, "Миша", 125);
        Game game = new Game();
        game.register(vova);
        game.register(misha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вова", "Саша"));
    }

    @Test
    public void testWhenBothPlayersNotExist() {
        Player vova = new Player(1, "Вова", 115);
        Player misha = new Player(2, "Миша", 125);
        Game game = new Game();
        game.register(vova);
        game.register(misha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Игорь", "Саша"));
    }
}


