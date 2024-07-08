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

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        int numberPlayer1 = -1;
        int numberPlayer2 = -1;
        for (int i = 0; i < registeredList.size(); i++) {
            if (registeredList.get(i).getName() == playerName1) { //определение номера в списке игрока 1
                numberPlayer1 = i;
            }
            if (registeredList.get(i).getName() == playerName2) { //определение номера в списке игрока 2
                numberPlayer2 = i;
            }
        }
        if (numberPlayer1 < 0) {      //проверка регистрации игрока
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (numberPlayer2 < 0) {     //проверка регистрации игрока
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован"
            );
        }

        // Битва
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
