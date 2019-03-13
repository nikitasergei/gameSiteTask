import Exceptions.NoGameFoundException;
import Exceptions.NoPopularGameException;
import Exceptions.UserAlreadyExistsException;
import Players.PlayersAtributes.Games;
import Players.Player;
import java.util.List;
import java.util.Set;

public interface SiteService {

    /**
     *  Return player with @param
     * @param nikName - player's nikName
     * @param game1 - the first game, which the player play
     * @param game2 - the second game, which the player play
     * @param game3 - the third game, which the player play
     * @return - object, belong to class Player
     * @throws UserAlreadyExistsException
     */
    Player createPlayer(String nikName, Games game1, Games game2, Games game3) throws UserAlreadyExistsException;

    /**
     *
     * @param player - who won in a game;
     * @param game - in what game player won;
     * @throws NoGameFoundException
     */
    void win(Player player, Games game) throws NoGameFoundException;

    /**
     *
     * @return set of games that everyone plays
     * @throws NoPopularGameException - when there isn't game that everyone plays
     */
    Set<Games> getPopularGames() throws NoPopularGameException;

    /**
     *
     * @param player - player with rating
     * @param game - game, in which we are interested in player rating
     * @return - rating as Object belongs to Integer class
     * @throws NoGameFoundException - when game was not found
     */
    Integer getRating(Player player, Games game) throws NoGameFoundException;

    /**
     *
     * @param game game, in which we are interested in players rating
     * @return sorted list of players, which plays in @param game
     * @throws NoGameFoundException - when game was not found
     */
    Player[] getTopTen(Games game)throws NoGameFoundException;

    /**
     *
     * @return sorted list of all players, who play in all games
     */
    List<Player> getAllTimeScoreLeader() ;
}
