package Players.PlayersAtributes;

import java.util.HashSet;
import java.util.Set;


/**
 * If we can't in Games' name from console,
 * I decided to create a Enum-class of 6 Games,
 * which players will choose to play
 */
public enum Games {
    GAME1,GAME2,GAME3,GAME4,GAME5,GAME6;

public static Set<Games> gamesToCompare (){
    Set<Games> gamesToCompare = new HashSet<>();
    gamesToCompare.add(Games.GAME1);
    gamesToCompare.add(Games.GAME2);
    gamesToCompare.add(Games.GAME3);
    gamesToCompare.add(Games.GAME4);
    gamesToCompare.add(Games.GAME5);
    gamesToCompare.add(Games.GAME6);
    return gamesToCompare;
    }

}
