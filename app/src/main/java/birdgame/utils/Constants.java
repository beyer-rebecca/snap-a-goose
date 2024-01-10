package birdgame.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public class Level1 {
        public static List<Vec2> birdsPos = Arrays.asList(
                new Vec2(240, 325), 
                new Vec2(835, 370),
                new Vec2(30, 447),
                new Vec2(1108, 198),
                new Vec2(683, 538),
                new Vec2(470, 287)
                );
    }

    public class Window {
        public static int WINDOW_WIDHT = 1280;
        public static int WINDOW_HEIGHT = 720;
    }
}
