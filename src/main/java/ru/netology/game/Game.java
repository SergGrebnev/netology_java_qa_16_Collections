package ru.netology.game;

import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    //Список всех зарегистрированных игроков
    List<Player> registeredList = new ArrayList<>();

    //метод регистрации игрока, если игрок не зарегистрирован,
    // то он не сможет играть в турнире
    public void register(Player player) {
        registeredList.add(player);
    }

    //Метод определения номера игрока в списке по его имени
    //-1 - в списках не значится
    private int numberPlayer(String playerName) {
        int number = -1;
        for (int i = 0; i < registeredList.size(); i++) {
            if (registeredList.get(i).getName().equals(playerName)) {
                number = i;
            }
        }
        if (number < 0) {      //проверка регистрации игрока
            throw new NotRegisteredException(
                    "Игрок " + playerName + " не зарегистрирован"
            );
        }
        return number;
    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        int numberPlayer1 = numberPlayer(playerName1);
        int numberPlayer2 = numberPlayer(playerName2);

        //0 - ничья,
        // 1 - 1 игрок победил,
        // 2 - 2 игрок победил
        if (registeredList.get(numberPlayer1).getStrength() ==
                registeredList.get(numberPlayer2).getStrength()) {
            return 0;
        } else if (registeredList.get(numberPlayer1).getStrength() >
                registeredList.get(numberPlayer2).getStrength()) {
            return 1;
        } else {
            return 2;
        }


    }
}
