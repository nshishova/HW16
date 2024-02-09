import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player fox = new Player(1, "Alex", 88);
    Player bear = new Player(364, "Maria", 111);


    @Test
    public void firstPlayerWin() {

        game.register(fox);
        game.register(bear);

        int expected = 1;
        int actual = game.round("Maria", "Alex");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerWin() {
        game.register(fox);
        game.register(bear);

        int expected = 2;
        int actual = game.round("Alex", "Maria");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void PlayersEqual() {
        Player fox = new Player(1, "Alex", 111);
        Player bear = new Player(364, "Maria", 111);
        game.register(fox);
        game.register(bear);

        int expected = 0;
        int actual = game.round("Alex", "Maria");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerIsNotExist() {


        game.register(fox);
        game.register(bear);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Alex", "Boris"));

    }

    @Test
    public void firstPlayerIsNotExist() {


        game.register(fox);
        game.register(bear);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Boris", "Alex"));

    }

}
