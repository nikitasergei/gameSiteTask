import Exceptions.NoGameFoundException;
import Exceptions.NoPopularGameException;
import Exceptions.UserAlreadyExistsException;
import Players.Player;
import Players.PlayersAtributes.Games;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class testingTask {


    @Test
    public void testPositiveCreateSite() {
        Site site = new Site();
        Assert.assertNotNull(site);
    }

    @Test
    public void testCreatePlayerPositive() throws UserAlreadyExistsException {
        Site site = new Site();
        Player player = site.createPlayer("Player", Games.GAME1, Games.GAME2, Games.GAME3);
        Assert.assertNotNull(player);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void testCreatePlayerNegative() throws UserAlreadyExistsException {
        Site site = new Site();
        Player player = site.createPlayer("Player", Games.GAME1, Games.GAME2, Games.GAME3);
        Assert.assertNotNull(player);
        Player player1 = site.createPlayer("Player", Games.GAME1, Games.GAME2, Games.GAME3);
        Assert.assertNotNull(player1);
    }

    @Test
    public void testPlayerWinPositive() throws UserAlreadyExistsException, NoGameFoundException {
        Site site = new Site();
        Player player = site.createPlayer("Player", Games.GAME1, Games.GAME2, Games.GAME3);
        Assert.assertNotNull(player);
        site.win(player, Games.GAME1);
        site.win(player, Games.GAME2);
        site.win(player, Games.GAME3);
        Assert.assertEquals((Integer) 3, player.getRatingInAllGames());
        Assert.assertEquals((Integer) 1, player.rating.ratingMap.get(Games.GAME1));
        Assert.assertEquals((Integer) 1, player.rating.ratingMap.get(Games.GAME2));
        Assert.assertEquals((Integer) 1, player.rating.ratingMap.get(Games.GAME3));
    }

    @Test(expected = NoGameFoundException.class)
    public void testPlayerWinNegative() throws UserAlreadyExistsException, NoGameFoundException {
        Site site = new Site();
        Player player = site.createPlayer("Player", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player1 = site.createPlayer("Player1", Games.GAME4, Games.GAME5, Games.GAME6);
        site.win(player, Games.GAME6);
    }

    @Test
    public void testPopularGamePositive() throws UserAlreadyExistsException, NoPopularGameException {
        Site site = new Site();
        Player player1 = site.createPlayer("Player1", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player2 = site.createPlayer("Player2", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player3 = site.createPlayer("Player3", Games.GAME1, Games.GAME2, Games.GAME6);
        Player player4 = site.createPlayer("Player4", Games.GAME1, Games.GAME4, Games.GAME2);
        Player player5 = site.createPlayer("Player5", Games.GAME1, Games.GAME2, Games.GAME6);
        System.out.println(site.getPopularGames());
    }

    @Test(expected = NoPopularGameException.class)
    public void testPopularGameNegative() throws UserAlreadyExistsException, NoPopularGameException {
        Site site = new Site();
        Player player1 = site.createPlayer("Player1", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player2 = site.createPlayer("Player2", Games.GAME2, Games.GAME3, Games.GAME4);
        Player player3 = site.createPlayer("Player3", Games.GAME4, Games.GAME5, Games.GAME6);
        Player player4 = site.createPlayer("Player4", Games.GAME2, Games.GAME3, Games.GAME6);
        Player player5 = site.createPlayer("Player5", Games.GAME1, Games.GAME1, Games.GAME1);
        System.out.println(site.getPopularGames());
    }

    @Test
    public void testGetRatingPositive() throws UserAlreadyExistsException, NoPopularGameException, NoGameFoundException {
        Site site = new Site();
        Player player1 = site.createPlayer("Player1", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player2 = site.createPlayer("Player2", Games.GAME1, Games.GAME3, Games.GAME2);
        site.win(player1, Games.GAME2);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player2, Games.GAME2);
        Assert.assertEquals((Integer) 2, site.getRating(player1, Games.GAME3));
        Assert.assertEquals((Integer) 1, site.getRating(player2, Games.GAME2));
    }

    @Test(expected = NoGameFoundException.class)
    public void testGetRatingNegative() throws UserAlreadyExistsException, NoGameFoundException {
        Site site = new Site();
        Player player1 = site.createPlayer("Player1", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player2 = site.createPlayer("Player2", Games.GAME1, Games.GAME3, Games.GAME2);
        site.win(player1, Games.GAME2);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player2, Games.GAME2);
        site.getRating(player1, Games.GAME4);
        site.getRating(player1, Games.GAME4);
    }

    @Test
    public void testTopTenPositive() throws UserAlreadyExistsException, NoGameFoundException {
        Site site = new Site();
        Player player1 = site.createPlayer("Player1", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player2 = site.createPlayer("Player2", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player3 = site.createPlayer("Player3", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player4 = site.createPlayer("Player4", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player5 = site.createPlayer("Player5", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player6 = site.createPlayer("Player6", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player7 = site.createPlayer("Player7", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player8 = site.createPlayer("Player8", Games.GAME1, Games.GAME3, Games.GAME2);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player4, Games.GAME3);
        site.win(player2, Games.GAME3);
        site.win(player3, Games.GAME3);
        site.win(player5, Games.GAME3);
        site.win(player6, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player4, Games.GAME3);
        site.win(player6, Games.GAME3);
        site.win(player6, Games.GAME3);
        site.win(player6, Games.GAME3);
        site.win(player6, Games.GAME3);
        System.out.println(Arrays.toString(site.getTopTen(Games.GAME3)));
    }

    @Test (expected = NoGameFoundException.class)
    public void testTopTenNegative() throws UserAlreadyExistsException, NoGameFoundException {
        Site site = new Site();
        Player player1 = site.createPlayer("Player1", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player2 = site.createPlayer("Player2", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player3 = site.createPlayer("Player3", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player4 = site.createPlayer("Player4", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player5 = site.createPlayer("Player5", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player6 = site.createPlayer("Player6", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player7 = site.createPlayer("Player7", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player8 = site.createPlayer("Player8", Games.GAME1, Games.GAME3, Games.GAME2);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player4, Games.GAME3);
        site.win(player2, Games.GAME2);
        site.win(player3, Games.GAME2);
        site.win(player5, Games.GAME1);
        site.win(player1, Games.GAME2);
        System.out.println(Arrays.toString(site.getTopTen(Games.GAME4)));
    }

    @Test
    public void testAllTimeScoreLeaderPositive() throws UserAlreadyExistsException, NoGameFoundException {
        Site site = new Site();
        Player player1 = site.createPlayer("Player1", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player2 = site.createPlayer("Player2", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player3 = site.createPlayer("Player3", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player4 = site.createPlayer("Player4", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player5 = site.createPlayer("Player5", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player6 = site.createPlayer("Player6", Games.GAME1, Games.GAME3, Games.GAME2);
        Player player7 = site.createPlayer("Player7", Games.GAME1, Games.GAME2, Games.GAME3);
        Player player8 = site.createPlayer("Player8", Games.GAME1, Games.GAME3, Games.GAME2);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME3);
        site.win(player1, Games.GAME2);
        site.win(player4, Games.GAME3);
        site.win(player4, Games.GAME3);
        site.win(player2, Games.GAME2);
        site.win(player2, Games.GAME3);
        site.win(player2, Games.GAME3);
        site.win(player3, Games.GAME2);
        site.win(player5, Games.GAME1);
        System.out.println(site.getAllTimeScoreLeader());
    }



}