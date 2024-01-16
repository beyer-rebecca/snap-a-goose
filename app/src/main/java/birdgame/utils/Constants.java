package birdgame.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public class Level1 {
        public static List<Vec2> birdsPos = Arrays.asList(
                new Vec2(new Vec2(221, 323), new Vec2(215, 266)), 
                new Vec2(new Vec2(815, 370), new Vec2(815, 857)),
                new Vec2(new Vec2(30, 447), new Vec2(0, 54)),
                new Vec2(new Vec2(1089, 198), new Vec2(1098, 1122)),
                new Vec2(new Vec2(667, 538), new Vec2(667, 695)),
                new Vec2(new Vec2(452, 287), new Vec2(452, 485))
                );
        public static int birdsSize = birdsPos.size();
        public static int BIRD_WIDTH = 20;
        public static int BIRD_HEIGHT = 40;

    }

    
}
