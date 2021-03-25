package com.bdefender.enemies.pool;


import com.bdefender.Pair;

import java.util.List;

public interface MapInteractor {
	
	public List<Pair<Double, Double>> getKeyPoints();
	
	public Pair<Integer, Integer> getStartingDirection(); 

}
