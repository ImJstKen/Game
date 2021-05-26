package Program;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random r = new Random();

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my,880,360,200,64) && game.gameState == Game.STATE.Menu) {
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            return;
        } else if (mouseOver(mx, my,880,520,200,64) && game.gameState == Game.STATE.Menu) {
            if (mouseOver(mx, my,1,1,1,1) && game.gameState == Game.STATE.Quit) {
                System.exit(1);
            }
        } else if (mouseOver(mx, my,880,440,200,64) && game.gameState == Game.STATE.Menu) {
            game.gameState = Game.STATE.Help;
            return;
        } else if (mouseOver(mx, my,880,700,200,64) && game.gameState == Game.STATE.Help) {
            game.gameState = Game.STATE.Menu;
            return;
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
              return true;
            } else return false;
        } else return false;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 910, 100);

            g.drawRect(880,360,200,64);
            g.drawString("Play", 925, 410);

            g.drawRect(880,440,200,64);
            g.drawString("Help", 925, 490);

            g.drawRect(880,520,200,64);
            g.drawString("Quit", 925, 570);
        } else if (game.gameState == Game.STATE.Help) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 910, 100);

            g.setFont(fnt2);
            g.drawString("- Press [WASD] or [Arrow keys] to move the player", 650, 400);
            g.drawString("- Dodge the enemies to survive", 650, 450);
            g.drawString("- Survive as long as you can to get coins", 650, 500);

            g.setFont(fnt);
            g.drawRect(880,700,200,64);
            g.drawString("Back", 925, 750);
        }
    }
}