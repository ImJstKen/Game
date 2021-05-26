package Program;

import java.awt.*;
import java.util.*;

public class EnemyBossBullet extends GameObject {

    private Handler handler;
    Random r = new Random();

    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    }

    public void tick() {
        x += velX;
        y += velY;

        /*if (y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 44) velX *= -1;*/

        if (y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.red,22,22,0.02f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y,22,22);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y,22,22);
    }
}