package ru.netology.game;

import ru.netology.exception.NotRegisteredException;

import java.util.HashMap;

public class Game {

    //Мапа (словарь) всех зарегистрированных игроков
    HashMap<String, Player> registeredList = new HashMap<>();

    //метод регистрации игрока, если игрок не зарегистрирован,
    // то он не сможет играть в турнире
    public void register(Player player) {

        registeredList.put(player.getName(), player);

    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
            if (!registeredList.containsKey(playerName1)) { //проверка регистрации игрока 1
                throw new NotRegisteredException(
                        "Игрок " + playerName1 + " не зарегистрирован"
                );
            }
            if (!registeredList.containsKey(playerName2)) { //проверка регистрации игрока 2
                throw new NotRegisteredException(
                        "Игрок " + playerName2 + " не зарегистрирован"
                );
            }


        // Битва
        //0 - ничья,
        // 1 - 1 игрок победил,
        // 2 - 2 игрок победил
        if (registeredList.get(playerName1).getStrength() ==
                registeredList.get(playerName2).getStrength()) {
            return 0;
        } else if (registeredList.get(playerName1).getStrength() >
                registeredList.get(playerName2).getStrength()) {
            return 1;
        } else {
            return 2;
        }


    }
}
