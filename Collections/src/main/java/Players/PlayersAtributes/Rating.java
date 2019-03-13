package Players.PlayersAtributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Rating {
    public Map<Games, Integer> ratingMap = new HashMap<>();


    public Rating(Set<Games> set) {
        for (Games game : set)
            this.ratingMap.put(game, 0);
    }

}
