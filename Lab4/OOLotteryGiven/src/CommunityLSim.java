import java.util.*;

public final class CommunityLSim {

  ArrayList<Player> players; 
  int numPeeps;
  Random random = new Random();
  private HashSet<Integer>[] peoples;

  public CommunityLSim( int numP) {
		numPeeps = numP;
  		players = new ArrayList<Player>();
		for (int i = 0; i < numPeeps; i++) {
			if (i < numPeeps/2.0) players.add(new Player(PlayerKind.POORLY_PAID, (float)(99+Math.random())));
			else players.add(new Player(PlayerKind.WELL_PAID, (float)(100.1+Math.random())));
		}
	}

	public int getSize() {
		return numPeeps;
	}

	public Player getPlayer(int i) {
		return players.get(i);
	}

	public void addPocketChange() {
		for (Player player: players){
			if(player.getKind().equals(PlayerKind.WELL_PAID)) player.addMoney(.1f);
			else player.addMoney(.03f);
		}
	}
	private void reDoWhoPlays() {
		HashSet<Integer> people = new HashSet<>();
		peoples = new HashSet[2];
		peoples[0] = randomUniqIndx((int)(numPeeps*0.3),0,numPeeps/2);
		peoples[1] = randomUniqIndx((int)(numPeeps*0.2),numPeeps/2,numPeeps);
	}
 	public HashSet randomUniqIndx(int numI, int startRange, int endRange) {
 		HashSet<Integer> indices = new HashSet<>();
 		while(indices.size()<numI) indices.add(random.nextInt(endRange-startRange)+startRange);
 		return indices;
	}
	public void simulateYears(int numYears) {
  		for (int year=0; year < numYears; year++) {
			reDoWhoPlays();
			addPocketChange();
			Game lotto = new Game();
			lotto.winningLotNumber();
			simulatePlayers(0,lotto);
			simulatePlayers(1,lotto);
			for (Player p : players) p.updateMoneyEachYear();
			Player max = players.get(0);
			Player min = max;
			for(Player player: players){
				if(player.getMoney() > max.getMoney()) max = player;
				if(player.getMoney() < min.getMoney()) min = player;
			}
			System.out.println("After year "+year+":");
			System.out.println("The person with the most money has: "+max.getMoney());
			System.out.println("The person with the least money has: "+ min.getMoney());
    	}
  }
  public void simulatePlayers(int num, Game lotto){
	  for(int index: peoples[num]){
		  Player p = players.get(index);
		  p.generateNewNums();
		  float gain = lotto.monetaryGain(p);
		  p.addMoney(gain);
		  if(-gain == 1) for(Player player: players){
		  		if(num==1) player.addMoney(0.3f/numPeeps);
		  		else player.addMoney(0.7f/numPeeps);
		  }
	  }
  }
}
