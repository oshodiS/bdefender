package com.bdefender.test.davide;


import java.util.List;


import com.bdefender.Pair;
import com.bdefender.enemies.pool.MapInteractor;


public class MapInteractorImpl implements MapInteractor {

	@Override
	public List<Pair<Double, Double>> getKeyPoints() {
		//implementazione fittizia
		return List.of(new Pair<>(10.0,0.0), new Pair<>(10.0, 10.0), new Pair<>(20.0, 10.0), new Pair<>(20.0, 0.0), new Pair<>(30.0, 0.0));
	}

	@Override
	public Pair<Integer, Integer> getStartingDirection() {
		//implementazione fittizia
		return new Pair<>(1, 0);
	}
	
	

}
