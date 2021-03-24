package towers.controllers;
import java.util.Map;

import towers.Pair;

public interface EnemyController {

		public Map<Integer, Pair<Double, Double>>getEnemiesInZone(double radius, Pair<Double, Double> center);
		
	
}
