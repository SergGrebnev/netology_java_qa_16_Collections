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


    //Проверка регистрации игрока
    //-1 - в списках не значится
    private void checkRegistration(String playerName) {
        if (!registeredList.containsKey(playerName)) {      //проверка регистрации игрока
            throw new NotRegisteredException(
                    "Игрок " + playerName + " не зарегистрирован"
            );
        }
    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        checkRegistration(playerName1);
        checkRegistration(playerName2);
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
