package enemies.pool;

import java.util.ArrayList;

import enemies.EnemyBase;

public interface EnemiesPoolInteractor {
	ArrayList<EnemyBase> getEnemies();

	void applyDamageById(int id, Double damage);
}
