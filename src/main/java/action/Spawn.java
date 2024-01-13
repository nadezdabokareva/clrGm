package action;

import data.Enemy;

import java.util.Random;

public class Spawn {
    public static void spawnEnemy() {
        Random rand = new Random();
        int numEnemies = rand.nextInt(5) + 1; // Генерируем от 1 до 5 врагов за раз
        for (int i = 0; i < numEnemies; i++) {
            int x = rand.nextInt(350); // Генерируем случайную X-координату для врага
            int y = 0;
            Enemy.enemyX.add(x);
            Enemy.enemyY.add(y); // Добавляем врага в списки координат
        }
    }
}
