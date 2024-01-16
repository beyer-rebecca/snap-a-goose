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
    }

    public class Level2 {
        public static List<Vec2> birdsPos = Arrays.asList(
                new Vec2(new Vec2(128, 374), new Vec2(122, 187)), 
                new Vec2(new Vec2(176, 86), new Vec2(126, 226)),
                new Vec2(new Vec2(1157, 275), new Vec2(1147, 1247)),
                new Vec2(new Vec2(1049, 441), new Vec2(1037, 1088)),
                new Vec2(new Vec2(850, 395), new Vec2(844, 894)),
                new Vec2(new Vec2(562, 530), new Vec2(558, 585))
                );
    }
    
    public class Level3 {
        public static List<Vec2> birdsPos = Arrays.asList(
                new Vec2(new Vec2(70, 624), new Vec2(0, 81)), 
                new Vec2(new Vec2(186, 393), new Vec2(177, 279)),
                new Vec2(new Vec2(437, 92), new Vec2(427, 543)),
                new Vec2(new Vec2(870, 429), new Vec2(860, 965)),
                new Vec2(new Vec2(1148, 279), new Vec2(1136, 1280))
                // new Vec2(new Vec2(562, 530), new Vec2(558, 585))
                );
    }
}
