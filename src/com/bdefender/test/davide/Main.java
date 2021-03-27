package com.bdefender.test.davide;

import com.bdefender.Pair;
import com.bdefender.enemies.EnemyFactory;
import com.bdefender.enemies.pool.EnemiesPoolImpl;
import com.bdefender.enemies.pool.EnemiesPoolMover;
import com.bdefender.map.Map;
import com.bdefender.map.MapLoader;
import com.bdefender.towers.TowerBase;
import com.bdefender.towers.TowerFactory;


public class Main {

	
	 public static void main(String[] args) {

		 Map map = MapLoader.getInstance().loadMap(Map.COUNTRYSIDE);
		 
		 EnemiesPoolImpl pool = new EnemiesPoolImpl(new MapInteractorImpl(map));
		 
		 EnemyFactory eFactory = new EnemyFactory();
		 
		 //pool.addEnemy(eFactory.getEnemy1(pool.getSpawnPoint()));
		 pool.addEnemy(eFactory.getEnemy2(pool.getSpawnPoint()));
		 
		 TowerFactory tFactory = new TowerFactory();
		 TowerBase tz1 = tFactory.getTowerZone1(pool, new Pair<>(5.0,5.0));
		 TowerBase tz2 = tFactory.getTowerZone2(pool, new Pair<>(15.0,0.0));
		 
		 Thread eThread = new EnemiesThread(pool);
		 Thread tThread1 = new TowerThread(tz1);
		 Thread tThread2 = new TowerThread(tz2);
		 
		 eThread.start();
		 //tThread1.start();
		 //tThread2.start();
		 
		 
	 }
	 
	 static class EnemiesThread extends Thread {
		 
		 private final EnemiesPoolMover mover;
		 
		 public EnemiesThread(EnemiesPoolMover pool) {
			 this.mover = pool;
		 }
		 
		 @Override
		 public void run(){
			 while(true){
				 try {
					 sleep(1000L);
					 mover.moveEnemies();
				 } catch (InterruptedException ex) {
					 System.out.println(ex.getMessage());
				 }
			 }
		 }
	 }
	 
	 static class TowerThread extends Thread {
		 
		 private final TowerBase tower;
		 
		 public TowerThread(TowerBase tower){
			 this.tower = tower;
		 }
		 
		 @Override
		 public void run() {
			 while(true){
				 try {
					 sleep(1000L * tower.getShootSpeed());
					 if (tower.shoot().isEmpty()) {
						 System.out.println("No more enemies around...");
					 }
				 } catch (Exception ex) {
					 System.out.println(ex.getMessage());
				 }
			 }
		 }
		 
	 }

}
