package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotRegisteredException;

public class GameTest {
    public Player player1 = new Player(11, "Пётр", 16);
    public Player player2 = new Player(20, "Сергей", 48);
    public Player player3 = new Player(32, "Анна", 16);
    public Player player4 = new Player(8, "Алексей", 4);

    public Game myGame = new Game();

    @BeforeEach
    public void setup() {
        myGame.register(player1);
        myGame.register(player2);
        myGame.register(player3);
        myGame.register(player4);
    }

    @Test
    public void Player1WonRound() {
        int expected = 1;
        int actual = myGame.round("Сергей", "Алексей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Player2WonRound() {
        int expected = 2;
        int actual = myGame.round("Пётр", "Сергей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameDraw() {
        int expected = 0;
        int actual = myGame.round("Анна", "Пётр");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player1NotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            myGame.round("Пётр14", "Сергей");
        });
    }

    @Test
    public void player2NotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            myGame.round("Пётр", "Семён48");
        });
    }

}
