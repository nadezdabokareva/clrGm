package action;

import data.Enemy;

import java.awt.*;

public class Score {
    public static void checkScore() {
        Graphics g = null;
        if (data.Window.score == data.Window.record) {
            g.setColor(Color.ORANGE);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("YOUR RECORD", 120, 300);
        }
    }

    public static <SimpleGame> void levelUp(SimpleGame simpleGame) {
        if (data.Window.score > 20) {
            Enemy.enemySpeed = (int) (Enemy.enemySpeed + 1);
        } else if (data.Window.score > 35) {
            Enemy.enemySpeed = (int) (Enemy.enemySpeed + 2);
        }else if (data.Window.score > 40) {
            Enemy.enemySpeed = (int) (Enemy.enemySpeed + 3);
        }
    }
}
