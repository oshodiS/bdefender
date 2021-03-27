package com.bdefender.test.davide;


import java.util.ArrayList;
import java.util.List;


import com.bdefender.Pair;
import com.bdefender.enemies.pool.MapInteractor;
import com.bdefender.map.Coordinates;
import com.bdefender.map.Map;


public class MapInteractorImpl implements MapInteractor {
	Map map;

	public MapInteractorImpl(Map map){
		this.map = map;
	}

	@Override
	public List<Coordinates> getKeyPoints() {
		List<Coordinates> keyPoints = new ArrayList<>(map.getPath());
		keyPoints.remove(0);
		return keyPoints;
	}

	@Override
	public Pair<Integer, Integer> getStartingDirection() {
		//implementazione fittizia
		return new Pair<>(1, 0);
	}

	@Override
	public Coordinates getSpawnPoint() {
		return map.getPath().get(0);
	}


}
