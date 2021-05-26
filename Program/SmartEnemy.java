package Program;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        velX = (float) ((-1.0/distance) * diffX);
        velY = (float) ((-1.0/distance) * diffY);

        if (y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 44) velX *= -1;

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.blue,32,32,0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int) x, (int) y,32,32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y,32,32);
    }
}