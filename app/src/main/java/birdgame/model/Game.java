package birdgame.model;

public class Game {
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private final String level1Image = "level1.jpg";
    private final String level1Mask ="level1_mask.png";

    private final String level2Image="level2.jpg";
    private final String level2Mask= "level2_mask.png";

    private final String level3Image="level3.jpg";
    private final String level3Mask ="level3_mask.png";


    public int getFPS_SET(){
        return FPS_SET;
    }

    public int getUPS_SET(){
        return UPS_SET;
    }

    public String getLevel1Image() {
        return level1Image;
    }

    public String getLevel1Mask() {
        return level1Mask;
    }

    public String getLevel2Image() {
        return level2Image;
    }

    public String getLevel2Mask() {
        return level2Mask;
    }

    public String getLevel3Image() {
        return level3Image;
    }

    public String getLevel3Mask() {
        return level3Mask;
    }
}