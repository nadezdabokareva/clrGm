import action.Collisions;
import action.Score;
import action.Spawn;
import data.Enemy;
import data.Player;
import data.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimpleGame extends JPanel implements ActionListener, KeyListener {

    public SimpleGame(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        data.Window.timer = new Timer(100, this);
        data.Window.timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My first game");
        SimpleGame game = new SimpleGame();
        frame.add(game);

        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, data.Window.weight, data.Window.height);
        g.setColor(Color.WHITE);
        g.fillRect(Player.playerX, Player.playerY, 50, 50);

        for (int i = 0; i < Enemy.enemyX.size(); i++) {
            g.setColor(Color.RED);
            g.fillOval(Enemy.enemyX.get(i), Enemy.enemyY.get(i), 20, 20);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + data.Window.score, 10, 30);

        if (data.Window.gameOver) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("GAME OVER", 120, 300);
            data.Window.timer.stop();
        }

        if (data.Window.score == data.Window.record) {
            g.setColor(Color.ORANGE);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("YOUR RECORD", 120, 300);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if (!data.Window.gameOver) {
                for (int i = 0; i < Enemy.enemyX.size(); i++) {
                    Enemy.enemyY.set(i, Enemy.enemyY.get(i) + Enemy.enemySpeed);
                    if (Enemy.enemyY.get(i) >= data.Window.height) {
                        Enemy.enemyX.remove(i);
                        Enemy.enemyY.remove(i);
                        data.Window.score++;
                    }
                }
                repaint();

                if (Enemy.enemyX.isEmpty()) {
                    Spawn.spawnEnemy();  // Создаем нового врага, если текущих нет на экране
                }
                Collisions.checkCollision();  // Проверяем коллизию игрока с врагами
            }

            Score.levelUp(this);
            Score.checkScore();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (!Window.gameOver) {
            if (key == KeyEvent.VK_LEFT && Player.playerX > 0) {
                Player.playerX -= Player.playerSpeed;  // Перемещаем игрока влево
            }
            if (key == KeyEvent.VK_RIGHT && Player.playerX < 350) {
                Player.playerX += Player.playerSpeed;  // Перемещаем игрока вправо
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
