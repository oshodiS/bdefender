package map;

import java.util.List;

import towers.Pair;


public interface MapInteractor {
	
	public List<Pair<Double, Double>> getKeyPoints();
	
	public Pair<Integer, Integer> getStartingDirection(); 

}
