package Players;

import Players.PlayersAtributes.Games;
import Players.PlayersAtributes.Rating;

import java.util.HashSet;
import java.util.Set;

public class Player implements Comparable<Player> {
    private String nikName;
    public Set<Games> games = new HashSet<>();
    public Rating rating;


    public Player(String nikName, Games game1, Games game2, Games game3) {
        this.nikName = nikName;
        this.games.add(game1);
        this.games.add(game2);
        this.games.add(game3);
        this.rating = new Rating(this.games);
    }

    public String getNikName() {
        return nikName;
    }

    public Integer getRatingInAllGames() {
        Integer count = 0;
        for (Integer rate : this.rating.ratingMap.values())
            count += rate;
        return count;
    }


    @Override
    public int compareTo(Player p) {

        return p.getRatingInAllGames() - this.getRatingInAllGames();
    }

    @Override
    public String toString() {
        return nikName;
    }

    public int compareToGame(Player p, Games game) {
        return this.rating.ratingMap.get(game) - p.rating.ratingMap.get(game);
    }
}
