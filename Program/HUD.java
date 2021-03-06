package Program;

import java.awt.*;
import java.lang.*;
import java.util.concurrent.*;

public class HUD {

    private Game game;

    public static float HEALTH = 100;

    private float score = 0;
    private float level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH,0,100);

        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);
        g.setColor(Color.getHSBColor( (HEALTH) / 360, 1f, 1f));
        g.fillRect(15,15,(int) HEALTH * 2,32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);

        g.drawString("Score: " + score,15,1000);
        g.drawString("Level: " + level,15,900);
    }

    public void score(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }
}