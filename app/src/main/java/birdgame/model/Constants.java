package birdgame.model;

import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import birdgame.utils.Vec2;

/**
 * Provides game constants, including fonts and image paths, and nested classes for level-specific configurations.
 * Each nested class in Constants defines the initial positions and boundaries of birds for a specific level in the Bird Game.
 */
public class Constants {

    
    public static final Font SMALL_FONT = new Font("TimesRoman", Font.PLAIN, 15);
    public static final Font TITLE_FONT = new Font("TimesRoman", Font.BOLD, 30);
    public static final Font NORMAL_FONT = new Font("TimesRoman", Font.BOLD, 20);
    public static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    /**
     * Level1 class contains constants for the first level of the Bird Game.
     */
    public class Level1 {
        /**
         * Static list of bird positions and boundaries for Level 1.
         * Each Vec2 pair represents the initial position and boundary coordinates of a bird.
         */
        public static List<Vec2> birdsPos = Arrays.asList(
                new Vec2(new Vec2(221, 323), new Vec2(215, 266)), 
                new Vec2(new Vec2(815, 370), new Vec2(815, 857)),
                new Vec2(new Vec2(30, 447), new Vec2(0, 54)),
                new Vec2(new Vec2(1089, 198), new Vec2(1098, 1122)),
                new Vec2(new Vec2(667, 538), new Vec2(667, 695)),
                new Vec2(new Vec2(452, 287), new Vec2(452, 485))
                );
    }

    /**
     * Level2 class contains constants for the second level of the Bird Game.
     */
    public class Level2 {
        /**
         * Static list of bird positions and boundaries for Level 2.
         */
        public static List<Vec2> birdsPos = Arrays.asList(
                new Vec2(new Vec2(128, 374), new Vec2(122, 187)), 
                new Vec2(new Vec2(176, 86), new Vec2(126, 226)),
                new Vec2(new Vec2(1157, 275), new Vec2(1147, 1247)),
                new Vec2(new Vec2(1049, 441), new Vec2(1037, 1088)),
                new Vec2(new Vec2(850, 395), new Vec2(844, 894)),
                new Vec2(new Vec2(562, 530), new Vec2(558, 585))
                );
    }
    
    /**
     * Level3 class contains constants for the third level of the Bird Game.
     */
    public class Level3 {
        /**
         * Static list of bird positions and boundaries for Level 3.
         */
        public static List<Vec2> birdsPos = Arrays.asList(
                new Vec2(new Vec2(70, 624), new Vec2(0, 81)), 
                new Vec2(new Vec2(186, 393), new Vec2(177, 279)),
                new Vec2(new Vec2(437, 92), new Vec2(427, 543)),
                new Vec2(new Vec2(870, 429), new Vec2(860, 965)),
                new Vec2(new Vec2(1148, 279), new Vec2(1136, 1280))
                );
    }
}
