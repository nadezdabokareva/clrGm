package action;

import data.Enemy;
import data.Player;

import java.awt.*;

public class Collisions {
    public static void checkCollision() {
        Rectangle playerBounds = new Rectangle(Player.playerX, Player.playerY, 50, 50);  // Границы игрока
        for (int i = 0; i < Enemy.enemyX.size(); i++) {
            Rectangle enemyBounds = new Rectangle(Enemy.enemyX.get(i), Enemy.enemyY.get(i), 20, 20);  // Границы врага
            if (playerBounds.intersects(enemyBounds)) {
                data.Window.gameOver = true;  // Если произошло столкновение, игра заканчивается
                break;
            }
        }
    }
}
