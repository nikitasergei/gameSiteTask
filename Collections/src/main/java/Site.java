import Exceptions.NoGameFoundException;
import Exceptions.NoPopularGameException;
import Exceptions.UserAlreadyExistsException;
import Players.Player;
import Players.PlayersAtributes.Games;

import java.util.*;

public class Site implements SiteService {

    private Map<String, Player> siteMap;
    private Map<Games, Set<Player>> gameMap;

    Site() {
        this.siteMap = new HashMap<>();
        this.gameMap = new HashMap<>();
    }

    @Override
    public Player createPlayer(String nikName, Games game1, Games game2, Games game3) throws UserAlreadyExistsException {
        Player player = new Player(nikName, game1, game2, game3);
        isRegistered(player);
        return player;
    }

    @Override
    public void win(Player player, Games game) throws NoGameFoundException {
        Integer rat = player.rating.ratingMap.get(game);
        if (rat == null)
            throw new NoGameFoundException();
        else {
            rat++;
            player.rating.ratingMap.put(game, rat);
        }
    }

    @Override
    public Set<Games> getPopularGames() throws NoPopularGameException {
        Set<Games> toCompare = Games.gamesToCompare();
        Iterator<Player> iterate = this.siteMap.values().iterator();
        while (iterate.hasNext()) {
            toCompare.retainAll(iterate.next().games);
        }
        if (toCompare.isEmpty())
            throw new NoPopularGameException();
        return toCompare;
    }

    @Override
    public Integer getRating(Player player, Games game) throws NoGameFoundException {
        if (player.rating.ratingMap.get(game) == null)
            throw new NoGameFoundException();
        else return player.rating.ratingMap.get(game);
    }

    @Override
    public Player[] getTopTen(Games game) throws NoGameFoundException {
        Player[] setPlayers = this.gameMap.get(game).toArray(new Player[gameMap.size()]);
        for (int i = 0; i < setPlayers.length - 1; i++) {
            for (int j = i + 1; j < setPlayers.length; j++) {
                if (setPlayers[i].compareToGame(setPlayers[j], game) < 0) {
                    Player p = setPlayers[i];
                    setPlayers[i] = setPlayers[j];
                    setPlayers[j] = p;
                }
            }
        }
        return setPlayers;
    }

    @Override
    public List<Player> getAllTimeScoreLeader() {
        List<Player> topAllTime = new ArrayList<>();
        topAllTime.addAll(this.siteMap.values());
        Collections.sort(topAllTime);
        return topAllTime;
    }

    private void isRegistered(Player player) throws UserAlreadyExistsException {
        if (this.siteMap.get(player.getNikName()) != null)
            throw new UserAlreadyExistsException();

        else {
            siteMap.put(player.getNikName(), player);
            for (Games game : player.games) {
                if (gameMap.get(game) == null) {
                    Set<Player> set1 = new HashSet<>();
                    set1.add(player);
                    gameMap.put(game, set1);
                } else
                    gameMap.get(game).add(player);
            }
        }
    }

}
