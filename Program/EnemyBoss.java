package Program;

import java.awt.*;
import java.util.*;

public class EnemyBoss extends GameObject {

    private Handler handler;
    Random r = new Random();

    private int timer   = 50;
    private int timer2  = 50;

    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 5;
    }

    public void tick() {
        x += velX;
        y += velY;

        //if (y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 118) velX *= -1;

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0) {
            if (velX == 0) velX = 5;

            if (velX > 0)
                velX += 0.005f;
            else if (velX < 0)
                velX -= 0.005f;

            velX = Game.clamp(velX,-10,10);

            int spawn = r.nextInt(10);
            if (spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 50, (int) y + 50, ID.BasicEnemy, handler));
        }

        //handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red,100,100,0.032f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y,100,100);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y,100,100);
    }
}